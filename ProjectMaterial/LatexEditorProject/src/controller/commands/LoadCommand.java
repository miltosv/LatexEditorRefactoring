package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class LoadCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorView editorView;
	private LatexEditorController editorController;
	
	
	public LoadCommand(VersionsManager versionsManager,LatexEditorView view,LatexEditorController editorController) {
		editorView=view;
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
			Scanner scanner = new Scanner(new FileInputStream(editorView.getFilename()));
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
		editorView.setCurrentDocument(currentDocument);
		//versionsManager.loadFromFile();
	}

}
