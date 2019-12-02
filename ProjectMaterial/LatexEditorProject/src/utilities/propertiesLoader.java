package utilities;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class propertiesLoader {
	//private String filePath;
	private static final int ID=0;
	private static final int CONTENTS=1;
	
	public HashMap<String,String> readFile(String path) {
		HashMap<String,String> objecToBeReturned=new HashMap<String,String>();
		try {
			BufferedReader DocumentSpecsReader = new BufferedReader(
					new FileReader (path)
					);
		
			String currrentSpec;
			while ((currrentSpec = DocumentSpecsReader.readLine()) != null) {
				String keyStateConfigPair[] = currrentSpec.split(" ");
				String contents = (new String(readAllBytes(get(keyStateConfigPair[CONTENTS]))));
				String key = keyStateConfigPair[ID];
				objecToBeReturned.put(key,contents);				
			}
			DocumentSpecsReader.close();
			return objecToBeReturned;
		} catch (Exception e) {
			e.printStackTrace();
			return objecToBeReturned;
		}
	}
	
}
	
	


