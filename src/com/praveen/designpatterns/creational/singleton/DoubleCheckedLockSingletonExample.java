package com.praveen.designpatterns.creational.singleton;

public class DoubleCheckedLockSingletonExample {
	private static DoubleCheckedLockSingletonExample instance =null;

	private DoubleCheckedLockSingletonExample() {

	}

	public static DoubleCheckedLockSingletonExample getInstance() {
		if(instance==null) {
			synchronized(DoubleCheckedLockSingletonExample.class) {
				if(instance==null) {
					instance= new DoubleCheckedLockSingletonExample();
				}
			}
		}

		return instance;
	}

	public static void main(String args[]) {
		DoubleCheckedLockSingletonExample dclse1 = DoubleCheckedLockSingletonExample.getInstance();
		DoubleCheckedLockSingletonExample dclse2 = DoubleCheckedLockSingletonExample.getInstance();
		if (dclse1.equals(dclse2)) {
			System.out.println("Single Object");
		} else {
			System.out.println("Multiple Objects");
		}
	}
}
