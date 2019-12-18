package controller.commands;

import controller.LatexEditorController;
import model.encryption.CipherManager;


public class ChangeCipherStrategyCommand extends SuperCommand{

	private CipherManager ciphManager;

	
	public ChangeCipherStrategyCommand(LatexEditorController editorController, CipherManager ciphManager) {
		super(editorController);
		this.ciphManager = ciphManager;
	}


	@Override
	public void execute() {
		
		ciphManager.changeCipherStratgyTo(ciphManager.getCipherStrategy());
		
	}
	
	
	
	
}
