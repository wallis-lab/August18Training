package basses;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

public class TestFileRead{

	@Test
	public void canGetConfigFileValue() throws Exception{
		HashMap<String,String> configFileProperties = null;
		String fileName = "config.properties";
		String ExpectBrowerType = "Chrome";
		
		configFileProperties = new ConfigurationProvider().getPropertiesFromResourceFile(fileName);
		String ActualBrowerTpe = configFileProperties.get("browserType");
		
		assertTrue("We are not get the same ChormeDriver type ", ActualBrowerTpe.equals(ExpectBrowerType));
	}
	
	@Test
	public void canReadBassesCsvFileIntoHashMap(){
		HashMap<String, ArrayList<String>> ExpectBasses = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> ActualBasses = new HashMap<String, ArrayList<String>>();

		CsvReader reader = new CsvReader();
		ExpectBasses= reader.getExceptCsvFileInHashMap();
		ActualBasses= reader.getCsvFileAndIntoHashMap();
		
		assertTrue(ActualBasses.equals(ExpectBasses));
	}

}
