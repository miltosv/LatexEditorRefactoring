package controller.commands;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import model.VersionsManager;

public class AddLatexCommand implements Command  {
	private VersionsManager versionsManager;
	private HashMap<String, String> latexCommands;
	private static final int ID=0;
	private static final int CONTENTS=1;
	private static final String LatexCommandFilePath ="src\\resources\\settings\\latexCommands";
	
	
	public AddLatexCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
		latexCommands = new HashMap<String,String>();
		this.dynamicallyCreateLatexCommands();
		
	}

	private void dynamicallyCreateLatexCommands(){
		
		try {
			BufferedReader DocumentSpecsReader = new BufferedReader(
					new FileReader (LatexCommandFilePath)
					);
			
			String currrentSpec;
			while ((currrentSpec = DocumentSpecsReader.readLine()) != null) {
				String keyStateConfigPair[] = currrentSpec.split(" ");
				String contents = (new String(readAllBytes(get(keyStateConfigPair[CONTENTS]))));
				String key = keyStateConfigPair[ID];
				latexCommands.put(key,contents);				
			}
			DocumentSpecsReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.saveContents();
	}

}
