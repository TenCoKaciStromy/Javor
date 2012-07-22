package com.tcks.javor;

import android.content.*;
import android.view.*;
import android.widget.*;

public abstract class DockedLinearLayoutOperatorBase
{
	private LinearLayout dockedLayout;
	public LinearLayout getDockedLayout(){return this.dockedLayout;}
	public void setDockedLayout(LinearLayout ctl){this.dockedLayout = ctl;}
	
	protected DockedLinearLayoutOperatorBase(){}
	public DockedLinearLayoutOperatorBase(LinearLayout dockedLayout){
		this.dockedLayout = dockedLayout;
	}

	private int normalSize;
	public int getNormalSize(){return this.normalSize;}
	public void setNormalSize(int value){this.normalSize = value;}

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

	protected abstract int getSize();
	protected abstract void setSize(int size);
	public void toggleVisibility(){
		try {
			LinearLayout dl = this.dockedLayout;
			if(null == dl){
				this.getValidTracer().trace("dockedLayout is null => return;");
				return;
			}

			int size = this.getSize();
			int newSize;
			if(size>0){
				newSize = 0;
				this.normalSize = size;
			}
			else { newSize = normalSize; }

			this.setSize(newSize);
		}
		catch(Exception exc){
			this.getValidTracer().trace(exc);
		}
	}

	private void changeSize(int deltaSize){
		int size = this.getSize();
		if(size<1){size=this.normalSize;}

		int newSize = size + deltaSize;
		this.setSize(newSize);
	}
	
	private View.OnClickListener toggleVisibilityClickListener;
	public View.OnClickListener getToggleVisibilityClickListener(){
		View.OnClickListener result = this.toggleVisibilityClickListener;
		if(null == result){
			final DockedLinearLayoutOperatorBase self = this;
			result = new View.OnClickListener() {
				public void onClick(View v) {
					self.toggleVisibility();
				}
			};
			this.toggleVisibilityClickListener = result;
		}

		return result;
	}

	public void doSmaller(){
		this.changeSize(-1*this.sizingStep);
	}
	private View.OnClickListener doSmallerClickListener;
	public View.OnClickListener getDoSmallerClickListener(){
		View.OnClickListener result = this.doSmallerClickListener;
		if(null == result){
			final DockedLinearLayoutOperatorBase self = this;
			result = new View.OnClickListener(){
				public void onClick(View v){
					self.doSmaller();
				}
			};
			this.doSmallerClickListener = result;
		}
		return result;
	}
	public void doLarger(){
		this.changeSize(this.sizingStep);
	}
	private View.OnClickListener doLargerClickListener;
	public View.OnClickListener getDoLargerClickListener(){
		View.OnClickListener result = this.doLargerClickListener;
		if(null == result){
			final DockedLinearLayoutOperatorBase self = this;
			result = new View.OnClickListener(){
				public void onClick(View v){
					self.doLarger();
				}
			};
			this.doLargerClickListener = result;
		}
		return result;
	}


	public DockedOperationButtons createOperationButtons(Context context){
		return new DockedOperationButtons(this, context);
	}
}
