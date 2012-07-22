package com.tcks.javor;

import android.widget.*;
import android.content.*;
import android.util.*;

public class LinearLayoutEx
	extends LinearLayout
{
	public LinearLayoutEx(Context context){
		super(context);
		this.init();
	}
	public LinearLayoutEx(Context context, AttributeSet attrs){
		super(context, attrs);
		this.init();
	}
	public LinearLayoutEx(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		this.init();
	}

	private void init(){
		this.init_Self();
	}

	private UIHelper uiHelper;
	protected UIHelper getUIHelper(){return this.uiHelper;}
	private void setUIHelper(UIHelper value){this.uiHelper = value;}
	private void init_Self(){
		this.setUIHelper(new UIHelper(this.getContext()));
	}
}
