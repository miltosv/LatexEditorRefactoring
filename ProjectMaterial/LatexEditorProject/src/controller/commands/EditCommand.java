package controller.commands;

import controller.LatexEditorController;
import model.VersionsManager;


public class EditCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorController editorController;
	
	public EditCommand(VersionsManager versionsManager, LatexEditorController editorController) {
		this.editorController = editorController;
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		
		String contents=new String(editorController.getMainWindow().getPaneText());
		editorController.getCurrentDocument().setContents(contents);
//		System.out.println(editorView.getCurrentDocument().getContents() + " " + editorView.getMainWindow().getCaret());
		//versionsManager.saveContents();
	}

}
