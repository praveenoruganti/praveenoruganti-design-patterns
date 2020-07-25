package com.praveenoruganti.designpatterns.creational.singleton;

public class LazySingletonExample {
	private static LazySingletonExample instance =null;

	private LazySingletonExample() {

	}

	public static LazySingletonExample getInstance() {
		if(instance==null) {
			instance= new LazySingletonExample();
		}
		return instance;
	}

	public static void main(String args[]) {
		LazySingletonExample lse1 = LazySingletonExample.getInstance();
		LazySingletonExample lse2 = LazySingletonExample.getInstance();
		if (lse1.equals(lse2)) {
			System.out.println("Single Object");
		} else {
			System.out.println("Multiple Objects");
		}
	}
}
