package controller;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import controller.commands.AddLatexCommand;
import controller.commands.ChangeVersionsStrategyCommand;
import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.commands.CreateCommand;
import controller.commands.DisableVersionsManagementCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import controller.commands.LoadCommand;
import controller.commands.RollbackToPreviousVersionCommand;
import controller.commands.SaveCommand;
import model.Document;
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
	}
}
