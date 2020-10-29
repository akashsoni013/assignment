package com.assignment.utils;


import java.util.ResourceBundle;

public class PropertiesUtil {
	
	private ResourceBundle propFile;
	
	public String getConfigurationValue(String propKey) {
		propFile = ResourceBundle.getBundle("configuration");
		return propFile.getString(propKey);
	}
	
	public String getObjectRepVal(String propKey) {
		propFile = ResourceBundle.getBundle("objectrepository");
		return propFile.getString(propKey);
	}
	
	public String getStringValue(String propKey) {
		propFile = ResourceBundle.getBundle("string");
		return propFile.getString(propKey);
	}

}
