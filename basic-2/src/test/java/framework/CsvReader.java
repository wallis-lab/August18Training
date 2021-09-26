package framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Properties;

public class CsvReader {
	public HashMap<String, String> getBassesFileFromResourceFile(String fileName) throws ParseException, IOException {
		
		 @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("test.csv"));
		    String line =  null;
		    HashMap<String,String> map = new HashMap<String, String>();

		    while((line=br.readLine())!=null){
		    	String str[] = line.split(",");
		        for(int i=1;i<str.length;i++){
		            String arr[] = str[i].split(":");
		            map.put(arr[0], arr[1]);
		        }
		    }
		    System.out.println(map);
			return map;
		 }		
}
