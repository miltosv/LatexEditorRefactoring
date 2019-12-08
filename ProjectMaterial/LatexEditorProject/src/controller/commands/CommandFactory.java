package controller.commands;

import java.util.HashMap;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;
import view.*;

public class CommandFactory {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private LatexEditorController editorController;
	private MainWindow mainWindow;
	
	
	public CommandFactory(VersionsManager versionsManager,MainWindow window, LatexEditorController editorController) {
		super();
		mainWindow = window;
		this.editorController = editorController;
		this.versionsManager = versionsManager;
		documentManager = new DocumentManager();
	}


	public Command createCommand(String type) {
		if(type.equals("addLatex")) {
			return new AddLatexCommand(versionsManager, editorController);
		}
		if(type.equals("changeVersionsStrategy")) {
			return new ChangeVersionsStrategyCommand(versionsManager);
		}
		if(type.equals("create")) {
			return new CreateCommand(documentManager, versionsManager, editorController);
		}
		if(type.equals("disableVersionsManagement")) {
			return new DisableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("edit")) {
			return new EditCommand(versionsManager, editorController);
		}
		if(type.equals("enableVersionsManagement")) {
			return new EnableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("load")) {
			return new LoadCommand(versionsManager, editorController);
		}
		if(type.equals("rollbackToPreviousVersion")) {
			return new RollbackToPreviousVersionCommand(versionsManager);
		}
		if(type.equals("save")) {
			return new SaveCommand(editorController);
		}
		return null;
	}
}
