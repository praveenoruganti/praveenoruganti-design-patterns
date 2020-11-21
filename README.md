# Praveen Oruganti Design Patterns

## Why Design Patterns?
1. Design patterns are used for solving recursive problems in a software application design.
2. A design pattern is a description for how to solve a recursive problem.
3. Design patterns are not a technology or a tool or a language or a platform or a framework.
4. Design patterns are effective proven solutions for recursive problems.

## How many Design Patterns?
SUN Microsystems constituted a group with four professional with the name of Gang of Four (GOF) to find effective solutions for the recursive problems.
According to GOF, they found 23 design patterns as effective solutions for re-occurring problems.
Java design patterns are divided into 3 i.e. Creational, Structural and Behavioral.

![screenshot of the app](https://raw.githubusercontent.com/praveenoruganti/praveenoruganti-design-patterns/master/images/1.jpg)

### Creational patterns
Creational patterns are ones that create objects for you, rather than having you instantiate objects directly. This gives your program more flexibility in deciding which objects need to be created for a given case. Ex. Singleton pattern – used to restrict the creation of an object to one instance.

Here with the Creational Design Patterns
1. Factory Pattern - subclasses are responsible to create the instance of the class.
2. Abstract Factory Pattern - A Factory of Factories
3. Singleton Pattern
4. Prototype Pattern
5. Builder Pattern.
6. Object Pool Pattern.

### Structural patterns
Eases the design by identifying a way to realize relationship between entities.
Ex. Flyweight pattern – high quantity objects to share common properties object to save space.

Here with the Structural Design Patterns.
1. Adapter
2. Bridge
3. Filter
4. Composite
5. Decorator
6. Facade
7. Flyweight
8. Proxy

### Behavioral patterns
A solution for the ideal interaction between objects and how to provide loose coupling and flexibility
Ex. Observer pattern – get notified of the change of the state of an object being observed (observer/subject)

Here with the behavioral patterns
1. Chain of Responsibility
2. Command
3. Interpreter
4. Iterator
5. Mediator
6. Momento
7. Observer
8. State
9. Strategy
10. Template method
11. Visitor


## Singleton Design Pattern

It is a type of Creational Design Pattern.
This is a pattern which restricts the instantiation of a class to one object.
We can make singleton class using below 5 approaches and my favourite is static inner class and Enum.

1. Using Eager Initialization

```JAVA
package com.praveenoruganti.designpatterns.creational.singleton;

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

```

2. Using Lazy Initialization

```JAVA

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


```

3. Using Double checked Locking

```JAVA
package com.praveenoruganti.designpatterns.creational.singleton;

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

```

4. Using static inner static class

```JAVA

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


```

5. Using Enum

```JAVA

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


```

### Benefits
1. Limits the objects creations
2. Reduces the memory required
3. Reduces garbage collection
4. Helps in Lazy initialization. That means, an object is not created until we need it and call the getInstance() method
5. Saves memory as the instances are reused

### Limitations
1. Same object is shared hence the object must be immutable
2. We can not have class level variables,If we use they will be overridden by other client
3. Extra code need to write for making it singleton this increases complexity
4. The getInstance() method is not thread safe, but can be overcome by using synchronized keyword
Singleton Pattern is generally used for logging,driver objects,caching and threadpool.

### Singleton Design Pattern Example in JDK
Some of the singleton pattern example in Java classes are;
1. java.lang.Runtime.getRuntime(): This method gives Runtime class that has only one instance in a JVM.
2. java.lang.System.getSecurityManager(): This method returns a SecurityManager for the current platform.
3. java.awt.Desktop.getDesktop()

