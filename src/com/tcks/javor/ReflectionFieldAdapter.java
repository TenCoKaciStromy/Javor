package com.tcks.javor;

import android.view.*;
import android.widget.*;
import java.lang.reflect.*;

public class ReflectionFieldAdapter
	extends BaseAdapter
{
	private Field[] data;
	public Field[] getData(){return this.data;}
	public void setData(Field[] data){
		if(null==data){
			this.data = null;
		}
		else{
			this.data =(Field[])data.clone();
		}
	}
	
	public ReflectionFieldAdapter(){}
	public ReflectionFieldAdapter(Field[] data){
		this.setData(data);
	}
	
	public int getCount(){
		Field[] data = this.getData();
		if(null==data){
			return 0;
		}
		else {
			return data.length;
		}
	}
	
	public Object getItem(int position){
		return this.getData()[position];
	}
	
	public long getItemId(int position){
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		return this.getComplexView(position, convertView, parent);
	}
	
	private View getComplexView(int position, View convertView, ViewGroup parent){
		ReflectionFieldListViewItem result
			= XT.<ReflectionFieldListViewItem>AS(convertView);
			
		if(null == result){
			result= new ReflectionFieldListViewItem(parent.getContext());
		}
		
		Field item = (Field)this.getItem(position);
		result.setDataItem(item);
		
		return result;
	}
}
