package com.tcks.javor;

public class XT
{
	public static <TClass> TClass AS(Object obj){
		if(null == obj) {
			return null;
		}
		else{
			if (obj instanceof TClass){
				return (TClass)obj;
			}
			else{
				return null;
			}
		}
	}
	
	public static String NStr(String str){
		if(null == str){return "";}
		else{return str;}
	}
}
