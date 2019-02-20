package com.relyits.rmbs.utilities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;



public class PropertyUtilities {

	@Autowired
	private static ExposablePropertyPaceholderConfigurer exposableProperty;

	private static Map<String, String> properitesMap= null;

	public static Map<String, String> buildProprties(){
		properitesMap = new HashMap<String, String>();
		properitesMap=exposableProperty.getProperties();
		return properitesMap;
	}
	public static int getRole(String Key){
		int role=Integer.parseInt(buildProprties().get(Key.toLowerCase()));
		return role;
	}
}
