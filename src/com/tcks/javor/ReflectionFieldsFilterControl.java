package com.tcks.javor;

import android.content.*;
import android.widget.*;
import android.util.*;

public class ReflectionFieldsFilterControl
	extends LinearLayoutEx
{
	public ReflectionFieldsFilterControl(Context context){
		super(context);
		this.init();
	}
	public ReflectionFieldsFilterControl(Context context, AttributeSet attrs){
		super(context, attrs);
		this.init();
	}
	public ReflectionFieldsFilterControl(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		this.init();
	}
	
	private void init(){
		this.init_Self();
		this.init_Controls();
	}
	
	private void init_Self(){
		this.setOrientation(HORIZONTAL);
	}
	
	private CheckBox chkAllowPrivate;
	private CheckBox chkAllowProtected;
	private CheckBox chkAllowPublic;
	private CheckBox chkAllowStatic;
	private CheckBox chkAllowFinal;
	private void init_Controls(){
		UIHelper ui = this.getUIHelper();
		
		this.chkAllowPrivate = ui.newCheckBox(this, "private");
		this.chkAllowProtected = ui.newCheckBox(this, "protected");
		this.chkAllowPublic = ui.newCheckBox(this, "public");
		
		this.chkAllowStatic = ui.newCheckBox(this, "static");
		this.chkAllowFinal = ui.newCheckBox(this, "final");
	}
}
