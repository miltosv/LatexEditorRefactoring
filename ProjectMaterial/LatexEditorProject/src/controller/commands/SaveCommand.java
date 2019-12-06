package controller.commands;

import model.VersionsManager;
import view.LatexEditorView;

public class SaveCommand implements Command {
	private LatexEditorView editorView;
	
	public SaveCommand(LatexEditorView v) {
		editorView=v;
	}
	@Override
	public void execute() {
		
		editorView.getCurrentDocument().save(editorView.getFilename());
	}

}
