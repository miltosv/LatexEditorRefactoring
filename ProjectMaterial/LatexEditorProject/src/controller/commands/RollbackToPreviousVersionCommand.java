package controller.commands;

import model.versioning.VersionsManager;

public class RollbackToPreviousVersionCommand extends SuperCommand {

	
	
	public RollbackToPreviousVersionCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}


	@Override
	public void execute() {
		versionsManager.rollback();
	}

}
