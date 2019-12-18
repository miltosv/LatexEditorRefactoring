package controller.commands;

import model.versioning.VersionsManager;

public class ChangeVersionsStrategyCommand extends SuperCommand {
	
	public ChangeVersionsStrategyCommand(VersionsManager versionsManager) {
		super(versionsManager);
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		versionsManager.changeStrategy();
	}

}
