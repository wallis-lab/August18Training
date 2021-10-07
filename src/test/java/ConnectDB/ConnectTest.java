package ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConnectTest {
	String url = "jdbc:mysql://localhost:3306/sakila";
	String username = "root";
	String password = "Ww233787";

	@Test
	public void Test1() {

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from city order by city desc limit 10");  

			if (rs.next()) {
				String city = rs.getString("city");
				//System.out.println(city.length());
				Assert.assertEquals(city.length(),10,"size is not correct");
				Assert.assertEquals(rs.getString(1),"600", "city id  is not correct");
				Assert.assertEquals(rs.getString(2),"Ziguinchor", "city is not correct");
				Assert.assertEquals(rs.getString(3),"83", "country id is not correct");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);}  	
	}	

	@Test
	public void Test2() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select title from film where title like '%airplane%'");  

			if (rs.next()) {
				Assert.assertEquals(rs.getString(1),"AIRPLANE SIERRA", "the title is not expected");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test3() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT max(payment.amount) As highest_amount FROM payment");  

			if (rs.next()) {
				Assert.assertEquals(rs.getString(1),"11.99", "the amount is not the max one");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test4() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT count(store_id) As TotalRecords FROM customerWHERE store_id=1");  

			if (rs.next()) {
				Assert.assertEquals(rs.getString(1),"326", " id number is not expected");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test5() {
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM customer As c LEFT join payment As p ON c.customer_id=p.customer_id WHERE c.email = 'NANCY.THOMAS@sakilacustomer.org'");  

			while (rs.next()) {
				list.add(rs.getString("amount"));	
			}

			Assert.assertEquals(list.size(),28, "the size is not the expected size");
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test6() {

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM actor_info AS a WHERE a.first_name='Bob' and a.last_name='Fawcett'");
			if (rs.next()) {
				Assert.assertEquals(rs.getString("first_name"),"BOB", "not the same first name");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test7() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  

			stmt.executeQuery("SET @findid =(SELECT f.film_id FROM film as f WHERE f.title='Alien Center')");	
			stmt.executeQuery("SET @filmCount = 0");
			stmt.executeQuery("CALL film_in_stock(@findid, 2, @filmCount)");
			ResultSet rs= stmt.executeQuery("Select @filmCount");
			if(rs.next()) {
				Assert.assertEquals(rs.getInt(1),4);
			}

			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test8() {

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement(); 

			stmt.executeUpdate("INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username) VALUES ('John', 'Doe', '18', 'rando@gmail.com', '2', '1', 'newJohn')");
			stmt.executeQuery("SET @staffId = LAST_INSERT_ID()");
			stmt.executeUpdate("INSERT INTO address (address, district, city_id, phone, location) VALUES ('wenlong', 'Dime Box', 300, 7137778888, ST_GeomFromText('POINT(1 1)'))");
			stmt.executeQuery("SET @addressId = LAST_INSERT_ID()");
			stmt.executeUpdate("INSERT INTO store (manager_staff_id, address_id) VALUES (@staffId, @addressId)");
			stmt.executeQuery("SET @storeId = LAST_INSERT_ID()");
			stmt.executeUpdate("UPDATE staff SET store_id = @storeId WHERE staff_id = @staffId");	

			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test9() {

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  

			stmt.executeQuery("SET SQL_SAFE_UPDATES = 0");
			stmt.executeUpdate("UPDATE store INNER JOIN address ON address.address_id = store.address_id SET store.last_update = CURDATE() WHERE address.address = 'wenlong'");
			stmt.executeQuery("SET SQL_SAFE_UPDATES = 1");

			con.rollback();
			con.close();
		}catch(Exception e){ 
			System.out.println(e);} 
	}

	@Test
	public void Test10() {

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  

			stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
			stmt.executeLargeUpdate("DELETE s.* FROM store As s INNER JOIN address AS a ON a.address_id = s.address_id WHERE a.address = 'wenlong'");
			stmt.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}	
}
