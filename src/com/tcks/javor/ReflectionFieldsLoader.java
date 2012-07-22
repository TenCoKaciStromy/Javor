package com.tcks.javor;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionFieldsLoader
{
	public boolean allowFilterByScope;
	public boolean allowPrivate;
	public boolean allowProtected;
	public boolean allowPublic;
	
	public boolean allowStatic;
	public boolean allowFinal;
	
	public ArrayList<Field> filter(Field[] fields){
		ArrayList<Field> result = new ArrayList<Field>();
		
		if(null != fields){
			for(Field f : fields){
				if(this.allowField(f)){
					result.add(f);
				}
			}
		}
		
		return result;
	}
	
	public boolean allowField(Field field){
		if(null == field) {return false;}
		
		int numModifiers = field.getModifiers();
		if(this.allowFilterByScope){
			if(false == this.allowPrivate && Modifier.isPrivate(numModifiers)){
				return false;
			}
			if(false == this.allowProtected && Modifier.isProtected(numModifiers)){
				return false;
			}
			if(false == this.allowPublic && Modifier.isPublic(numModifiers)){
				return false;
			}
		}
		
		if(false == this.allowStatic && Modifier.isStatic(numModifiers)){
			return false;
		}
		if(false == this.allowFinal && Modifier.isFinal(numModifiers)){
			return false;
		}
		
		return true;
	}
}
