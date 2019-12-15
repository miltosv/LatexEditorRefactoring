package controller.commands;

import controller.LatexEditorController;
import model.versioning.VersionsManager;


public class EditCommand extends SuperCommand {
	
	public EditCommand(LatexEditorController editorController,VersionsManager vm) {
		super(editorController, vm);
	}


	@Override
	public void execute() {
		
		String contents=new String(editorController.getMainWindow().getPaneText());
		editorController.getCurrentDocument().setContents(contents);
		versionsManager.saveContents();

	}

}
