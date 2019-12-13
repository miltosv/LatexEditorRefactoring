package controller.commands;

import controller.LatexEditorController;


public class EditCommand implements Command {
	private LatexEditorController editorController;
	
	public EditCommand(LatexEditorController editorController) {
		this.editorController = editorController;
	}


	@Override
	public void execute() {
		
		String contents=new String(editorController.getMainWindow().getPaneText());
		editorController.getCurrentDocument().setContents(contents);

	}

}
