package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import controller.commands.Command;
import controller.commands.CommandFactory;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;
import view.MainWindow;

public class LatexEditorController{
	private HashMap<String, Command> commands;
	private VersionsManager versionsManager;
	private DocumentManager documentManager;
	private MainWindow mainWindow;
	private LatexEditorView editorView;
	
	public LatexEditorController(VersionsManager versionsManager,LatexEditorView latexView) {
		//CommandFactory commandFactory = new CommandFactory(versionsManager);
		editorView=latexView;
		mainWindow=editorView.getMainWindow();
		this.versionsManager=versionsManager;
		commands = new HashMap<String, Command>(); 
		this.dynamicallyCreateCommands("src\\resources\\settings\\commands");
		
	}
	private void dynamicallyCreateCommands(String PropertiesFilePath){
		
		CommandFactory commandFactory = new CommandFactory(versionsManager,mainWindow,editorView);
		try {
			BufferedReader CommandsSpecsReader = new BufferedReader(
					new FileReader (PropertiesFilePath)
					);
			
			String currentSpec;
			while ((currentSpec = CommandsSpecsReader.readLine()) != null) {
				commands.put(currentSpec,commandFactory.createCommand(currentSpec));	
				
			}
			CommandsSpecsReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void enact(String command) {
		commands.get(command).execute();
		if(mainWindow!=null) {
			mainWindow.update();
		}
	}
}
