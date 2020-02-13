package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.encryption.CipherManager;
import model.versioning.VersionsManager;
import utilities.FileLoader;

public class LoadEncryptedCommand extends SuperCommand {

	private CipherManager ciphManager;
	private FileLoader fileLoader;

	
	public LoadEncryptedCommand(LatexEditorController editorController, CipherManager ciphManager,VersionsManager vm) {
		super(editorController,vm);
		this.ciphManager = ciphManager;
		this.fileLoader = new FileLoader();
		
	}
	
	
	@Override
	public void execute() {
		
		String encryptedText = fileLoader.load(editorController.getFilePathName());
		String decryptedText = ciphManager.decryptString(encryptedText);
		
		Document loadedDocument = new Document();
		loadedDocument.setContents(decryptedText);
		System.out.print(decryptedText);
		editorController.setTypeOfDocument("emptyTemplate");
		editorController.setCurrentDocument(loadedDocument);
		versionsManager.putVersion(loadedDocument);

	}

}
