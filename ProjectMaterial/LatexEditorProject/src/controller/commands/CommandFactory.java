package controller.commands;

import java.util.HashMap;

import model.DocumentManager;
import model.VersionsManager;
import view.*;

public class CommandFactory {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private MainWindow mainWindow;
	private LatexEditorView editorView;
	
	public CommandFactory(VersionsManager versionsManager,MainWindow window, LatexEditorView view) {
		super();
		mainWindow=window;
		editorView=view;
		this.versionsManager = versionsManager;
		documentManager = new DocumentManager();
	}


	public Command createCommand(String type) {
		if(type.equals("addLatex")) {
			return new AddLatexCommand(versionsManager);
		}
		if(type.equals("changeVersionsStrategy")) {
			return new ChangeVersionsStrategyCommand(versionsManager);
		}
		if(type.equals("create")) {
			return new CreateCommand(documentManager, versionsManager);
		}
		if(type.equals("disableVersionsManagement")) {
			return new DisableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("edit")) {
			return new EditCommand(versionsManager);
		}
		if(type.equals("enableVersionsManagement")) {
			return new EnableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("load")) {
			return new LoadCommand(versionsManager,editorView);
		}
		if(type.equals("rollbackToPreviousVersion")) {
			return new RollbackToPreviousVersionCommand(versionsManager);
		}
		if(type.equals("save")) {
			return new SaveCommand(versionsManager);
		}
		return null;
	}
}
