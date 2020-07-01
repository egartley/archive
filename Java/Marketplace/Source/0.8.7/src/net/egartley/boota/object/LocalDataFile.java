package net.egartley.boota.object;

import java.io.File;

public class LocalDataFile {
	
	/*
	 * © 2016 Evan Gartley - All Rights Reserved
	 */
	
	private File file;
	
	public LocalDataFile(File f) {
		file = f;
	}
	
	public boolean getExists() {
		return file.exists();
	}
	
	public File getFile(){
		return file;
	}
	
	public String getFileName() {
		return file.getName();
	}

}
