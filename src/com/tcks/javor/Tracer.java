package com.tcks.javor;

public abstract class Tracer
{
	private boolean enabled=true;
	public boolean getEnabled(){return this.enabled;}
	public void setEnabled(boolean value){this.enabled=value;}
	
	protected abstract void traceInternal(String str);
	public void trace(String str) {
		if(this.enabled){
			this.traceInternal(str);
		}
	}
	public void trace(String str, int num) {
		if(this.enabled){
			this.trace(str + num);
		}
	}
	public void trace(Exception exc){
		if(this.enabled){
			this.trace(exc.toString());
		}
	}
}
