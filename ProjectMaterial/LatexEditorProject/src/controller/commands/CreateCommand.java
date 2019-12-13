package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.versioning.VersionsManager;

public class CreateCommand implements Command {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private LatexEditorController editorController;
	
	public CreateCommand(DocumentManager documentManager, VersionsManager versionsManager,LatexEditorController editorController) {
		
		this.documentManager = documentManager;
		this.versionsManager = versionsManager;
		this.editorController = editorController;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = editorController.getTypeOfDocument();
		
		Document document = documentManager.createDocument(type);
		versionsManager.setCurrentVersion(document);
	}

}
