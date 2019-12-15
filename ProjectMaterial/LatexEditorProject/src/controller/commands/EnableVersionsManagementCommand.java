package controller.commands;

import model.versioning.VersionsManager;

public class EnableVersionsManagementCommand extends SuperCommand {
	private VersionsManager versionsManager;
	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		super(versionsManager);
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.enableStrategy();
	}

}
