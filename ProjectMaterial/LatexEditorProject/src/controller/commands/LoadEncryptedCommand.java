package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.encryption.CipherManager;
import utilities.FileLoader;

public class LoadEncryptedCommand implements Command {

	
	private LatexEditorController editorController;
	private CipherManager ciphManager;
	private FileLoader fileLoader;
	
	public LoadEncryptedCommand(LatexEditorController editorController, CipherManager ciphManager) {
		this.editorController = editorController;
		this.ciphManager = ciphManager;
		this.fileLoader = new FileLoader();
	}
	
	
	@Override
	public void execute() {
		
		String encryptedText = fileLoader.load(editorController.getFilePathName());
		String decryptedText = ciphManager.decryptString(encryptedText);
		
		Document loadedDocument = new Document();
		loadedDocument.setContents(decryptedText);
		
		editorController.setTypeOfDocument("emptyTemplate");
		editorController.setCurrentDocument(loadedDocument);

	}

}
