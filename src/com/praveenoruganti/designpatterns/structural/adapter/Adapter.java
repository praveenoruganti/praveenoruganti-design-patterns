package com.praveenoruganti.designpatterns.structural.adapter;

public class Adapter implements ITarget {

	private Adaptee adaptee;

	Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		System.out.println("Using Adapter");
	 this.adaptee.specificRequest();
	}

}
