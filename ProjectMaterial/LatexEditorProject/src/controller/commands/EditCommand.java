package controller.commands;

import controller.LatexEditorController;
import model.versioning.VersionsManager;


public class EditCommand implements Command {
	private LatexEditorController editorController;
	private VersionsManager versionManager;
	public EditCommand(LatexEditorController editorController,VersionsManager vm) {
		this.editorController = editorController;
		versionManager=vm;
	}


	@Override
	public void execute() {
		
		String contents=new String(editorController.getMainWindow().getPaneText());
		editorController.getCurrentDocument().setContents(contents);
		versionManager.saveContents();

	}

}
