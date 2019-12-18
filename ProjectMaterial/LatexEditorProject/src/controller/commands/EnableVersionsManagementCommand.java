package controller.commands;

import model.versioning.VersionsManager;

public class EnableVersionsManagementCommand extends SuperCommand {

	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		super(versionsManager);
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		versionsManager.enableStrategy();
	}

}
