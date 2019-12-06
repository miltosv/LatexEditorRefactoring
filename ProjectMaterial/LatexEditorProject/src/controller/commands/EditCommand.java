package controller.commands;

import model.VersionsManager;
import view.LatexEditorView;

public class EditCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorView editorView;
	
	public EditCommand(VersionsManager versionsManager,LatexEditorView view) {
		editorView=view;
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		
		String contents=editorView.getMainWindow().getPaneText();
		editorView.getCurrentDocument().setContents(contents);
		System.out.println(editorView.getCurrentDocument().getContents() + " " + editorView.getMainWindow().getCaret());
		//versionsManager.saveContents();
	}

}
