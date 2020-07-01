package net.egartley.boota.object;

import net.egartley.boota.StringManager;

public class BuildType {
	
	/*
	 * © 2016 Evan Gartley - All Rights Reserved
	 */
	
	public static BuildType STABLE, PRE_RELEASE;
	
	private String s;
	
	public BuildType(String s) {
		this.s = s;
	}
	
	public static void init() {
		STABLE = new BuildType(StringManager.BUILD_TYPE_STABLE);
		PRE_RELEASE = new BuildType(StringManager.BUILD_TYPE_PRE);
	}
	
	public String getString() {
		return s;
	}
	
	public String getPrettyString() {
		if (this.equals(PRE_RELEASE)) {
			return "Pre-Release";
		} else if (this.equals(STABLE)){
			return "Stable";
		} else {
			return "Unknown";
		}
	}

}
