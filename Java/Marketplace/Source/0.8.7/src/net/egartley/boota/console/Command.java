package net.egartley.boota.console;

import net.egartley.boota.Utils;

public class Command {
	
	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */
	
	String helpDesc;
	String[] trigger;
	Runnable runnable;
	
	public Command(String[] trigger, Runnable toRun, String helpDesc) {
		this.trigger = trigger;
		this.runnable = toRun;
		this.helpDesc = helpDesc;
		CommandHandler.getCommands().add(this);
	}
	
	public void run() {
		runnable.run();
	}
	
	public void runInNewThread() {
		Utils.runInNewThread(runnable);
	}
	
	public String[] getTriggers() {
		return trigger;
	}
	
	public String getHelpDesc() {
		return helpDesc;
	}
	
	public Runnable getRun() {
		return runnable;
	}

}
