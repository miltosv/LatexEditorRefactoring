package controller.commands;

import controller.LatexEditorController;



public class SaveCommand implements Command {

	private LatexEditorController editorController;
	
	public SaveCommand(LatexEditorController editorController) {
		this.editorController = editorController;
	}
	
	@Override
	public void execute() {
		
		editorController.getCurrentDocument().save(editorController.getFilePathName());
	}

}
