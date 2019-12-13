package controller.commands;

import java.util.HashMap;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;
import model.encryption.CipherManager;
import view.*;

public class CommandFactory {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private LatexEditorController editorController;
	private MainWindow mainWindow;
	private CipherManager ciphManager;
	
	public CommandFactory(VersionsManager versionsManager,MainWindow window, LatexEditorController editorController,CipherManager ciphManager) {
		super();
		mainWindow = window;
		this.editorController = editorController;
		this.versionsManager = versionsManager;
		documentManager = new DocumentManager();
		this.ciphManager = ciphManager;
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
		if(type.equals("changeCipherStrategy")){
			return new ChangeCipherStrategyCommand(editorController, ciphManager);
		}
		if(type.equals("saveEncrypted")){
			return new SaveEncryptedCommand(editorController, ciphManager);
		}
		if(type.equals("loadEncrypted")){
			return new LoadEncryptedCommand(editorController, ciphManager);
		}
		return null;
	}
}
