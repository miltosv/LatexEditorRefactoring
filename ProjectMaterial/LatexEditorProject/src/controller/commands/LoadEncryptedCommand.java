package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.encryption.CipherManager;
import model.versioning.VersionsManager;
import utilities.FileLoader;

public class LoadEncryptedCommand implements Command {

	
	private LatexEditorController editorController;
	private CipherManager ciphManager;
	private FileLoader fileLoader;
	private VersionsManager vManager;
	
	public LoadEncryptedCommand(LatexEditorController editorController, CipherManager ciphManager,VersionsManager vm) {
		this.editorController = editorController;
		this.ciphManager = ciphManager;
		this.fileLoader = new FileLoader();
		vManager=vm;
	}
	
	
	@Override
	public void execute() {
		
		String encryptedText = fileLoader.load(editorController.getFilePathName());
		String decryptedText = ciphManager.decryptString(encryptedText);
		
		Document loadedDocument = new Document();
		loadedDocument.setContents(decryptedText);
		
		editorController.setTypeOfDocument("emptyTemplate");
		editorController.setCurrentDocument(loadedDocument);
		vManager.putVersion(loadedDocument);

	}

}
