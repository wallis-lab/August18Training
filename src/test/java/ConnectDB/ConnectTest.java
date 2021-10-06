package ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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
				Assert.assertEquals(city.length(),10,"size is correct");
				Assert.assertEquals(rs.getString(1),"600", "");
				Assert.assertEquals(rs.getString(2),"Ziguinchor", "");
				Assert.assertEquals(rs.getString(3),"83", "");
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
				Assert.assertEquals(rs.getString(1),"AIRPLANE SIERRA", "");
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
				Assert.assertEquals(rs.getString(1),"11.99", "");
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
				Assert.assertEquals(rs.getString(1),"326", "");
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
			
			Assert.assertEquals(list.size(),28, "");
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}
	
	@Test
	public void Test6() {
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM actor_info AS a WHERE a.first_name='Bob' and a.last_name='Fawcett'");
			if (rs.next()) {
				Assert.assertEquals(rs.getString("first_name"),"BOB", "");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}
	
	@Test
	public void Test7() {
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM actor_info AS a WHERE a.first_name='Bob' and a.last_name='Fawcett'");
			if (rs.next()) {
				Assert.assertEquals(rs.getString("first_name"),"BOB", "");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}
	
	@Test
	public void Test8() {
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM actor_info AS a WHERE a.first_name='Bob' and a.last_name='Fawcett'");
			if (rs.next()) {
				Assert.assertEquals(rs.getString("first_name"),"BOB", "");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}
	
	@Test
	public void Test9() {
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM actor_info AS a WHERE a.first_name='Bob' and a.last_name='Fawcett'");
			if (rs.next()) {
				Assert.assertEquals(rs.getString("first_name"),"BOB", "");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}
	
	@Test
	public void Test10() {
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					url,username,password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM actor_info AS a WHERE a.first_name='Bob' and a.last_name='Fawcett'");
			if (rs.next()) {
				Assert.assertEquals(rs.getString("first_name"),"BOB", "");
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);} 
	}
	
	
	
}