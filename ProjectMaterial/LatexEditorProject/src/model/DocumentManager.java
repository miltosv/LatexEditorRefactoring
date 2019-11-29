package model;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class DocumentManager {
	private HashMap<String, Document> templates;
	private static final int ID=0;
	private static final int CONTENTS=1;
	private static final String TemplateFilePath ="src\\resources\\settings\\templateSettings";
	
	public DocumentManager() {
		templates = new HashMap<String, Document>();
		this.dynamicallyCreateDocuments();
		
	}
	
	public Document createDocument(String type) {
		return templates.get(type).clone();
	}
	
	private void dynamicallyCreateDocuments(){
		
		try {
			BufferedReader DocumentSpecsReader = new BufferedReader(
					new FileReader (TemplateFilePath)
					);
			
			String currrentSpec;
			while ((currrentSpec = DocumentSpecsReader.readLine()) != null) {
				String keyStateConfigPair[] = currrentSpec.split(" ");
				String contents=(new String(readAllBytes(get(keyStateConfigPair[CONTENTS]))));
				String key=keyStateConfigPair[ID];
				Document doc = new Document();
				doc.setContents(contents);
				templates.put(key,doc);				
			}
			DocumentSpecsReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
