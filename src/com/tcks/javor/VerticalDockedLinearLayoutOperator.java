package com.tcks.javor;

import android.view.*;
import android.widget.*;

public class VerticalDockedLinearLayoutOperator
	extends DockedLinearLayoutOperatorBase
{
	public VerticalDockedLinearLayoutOperator(){}
	public VerticalDockedLinearLayoutOperator(LinearLayout dockedLayout){
		super(dockedLayout);
	}
	protected int getSize(){
		return this.getDockedLayout().getHeight();
	}
	protected void setSize(int size){
		LinearLayout dl = this.getDockedLayout();
		if(null == dl){return;}

		int okSize = size < 0?0:size;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
		(LinearLayout.LayoutParams.FILL_PARENT, okSize);

		dl.setLayoutParams(lp);
	}
}
