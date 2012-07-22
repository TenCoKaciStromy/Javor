package com.tcks.javor;

import android.content.*;
import android.view.*;
import android.widget.*;

public class DockedOperationButtons
{
	private Button doSmallerButton;
	public Button getDoSmallerButton(){ return this.doSmallerButton;}

	private Button doToggleVisibilityButton;
	public Button getDoToggleVisibilityButton(){return this.doToggleVisibilityButton;}

	private Button doLargerButton;
	public Button getDoLargerButton(){return this.doLargerButton;}

	private DockedLinearLayoutOperatorBase operator;
	public DockedLinearLayoutOperatorBase getOperator(){return this.operator;}

	private Context context;
	public Context getContext(){return this.context;}

	private UIHelper uiHelper;
	protected UIHelper getUIHelper(){return this.uiHelper;}
	protected DockedOperationButtons(DockedLinearLayoutOperatorBase operator, Context context){
		this.operator = operator;
		this.context = context;

		this.uiHelper = new UIHelper(context);

		this.doSmallerButton = this.uiHelper.newButton("<",operator.getDoSmallerClickListener());
		this.doToggleVisibilityButton = this.uiHelper.newButton("X", operator.getToggleVisibilityClickListener());
		this.doLargerButton = this.uiHelper.newButton(">", operator.getDoLargerClickListener());
	}

	public Button[] getOperationButtons(){
		return new Button[]
		{ this.doSmallerButton
			, this.doToggleVisibilityButton
			, this.doLargerButton};
	}
	public ViewGroup createOperationButtonsGroup(){
		UIHelper ui = this.getUIHelper();
		LinearLayout result = new LinearLayout(this.getContext());
		result.setLayoutParams(ui.newLinearLayoutParamsWrapingContent());
		
		this.addTo(result);
		return result;
	}

	public void addTo(ViewGroup parent){
		Button[] buttons = this.getOperationButtons();
		for(int i = 0; i < buttons.length; i++){
			parent.addView(buttons[i]);
		}
	}
	public ViewGroup addGroupTo(ViewGroup parent){
		ViewGroup group = this.createOperationButtonsGroup();
		parent.addView(group);
		return group;
	}
}
