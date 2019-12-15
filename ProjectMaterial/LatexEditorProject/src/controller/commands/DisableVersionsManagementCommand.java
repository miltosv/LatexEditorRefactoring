package controller.commands;

import model.versioning.VersionsManager;

public class DisableVersionsManagementCommand extends SuperCommand {

	
	
	public DisableVersionsManagementCommand(VersionsManager versionsManager) {
		super(versionsManager);
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.disable();
	}

}
