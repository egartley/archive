package net.egartley.boota.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.egartley.boota.Marketplace;
import net.egartley.boota.Utils;

public class Structure {

	/*
	 * © 2016 Evan Gartley - All Rights Reserved
	 */

	static boolean updatedDirs = false, didArchiveNames = false;
	public static ArrayList<String> names = new ArrayList<String>();
	private static String initialIndent = "  ";

	private static void setup() {
		createRootDir("apps");
		createRootDir("data");
		createRootDir("temp");
		createRootDir("update");
		didArchiveNames = true;

		cleanRoot();

		if (updatedDirs) {
			Utils.println("Directories updated", Utils.INFO);
			updatedDirs = false;
		}
	}

	private static void cleanRoot() {
		File mrktFolder = FileManager.MARKETPLACE_FOLDER;
		File[] mrktDirFiles = mrktFolder.listFiles();
		for (File file : mrktDirFiles) {
			boolean isRootFolder = false;
			if (!file.isDirectory()) {
				continue;
			}
			for (int nameIndex = 0; nameIndex < names.size(); nameIndex++) {
				if (names.get(nameIndex).equalsIgnoreCase(file.getName())) {
					isRootFolder = true;
					break;
				} else {
					isRootFolder = false;
					continue;
				}
			}
			if (!isRootFolder) {
				file.delete();
				updatedDirs = true;
			}
		}
	}

	public static void verifyDirectories() {
		Marketplace.stlibFile.createFolder(FileManager.EGARTLEY_FOLDER);
		Marketplace.stlibFile.createFolder(FileManager.MARKETPLACE_FOLDER);
		setup();
	}

	public static void createRootDir(String name) {
		File f = new File(FileManager.MARKETPLACE_FOLDER.getAbsolutePath() + File.separator + name);
		if (!didArchiveNames)
			names.add(f.getName());
		if (!f.exists()) {
			f.mkdirs();
			updatedDirs = true;
		} else
			return;
		Utils.println("Made folder: " + name, Utils.INFO);
	}

	public static void cleanDirectory(File directory, boolean delete) throws IOException {
		if (!directory.exists()) {
			Utils.handleError("cleanDirectory(" + directory.getName() + ") does not exist; cannot clean it!");
			return;
		}
		if (!directory.isDirectory()) {
			Utils.handleError("cleanDirectory(" + directory.getName() + ") is not a directory; cannot clean it!");
			return;
		}
		File[] files = directory.listFiles();
		if (files == null) {
			Utils.handleError("cleanDirectory(" + directory.getName() + ") failed to listFiles(); cannot clean it!");
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				cleanDirectory(file, delete);
			} else
				file.delete();
		}
		if (delete)
			directory.delete();
	}

	public static void outputDirectories() {
		Utils.println("Current root directories:", Utils.INFO);
		outputDir(FileManager.MARKETPLACE_FOLDER, -1);
	}

	private static void outputDir(File dir, int indent) {
		if (dir.listFiles().length == 0) {
			// dir is empty
			outputEmptyDir(indent);
			return;
		}
		// dir has files
		for (File innerFile : dir.listFiles()) {
			int thisindent = indent + 1;
			Utils.println(computeIndentString(thisindent) + " " + innerFile.getName(), Utils.INFO);
			if (innerFile.isDirectory())
				outputDir(innerFile, thisindent);
		}
	}

	private static void outputEmptyDir(int indent) {
		Utils.println(computeIndentString(indent + 2) + "(empty)", Utils.INFO);
	}

	private static String computeIndentString(int indent) {
		String in = initialIndent + "└";
		for (int i = 0; i < indent; i++) {
			in += "─";
		}
		return in;
	}

}