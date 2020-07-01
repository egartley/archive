package net.egartley.boota.console;

import java.util.ArrayList;

import net.egartley.boota.Marketplace;
import net.egartley.boota.Utils;
import net.egartley.boota.dialog.AboutDialog;
import net.egartley.boota.dialog.UpdateCompleteDialog;
import net.egartley.boota.files.Structure;
import net.egartley.boota.task.CommonTask;
import net.egartley.boota.update.UpdateCore;

public class CommandHandler {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static boolean ready;
	private static ArrayList<Command> commands = new ArrayList<Command>();
	static Command HELP;
	static Command MAKE_DIRS;
	static Command PING;
	static Command VER;
	static Command EXIT;
	static Command RESTART;
	static Command CHECK_FOR_UPDATE;
	static Command RESET;
	static Command REFRESH_CONTENT;
	static Command LIST_DIRS;
	static Command SHOW_UC_FRAME;

	static Command TEST;

	public static void init() {
		HELP = new Command(new String[] { "help", "?", "h" }, new Runnable() {
			public void run() {
				printHelpMessage();
			}
		}, "Displays this message");

		MAKE_DIRS = new Command(new String[] { "dir", "checkDirs" }, new Runnable() {
			public void run() {
				Structure.verifyDirectories();
			}
		}, "Makes any needed directories");

		PING = new Command(new String[] { "ping", "connection", "checkConnection" }, new Runnable() {
			public void run() {
				CommonTask.checkConnection(true);
			}
		}, "Checks for an active Internet connection to servers");

		VER = new Command(new String[] { "ver", "build" }, new Runnable() {
			public void run() {
				AboutDialog.createDialog();
			}
		}, "Displays installed build information");

		EXIT = new Command(new String[] { "exit", "quit" }, new Runnable() {
			public void run() {
				Marketplace.close();
			}
		}, "Closes the Marketplace");

		RESTART = new Command(new String[] { "restart" }, new Runnable() {
			public void run() {
				Marketplace.restart();
			}
		}, "Restarts the Marketplace");

		CHECK_FOR_UPDATE = new Command(new String[] { "check", "cfu" }, new Runnable() {
			public void run() {
				UpdateCore.check(true);
			}
		}, "Checks for a new Marketplace build");

		RESET = new Command(new String[] { "reset" }, new Runnable() {
			public void run() {
				CommonTask.reset();
			}
		}, "Resets files and folders, then restarts the Marketplace");

		REFRESH_CONTENT = new Command(new String[] { "refresh", "refreshContent" }, new Runnable() {
			public void run() {
				CommonTask.refreshContent();
			}
		}, "Refreshes EULA/news panes and apps list");

		LIST_DIRS = new Command(new String[] { "li", "list" }, new Runnable() {
			public void run() {
				Structure.outputDirectories();
			}
		}, "Lists all of the root directories and their files/folders");

		SHOW_UC_FRAME = new Command(new String[] { "uc", "showuc", "showucframe", "updatecomplete",
				"updatecompleteframe", "showupdatecompleteframe" }, new Runnable() {
					public void run() {
						UpdateCompleteDialog.createDialog();
					}
				}, "Displays the \"Update Complete\" dialog");

		ready = true;
	}

	public static void processInput(String input) {
		if (!ready) {
			Utils.handleError("CommandHandler is not ready! (A command may already be running!)");
			return;
		}
		if (input == null || input.equals(""))
			return;
		String trigger = input.substring(input.indexOf("/") + 1);
		Command c = getCommandByTrigger(trigger);
		if (c == null) {
			Utils.handleError("Unknown command \"" + input + "\", try \"/help\"");
			return;
		}
		ready = false;
		Utils.runInNewThread(new Runnable() {
			public void run() {
				c.run();
				ready = true;
			}
		});
	}

	private static void printHelpMessage() {
		Utils.println("Known commands: ", Utils.INFO);
		for (int i = 0; i < commands.size(); i++) {
			Command c = commands.get(i);
			if (c == null) {
				break;
			}
			Utils.println("  /" + c.getTriggers()[0] + ": " + c.getHelpDesc(), Utils.INFO);
		}
	}

	public static ArrayList<Command> getCommands() {
		return commands;
	}

	public static Command getCommandByTrigger(String trigger) {
		for (int i = 0; i < commands.size(); i++) {
			Command c = commands.get(i);
			if (c == null) {
				continue;
			}
			for (int ii = 0; ii < c.getTriggers().length; ii++) {
				if (c.getTriggers()[ii].equalsIgnoreCase(trigger)) {
					return c;
				}
			}
		}
		return null;
	}

}