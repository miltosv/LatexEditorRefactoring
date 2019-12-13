package controller.commands;

import controller.LatexEditorController;
import utilities.FileSaver;



public class SaveCommand implements Command {

	private LatexEditorController editorController;
	
	public SaveCommand(LatexEditorController editorController) {
		this.editorController = editorController;
	}
	
	@Override
	public void execute() {
		
		FileSaver saver= new FileSaver();
		saver.save(editorController.getFilePathName(),editorController.getCurrentDocument().getContents());
		
		//editorController.getCurrentDocument().save(editorController.getFilePathName());
	}

}
