package com.praveen.designpatterns.creational.singleton;

public class EagerSingletonExample {

	private static EagerSingletonExample instance = new EagerSingletonExample();

	private EagerSingletonExample() {

	}

	public static EagerSingletonExample getInstance() {
		return instance;
	}

	public static void main(String args[]) {
		EagerSingletonExample ese1 = EagerSingletonExample.getInstance();
		EagerSingletonExample ese2 = EagerSingletonExample.getInstance();
		if (ese1.equals(ese2)) {
			System.out.println("Single Object");
		} else {
			System.out.println("Multiple Objects");
		}
	}

}
