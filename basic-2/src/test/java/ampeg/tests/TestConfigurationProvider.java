package ampeg.tests;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import static org.junit.Assert.assertTrue;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import com.opencsv.CSVReader;
import framework.ConfigurationProvider;
import net.bytebuddy.description.type.TypeDefinition.SuperClassIterator;
import okhttp3.MultipartBody.Part;

public class TestConfigurationProvider {

	/*@Test
	public void canGetConfigFileValue() throws Exception{
		
		String fileName = "config.properties";
		String browerType = "Chrome";
		HashMap<String,String> configFileProperties = null;
		
		configFileProperties = new ConfigurationProvider().getPropertiesFromResourceFile(fileName);
		String browerTpe = configFileProperties.get("browserType");
		
		assertTrue("not chrome ", browerTpe.equals(browerType));
	}*/
	
	@Test
	public void can() throws IOException{
		
		BufferedReader reader = null;
		
		String fileName = "basses.csv";
		/*inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		System.out.println(inputStream);
		CSVReader csv = new CSVReader(inputStream);*/
		
		    //declare reader and writer
		BufferedReader reader1 = new BufferedReader(new FileReader(new File("./resources/basses.csv")));
		String lineTxt = null;
		HashMap<String, ArrayList> custom1 = new HashMap<String, ArrayList>();
		
		HashMap<String, String[]> custom2 = new HashMap<String, String[]>();
		
		/*while ((lineTxt = reader1.readLine()) != null) {
			String line = lineTxt.trim();
			String[] part = line.split(",");
			
			if (!custom1.containsKey(part[0])){
				custom1.put(part[0], new ArrayList());
			}	
			else{
				custom1.get(part[0]).add(part[1]);
			}		
		}
		System.out.println(custom1.containsKey("Model"));*/
		
		/*lineTxt = reader1.readLine();
		String line = lineTxt.trim();
		String[] part = line.split(",");
		System.out.println(lineTxt);
		System.out.println(line);
		
		//custom2.put(part[0], new String());
		//custom2.put(part[1], new ArrayList());
		
		custom1.get(part[0]).add(part[1]);*/

		String line ;
		String[] array= {};
		int index = 0;
		while((line = reader1.readLine())!=null){
			int i =0;
			String[] name = line.split(",");

            if(index==0){		
			String last = name[1];//这就是你要的数据了 
	        System.out.println(last);
	        array[i]=last;}
	        i++;	
		}
		for (int i = 0; i < array.length; i++) 
			System.out.println(array[i]);
		//System.out.println(name);
		/*int index =0;
		int row=1;
		int col=0;
		while((line=reader.readLine())!=null){
            String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
         if(index==row-1){
             if(item.length>=col-1){
                 String last = item[col-1];//这就是你要的数据了 
                 System.out.println(last);         
             }
         }
         //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
         index++;
		line = reader1.readLine();
		System.out.println(line);*/
		
		//System.out.println(custom1.get("Model"));
		/*String name = line.split(",")[0];
		custom2.put(part[0], new String());
		System.out.println(line.split(",")[0]);
		System.out.println(line.split(",")[1]);
		if (name=="Make") {
			for (int i = 0; i < line)
		}
		if (name=="Make") {
			
		}*/
		//reader1.close();
		//System.out.println(reader1.);
		
		/*line = reader1.readLine();
		
		System.out.println(line);
		System.out.println(line.split(",")[0].indent(0));
		
		System.out.println(line.split(",")[0].length());
		System.out.println(line.split(",")[1].length());
		System.out.println(line.split(",")[2].length());*/
		

		/*System.out.println(reader1);
		String line = reader1.readLine();
		//System.out.println(reader1.size());
		//custom.put(key, value);
		String[] part = line.split(",");
		
		/*for (int i= 0; i < part.length; i++)
			System.out.println(part[i]);
	
		System.out.println(part[2]);
		System.out.println(reader1.getValues());
		
		
		String line2 = lineTxt.trim();*/
		
		//System.out.println(custom1);
		
	}
	@Test
	public void test6() throws IOException{
		
		HashMap<String, ArrayList<String>> custom1 = new HashMap<String, ArrayList<String>>();
		ArrayList<String> users = new ArrayList<String>();
		ArrayList<String> users1 = new ArrayList<String>();
		  try(
	             BufferedReader br = new BufferedReader(new FileReader("./resources/basses.csv"));
	             CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);
	         ) {
	            for(CSVRecord record : parser) {
	                //System.out.println(record.get("Make"));
	                users.add(record.get("Make"));
	               // System.out.println(record.get("Model"));
	                users1.add(record.get("Model"));
	               
	            }
	            custom1.put("Make", users);
	            custom1.put("Model", users1);
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		  
		  
		  System.out.println(custom1);
	}

}
