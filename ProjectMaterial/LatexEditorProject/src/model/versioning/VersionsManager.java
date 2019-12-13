package model.versioning;

import javax.swing.JOptionPane;

import controller.LatexEditorController;
import model.Document;


public class VersionsManager {
	private boolean enabled;
	private VersionsStrategy strategy;
	private LatexEditorController editorController;
	private String strategyType;

	
	public VersionsManager( LatexEditorController editorController) {
		this.strategy = new VersionsStrategyFactory().createStrategy("volatileStrategy");
		this.editorController = editorController;
		strategyType = "volatile";
		
	}
	
	
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}

	public void disable() {
		enabled = false;
	}
	
	public void setStrategyType(String type) {
		strategyType = type;
	}
	
	
	public void setStrategy(VersionsStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void setCurrentVersion(Document document) {
		editorController.setCurrentDocument(document);
	}
	

	public void saveContents() {
		
		if (this.isEnabled()){
			this.putVersion(editorController.getCurrentDocument());
			editorController.getCurrentDocument().changeVersion();
		}
	}

	/*
	public void loadFromFile() {
		
		latexEditorView.loadFromFile();
	}
*/
	public void enableStrategy() {
		
		//String strategyType = latexEditorView.getStrategy();
		if(strategyType.equals("volatile") && strategy instanceof VolatileVersionsStrategy) {
			enable();
		}
		else if(strategyType.equals("stable") && strategy instanceof VolatileVersionsStrategy) {
			//allagh apo to ena sto allo
			VersionsStrategy newStrategy = new StableVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
		else if(strategyType.equals("volatile") && strategy instanceof StableVersionsStrategy) {
			VersionsStrategy newStrategy = new VolatileVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
		else if(strategyType.equals("stable") && strategy instanceof StableVersionsStrategy) {
			enable();
		}
	}

	public void changeStrategy() {
		
		//String strategyType = latexEditorView.getStrategy();
		if(strategyType.equals("stable") && strategy instanceof VolatileVersionsStrategy) {
			VersionsStrategy newStrategy = new StableVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
		else if(strategyType.equals("volatile") && strategy instanceof StableVersionsStrategy) {
			VersionsStrategy newStrategy = new VolatileVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
	}

	public void  putVersion(Document document) {
	
		strategy.putVersion(document.clone());
	}

	public void rollback() {
		
		if(isEnabled() == false) {
			JOptionPane.showMessageDialog(null, "Strategy is not enabled", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			Document doc = strategy.getVersion();
			if(doc == null) {
				JOptionPane.showMessageDialog(null, "No version available", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				strategy.removeVersion();
				editorController.setCurrentDocument(doc);
			}
		}
		
	}

	
}
