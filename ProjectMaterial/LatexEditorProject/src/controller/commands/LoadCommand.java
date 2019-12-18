package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.versioning.VersionsManager;
import utilities.FileLoader;


public class LoadCommand extends SuperCommand {
	
	
	public LoadCommand(VersionsManager versionsManager, LatexEditorController editorController) {

		super(editorController,versionsManager);
	}


	@Override
	public void execute() {
		
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
		editorController.setCurrentDocument(currentDocument);
		versionsManager.putVersion(currentDocument);
	}

}
