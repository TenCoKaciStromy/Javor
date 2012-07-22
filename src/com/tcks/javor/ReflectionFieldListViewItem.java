package com.tcks.javor;

import android.widget.*;
import android.os.*;
import android.content.*;
import android.util.*;
import android.view.*;
import java.lang.reflect.*;

public class ReflectionFieldListViewItem
	extends LinearLayout
{
	private Field dataItem;
	public Field getDataItem(){return this.dataItem;}
	public void setDataItem(Field value){
		this.dataItem = value;
		this.refreshDrawableState();
	}
	
	public ReflectionFieldListViewItem(Context context){
		super(context);
		this.init();
	}
	public ReflectionFieldListViewItem(Context context, AttributeSet attrs){
		super(context, attrs);
		this.init();
	}
	public ReflectionFieldListViewItem(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		this.init();
	}
	
	private void init(){
		this.init_Self();
		this.init_Controls();
	}
	
	private UIHelper uiHelper;
	protected UIHelper getUIHelper(){return this.uiHelper;}
	private void setUIHelper(UIHelper value){this.uiHelper = value;}
	private void init_Self(){
		this.setUIHelper(new UIHelper(this.getContext()));
	}
	
	private TextView txtModifier;
	private TextView txtScope;
	private TextView txtName;
	private TextView txtType;
	private void init_Controls(){
		UIHelper ui = this.getUIHelper();
		
		this.txtScope = ui.newTextView(this);
		this.txtName = ui.newTextView(this);
		this.txtType = ui.newTextView(this);
	}
	
	@Override
	public void refreshDrawableState(){
		super.refreshDrawableState();
		
		String name = null;
		String typeName = null;
		String scopeName = null;
		Field item = this.getDataItem();
		if(null != item){
			name = item.getName();
			typeName = item.getType().getName();
			scopeName = this.getScopeName(item);
		}
		
		if(null!=this.txtScope){
			this.txtScope.setText(XT.NStr(scopeName));
		}
		if(null!=this.txtName){
			this.txtName.setText(XT.NStr(name));
		}
		if(null!=this.txtType){
			this.txtType.setText("::" + XT.NStr(typeName));
		}
	}
	
	private String getScopeName(Field field){
		int numModifier = field.getModifiers();
		
		if (Modifier.isPrivate(numModifier)){
			return "-";
		}
		else if (Modifier.isProtected(numModifier)){
			return "*";
		}
		else if (Modifier.isPublic(numModifier)){
			return "+";
		}
		else{
			return "?";
		}
	}
}
