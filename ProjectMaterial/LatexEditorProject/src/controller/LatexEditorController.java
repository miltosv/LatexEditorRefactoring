package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import controller.commands.Command;
import controller.commands.CommandFactory;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import model.encryption.CipherManager;
import view.MainWindow;

public class LatexEditorController{
	private HashMap<String, Command> commands;
	private String typeOfDocument;
	private String filePathName;
	private Document currentDocument;
	
	
	private VersionsManager versionsManager;
	private DocumentManager documentManager;
	private CipherManager ciphManager;
	private MainWindow mainWindow;
	
	
	public LatexEditorController() {

		
		//mainWindow = editorView.getMainWindow();
		System.out.println("Controller here");
		mainWindow = new MainWindow(this); 
		
		versionsManager= new VersionsManager(this);
		
		ciphManager = new CipherManager();
		ciphManager.changeCipherStratgyTo("Rot13");
		
		
		commands = new HashMap<String, Command>(); 
		this.dynamicallyCreateCommands("src/resources/settings/commands");
		
	}
	
	
	private void dynamicallyCreateCommands(String PropertiesFilePath){
		
		CommandFactory commandFactory = new CommandFactory(versionsManager,mainWindow,this,ciphManager);
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
	
	
	public VersionsManager getVersionsManager() {
		return versionsManager;
	}
	
	public CipherManager getCipherManager() {
		return ciphManager;
	}
	
	
	public MainWindow getMainWindow() {
		return this.mainWindow;
	}
	
	
	public String getTypeOfDocument() {
		return typeOfDocument;
	}
	public void setTypeOfDocument(String type) {
		this.typeOfDocument = type;
	}
	public String getFilePathName() {
		return filePathName;
	}
	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}
	
	public Document getCurrentDocument() {
		return currentDocument;
	}
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
	}
	
	
	
	
}
