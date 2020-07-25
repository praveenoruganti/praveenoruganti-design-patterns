package com.praveenoruganti.designpatterns.creational.singleton;

public class InnerClassSingletonExample {

	private InnerClassSingletonExample() {

	}

	public static class SingletonHolder {
		private static InnerClassSingletonExample instance = new InnerClassSingletonExample();
	}

	public static InnerClassSingletonExample getInstance() {
       return SingletonHolder.instance;
	}

	public static void main(String[] args) {
		InnerClassSingletonExample icse1= InnerClassSingletonExample.getInstance();
		InnerClassSingletonExample icse2= InnerClassSingletonExample.getInstance();
		if(icse1.equals(icse2)) {
			System.out.println("Single Object");
		}else {
			System.out.println("Multiple Objects");
		}

	}

}
