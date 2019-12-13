package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.versioning.VersionsManager;
import utilities.FileLoader;


public class LoadCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorController editorController;
	
	
	public LoadCommand(VersionsManager versionsManager, LatexEditorController editorController) {

		this.versionsManager = versionsManager;
		this.editorController = editorController;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		String fileContents = "";
		FileLoader loader=new FileLoader();
		fileContents=loader.load(editorController.getFilePathName());
		
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
		versionsManager.putVersion(currentDocument);
	}

}
