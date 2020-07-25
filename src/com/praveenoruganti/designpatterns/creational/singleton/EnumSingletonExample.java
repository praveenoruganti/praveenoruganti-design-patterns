package com.praveenoruganti.designpatterns.creational.singleton;

public enum EnumSingletonExample {
	INSTANCE;
	public static void main(String args[]) {
		EnumSingletonExample ese1 = EnumSingletonExample.INSTANCE;
		EnumSingletonExample ese2 = EnumSingletonExample.INSTANCE;
		if (ese1.equals(ese2)) {
			System.out.println("Single Object");
		} else {
			System.out.println("Multiple Objects");
		}
	}

}
