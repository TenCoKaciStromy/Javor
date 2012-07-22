package com.tcks.javor;

import android.content.*;
import android.view.*;
import android.widget.*;

public class HorizontalDockedLinearLayoutOperator
	extends DockedLinearLayoutOperatorBase
{
	public HorizontalDockedLinearLayoutOperator(){}
	public HorizontalDockedLinearLayoutOperator(LinearLayout dockedLayout){
		super(dockedLayout);
	}
	protected int getSize(){
		return this.getDockedLayout().getWidth();
	}
	protected void setSize(int size){
		LinearLayout dl = this.getDockedLayout();
		if(null == dl){return;}

		int okSize = size < 0?0:size;

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
		(okSize, LinearLayout.LayoutParams.FILL_PARENT);

		dl.setLayoutParams(lp);
	}
}
	
/*
public class HorizontalDockedLinearLayoutOperator
{
	private LinearLayout dockedLayout;
	public LinearLayout getDockedLayout(){return this.dockedLayout;}
	public void setDockedLayout(LinearLayout ctl){this.dockedLayout = ctl;}
	
	public HorizontalDockedLinearLayoutOperator(){}
	public HorizontalDockedLinearLayoutOperator(LinearLayout dockedLayout){
		this.dockedLayout = dockedLayout;
	}
	
	private int normalWidth;
	public int getNormalWidth(){return this.normalWidth;}
	public void setNormalWidth(int value){this.normalWidth = value;}
	
	private int sizingStep = 25;
	public int getSizingStep(){return this.sizingStep;}
	public void setSizingStep(int value){
		if(value < 1){
			this.sizingStep = 1;
		}
		else{
			this.sizingStep = value;
		}
	}
	
	private Tracer tracer;
	public Tracer getTracer(){return this.tracer;}
	public void setTracer(Tracer obj){this.tracer=obj;}
	protected Tracer getValidTracer(){
		Tracer result = this.tracer;
		if(null == tracer){
			tracer = new Tracer(){
				public void traceInternal(String str){}
			};
			
			result = tracer;
		}
		
		return result;
	}
	
	public void toggleVisibility(){
		try {
		LinearLayout dl = this.dockedLayout;
		if(null == dl){
			this.getValidTracer().trace("dockedLayout is null => return;");
			return;
		}
		
		int width = dl.getWidth();
		this.getValidTracer().trace("width: ", width);
		int newWidth;
		if(width>0){
			newWidth = 0;
			this.normalWidth = width;
		}
		else { newWidth = normalWidth; }
		this.getValidTracer().trace("newWidth: ", newWidth);
		
		this.setWidth(newWidth);
		}
		catch(Exception exc){
			this.getValidTracer().trace(exc);
		}
	}
	
	private void changeWidth(int deltaWidth){
		LinearLayout dl = this.dockedLayout;
		if(null == dl){
			this.getValidTracer().trace("dockedLayout is null => return;");
			return;
		}
		
		int width = dl.getWidth();
		this.getValidTracer().trace("width: ", width);
		if(width<1){width=this.normalWidth;}
		this.getValidTracer().trace("width: ", width);
		
		int newWidth = width + deltaWidth;
		this.getValidTracer().trace("newWidth: ", newWidth);
		this.setWidth(newWidth);
	}
	private void setWidth(int width){
		LinearLayout dl = this.dockedLayout;
		if(null == dl){return;}
		
		int okWidth = width < 0?0:width;
		
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
		(okWidth, LinearLayout.LayoutParams.FILL_PARENT);

		dl.setLayoutParams(lp);
	}
	
	private View.OnClickListener toggleVisibilityClickListener;
	public View.OnClickListener getToggleVisibilityClickListener(){
		View.OnClickListener result = this.toggleVisibilityClickListener;
		if(null == result){
			final HorizontalDockedLinearLayoutOperator self = this;
			result = new View.OnClickListener() {
				public void onClick(View v) {
					self.toggleVisibility();
				}
			};
			this.toggleVisibilityClickListener = result;
		}
		
		return result;
	}
	
	public void doSmallerWidth(){
		this.changeWidth(-1*this.sizingStep);
	}
	private View.OnClickListener doSmallerWidthClickListener;
	public View.OnClickListener getDoSmallerWidthClickListener(){
		View.OnClickListener result = this.doSmallerWidthClickListener;
		if(null == result){
			final HorizontalDockedLinearLayoutOperator self = this;
			result = new View.OnClickListener(){
				public void onClick(View v){
					self.doSmallerWidth();
				}
			};
			this.doSmallerWidthClickListener = result;
		}
		return result;
	}
	public void doLargerWidth(){
		this.changeWidth(this.sizingStep);
	}
	private View.OnClickListener doLargerWidthClickListener;
	public View.OnClickListener getDoLargerWidthClickListener(){
		View.OnClickListener result = this.doLargerWidthClickListener;
		if(null == result){
			final HorizontalDockedLinearLayoutOperator self = this;
			result = new View.OnClickListener(){
				public void onClick(View v){
					self.doLargerWidth();
				}
			};
			this.doLargerWidthClickListener = result;
		}
		return result;
	}
	
	
	public HorizontalDockedOperationButtons createOperationButtons(Context applicationContext){
		HorizontalDockedOperationButtons buttons = new HorizontalDockedOperationButtons(this, applicationContext);
		return buttons;
	}
}
*/
