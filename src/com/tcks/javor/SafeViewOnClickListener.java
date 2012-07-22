package com.tcks.javor;

import android.view.*;

public abstract class SafeViewOnClickListener
	implements View.OnClickListener
{
	protected abstract void safeOnClick(View v);
	public void onClick(View v) {
		try {
			this.safeOnClick(v);
		}
		catch(Exception exc){
			UIHelper ui = new UIHelper(v.getContext());
			ui.msgBoxInfo("Unhandled exception", exc.toString());
		}
	}
}
