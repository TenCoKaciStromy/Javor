package com.tcks.javor;

public class DelegatedTracer
	extends Tracer
{
	private Tracer original;
	public Tracer getOriginal(){return this.original;}
	public void setOriginal(Tracer value){this.original = value;}
	
	public DelegatedTracer(){}
	public DelegatedTracer(Tracer original){
		this.setOriginal(original);
	}
	public DelegatedTracer(Tracer original, boolean enabled){
		this.setOriginal(original);
		this.setEnabled(enabled);
	}
	
	protected void traceInternal(String str){
		Tracer tracer = this.getOriginal();
		if(null!=tracer){
			tracer.trace(str);
		}
	}
}
