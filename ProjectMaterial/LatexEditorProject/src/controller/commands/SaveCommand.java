package controller.commands;

import controller.LatexEditorController;
import utilities.FileSaver;



public class SaveCommand extends SuperCommand {
	
	public SaveCommand(LatexEditorController editorController) {
		super(editorController);
	}
	
	@Override
	public void execute() {
		
		FileSaver saver= new FileSaver();
		saver.save(editorController.getFilePathName(),editorController.getCurrentDocument().getContents());
		
	}

}
