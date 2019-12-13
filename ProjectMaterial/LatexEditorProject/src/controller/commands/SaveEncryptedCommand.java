package controller.commands;

import controller.LatexEditorController;
import model.encryption.CipherManager;
import utilities.FileSaver;

public class SaveEncryptedCommand implements Command {

	
	private LatexEditorController editorController;
	private CipherManager ciphManager;
	private FileSaver fileSaver;
	
	public SaveEncryptedCommand(LatexEditorController editorController, CipherManager ciphManager) {
		this.editorController = editorController;
		this.ciphManager = ciphManager;
		this.fileSaver = new FileSaver();
	}
	
	
	@Override
	public void execute() {
		
		String contents = editorController.getCurrentDocument().getContents();
		String encryptedText = ciphManager.encryptString(contents);
		fileSaver.save(editorController.getFilePathName(), encryptedText);
		System.out.println("encryption Saved");
	}

}
