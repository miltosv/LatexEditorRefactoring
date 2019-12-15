package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.versioning.VersionsManager;

public class CreateCommand extends SuperCommand {
	private DocumentManager documentManager;
	
	public CreateCommand(DocumentManager documentManager, VersionsManager versionsManager,LatexEditorController editorController) {
		super(editorController, versionsManager);
		this.documentManager = documentManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = editorController.getTypeOfDocument();
		
		Document document = documentManager.createDocument(type);
		editorController.setCurrentDocument(document);
		versionsManager.putVersion(document);
		editorController.getMainWindow().update(document.getContents());
	}

}
