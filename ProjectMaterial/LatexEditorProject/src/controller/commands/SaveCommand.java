package controller.commands;

import controller.LatexEditorController;
import model.VersionsManager;
import view.LatexEditorView;

public class SaveCommand implements Command {
	private LatexEditorView editorView;
	private LatexEditorController editorController;
	
	public SaveCommand(LatexEditorView v,LatexEditorController editorController) {
		editorView=v;
		this.editorController = editorController;
	}
	@Override
	public void execute() {
		
		editorView.getCurrentDocument().save(editorController.getFilePathName());
	}

}
