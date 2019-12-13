package controller.commands;

import controller.LatexEditorController;
import model.encryption.CipherManager;


public class ChangeCipherStrategyCommand implements Command{

	private LatexEditorController editorController;
	private CipherManager ciphManager;

	
	public ChangeCipherStrategyCommand(LatexEditorController editorController, CipherManager ciphManager) {
		this.editorController = editorController;
		this.ciphManager = ciphManager;
	}


	@Override
	public void execute() {
		
		
		// TODO pass ciphering option from GUI, probably through editorController
		// maybe through MainWindow
		
		ciphManager.changeCipherStratgyTo(ciphManager.getCipherStrategy());
		
	}
	
	
	
	
}
