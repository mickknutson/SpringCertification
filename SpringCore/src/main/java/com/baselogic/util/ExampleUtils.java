package com.baselogic.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baselogic.domain.Activity;

public class ExampleUtils {

	private static final Logger logger = LoggerFactory.getLogger(ExampleUtils.class);
	
	private List<String> names; 				// Lists contain objects in insertion order. Can have duplicates.
	private List<Integer> namedIds;
	private Set<String> otherSet;				// Sets contains unique things. No duplicates allowed.
	private Map<String, Object> additionalData; // Maps Cannot have duplicate keys.
	private Activity activity;					// ENUM

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		logger.debug("Received names: {} of type {}", new Object[] { names,
				names.getClass().getName() });
		this.names = names;
	}

	//----- otherNames ------------------------------------------------------//
	public List<Integer> getNamedIds() {
		return namedIds;
	}

	//public void setOtherNames(java.util.LinkedList<String> otherNames) {
	public void setNamedIds(List<Integer> namedIds) {
		this.namedIds = namedIds;
	}

	//----- otherSet --------------------------------------------------------//
	public Set<String> getOtherSet() {
		return otherSet;
	}

	//public void setOtherSet(java.util.TreeSet<String> otherSet) {
	public void setOtherSet(Set<String> otherSet) {
		this.otherSet = otherSet;
	}

	//----- additionalData --------------------------------------------------//
	public Map<String, Object> getAdditionalData() {
		return additionalData;
	}

	//public void setAdditionalData(java.util.TreeSet<String> additionalData) {
	public void setAdditionalData(Map<String, Object> additionalData) {
		this.additionalData = additionalData;
	}

	//----- activity --------------------------------------------------------//
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	//----- Mock Test methods -----------------------------------------------//
	
	public static String staticFunction(){
		return "staticFunction";
	}
	
	public void voidMethod(){}

	public String nestedFunction(){
		
		String result = "nestedFunction()";

		try{
			
			result += ": " + privateFunction();
			
		} catch (Exception e){
			
			result += ": Exception " +e.getMessage()+ " : " + privateFunction();
			
		}
		
		return result;
		
	}

	public String nestedFunctionTwo(){
		
		String result = "nestedFunctionTwo()";

		try{
		
			result += ": " + privateFunction();
			
		} catch (Exception e){
			
			result += ": Exception " +e.getMessage()+ " : " + privateFunction();
			
		} finally {
			
			try{
				
				result += ": finally : " + privateFunction();
				
			} catch (Exception e){

				result += ": finally : Exception " +e.getMessage()+ " : " + privateFunction();
				
			}
		}
		
		return result;
		
	}

	private String privateFunction() throws RuntimeException {
		return "privateFunction";
	}

	
	
	
	//----- toString --------------------------------------------------------//
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
