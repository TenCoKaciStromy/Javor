package com.tcks.javor;

import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;

public class UIHelper
{
	private Context context;
	public Context getContext(){return this.context;}
	
	public UIHelper(Context context){
		this.context = context;
	}
	public void addCtl(LinearLayout parent, View child) {
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

		this.addCtl(parent, child, lp);
	}
	public void addCtl(LinearLayout parent, View child, RelativeLayout.LayoutParams layoutParams) {
		parent.addView(child, layoutParams);
	}
	
	public TextView newTextView(){
		return new TextView(this.getContext());
	}
	public TextView newTextView(LinearLayout parent){
		TextView result = this.newTextView();
		this.addCtl(parent, result);
		return result;
	}
	
	public CheckBox newCheckBox(){
		return new CheckBox(this.getContext());
	}
	public CheckBox newCheckBox(String text){
		CheckBox chk = this.newCheckBox();
		chk.setText(text);
		return chk;
	}
	public CheckBox newCheckBox(LinearLayout parent){
		CheckBox chk = this.newCheckBox();
		this.addCtl(parent, chk);
		return chk;
	}
	public CheckBox newCheckBox(LinearLayout parent, String text){
		CheckBox chk = this.newCheckBox(text);
		this.addCtl(parent, chk);
		return chk;
	}

	public Button newButton() {
		Context appContext = this.getContext();
		return new Button(appContext);
	}
	public Button newButton(String text) {
		Button btn = this.newButton();
		btn.setText(text);
		return btn;
	}
	public Button newButton(String text, View.OnClickListener clickListener){
		Button btn = this.newButton(text);
		btn.setOnClickListener(clickListener);

		return btn;
	}
	public Button newButton(LinearLayout parent, String text, View.OnClickListener clickListener){
		Button btn = this.newButton(text);
		this.addCtl(parent, btn);
		btn.setOnClickListener(clickListener);

		return btn;
	}
	public Button newButton(String text, int width, int height) {
		Button btn = this.newButton(text);
		btn.setWidth(width);
		btn.setHeight(height);
		return btn;
	}
	
	public void msgBoxInfo(String title, String message){
		Context appContext = this.getContext();
		AlertDialog dialog;
		dialog = new AlertDialog.Builder(appContext).create();
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setButton("OK", new EmptyDialogInterfaceOnClickListener());
		
		dialog.show();
	}
	
	public class EmptyDialogInterfaceOnClickListener
		implements DialogInterface.OnClickListener {
		public void onClick(DialogInterface dialog, int which){}
	}
	
	public LinearLayout.LayoutParams newLinearLayoutParamsWrapingContent(){
		return new LinearLayout.LayoutParams
			( LinearLayout.LayoutParams.WRAP_CONTENT
		 	, LinearLayout.LayoutParams.WRAP_CONTENT);
	}
}
