package net.egartley.boota.object;

public class OutputType {
	
	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */
	
	public static OutputType UPDATE, INFO, ERROR, OKAY;
	
	private String s;
	
	public OutputType(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
}
