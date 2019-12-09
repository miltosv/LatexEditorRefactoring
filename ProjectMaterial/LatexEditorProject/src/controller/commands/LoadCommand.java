package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;


public class LoadCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorController editorController;
	
	
	public LoadCommand(VersionsManager versionsManager, LatexEditorController editorController) {

		this.versionsManager = versionsManager;
		this.editorController = editorController;
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(editorController.getFilePathName()));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document currentDocument = new Document();
		currentDocument.setContents(fileContents);
		String type = "emptyTemplate";
		
		fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			type = "articleTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			type = "bookTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			type = "reportTemplate";
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			type = "letterTemplate";
		}
		
		editorController.setTypeOfDocument(type);
		//editorView.setType(type);
		editorController.setCurrentDocument(currentDocument);
		//versionsManager.loadFromFile();
	}

}
