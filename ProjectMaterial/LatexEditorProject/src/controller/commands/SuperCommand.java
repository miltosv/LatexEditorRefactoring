package controller.commands;

import controller.LatexEditorController;
import model.versioning.VersionsManager;

public abstract class SuperCommand implements Command {
	
	protected LatexEditorController editorController;
	
	protected VersionsManager versionsManager;
	
	
	public SuperCommand(LatexEditorController c,VersionsManager vm) {
		editorController=c;
		versionsManager=vm;
	}
	
	public SuperCommand(VersionsManager vm) {
		versionsManager=vm;
	}
	
	public SuperCommand(LatexEditorController c) {
		editorController=c;
	}
	
	public abstract void execute();

}
