package com.tcks.javor;

import android.app.*;
import android.content.*;
import android.os.*;

public class ActivityEx extends Activity
{
	private UIHelper uiHelper;
	protected UIHelper getUIHelper(){return this.uiHelper;}
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        
		this.uiHelper = new UIHelper(this);
    }
}
