package com.authenteq.json.strategy;

import com.authenteq.annotations.Exclude;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomExclusionStrategy implements ExclusionStrategy {

	public boolean shouldSkipField(FieldAttributes f) {
		if(f.getAnnotation(Exclude.class)!=null){
			return true;
		}
		return false;
	}

	public boolean shouldSkipClass(Class clazz) {
		return false;
	}

}