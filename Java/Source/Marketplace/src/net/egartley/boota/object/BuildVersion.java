package net.egartley.boota.object;

public class BuildVersion {
	
	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */
	
	private double d;
	private String s;
	
	public BuildVersion(double d, String s) {
		this.d = d;
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public double getDouble() {
		return d;
	}

}
