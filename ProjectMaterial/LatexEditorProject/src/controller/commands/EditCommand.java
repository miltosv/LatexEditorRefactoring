package controller.commands;

import controller.LatexEditorController;
import model.VersionsManager;
import view.LatexEditorView;

public class EditCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorView editorView;
	private LatexEditorController editorController;
	
	public EditCommand(VersionsManager versionsManager,LatexEditorView view, LatexEditorController editorController) {
		editorView=view;
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
