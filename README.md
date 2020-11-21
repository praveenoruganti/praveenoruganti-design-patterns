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
- Factory Pattern - subclasses are responsible to create the instance of the class.
- Abstract Factory Pattern - A Factory of Factories
- Singleton Pattern
- Prototype Pattern
- Builder Pattern.
- Object Pool Pattern.

### Structural patterns
Eases the design by identifying a way to realize relationship between entities.
Ex. Flyweight pattern – high quantity objects to share common properties object to save space.

Here with the Structural Design Patterns.
-  Adapter
-  Bridge
-  Filter
-  Composite
-  Decorator
-  Facade
-  Flyweight
-  Proxy

### Behavioral patterns
A solution for the ideal interaction between objects and how to provide loose coupling and flexibility
Ex. Observer pattern – get notified of the change of the state of an object being observed (observer/subject)

Here with the behavioral patterns
-  Chain of Responsibility
-  Command
-  Interpreter
-  Iterator
-  Mediator
-  Momento
-  Observer
-  State
- Strategy
-  Template method
-  Visitor


## Singleton Design Pattern

It is a type of Creational Design Pattern.
This is a pattern which restricts the instantiation of a class to one object.
We can make singleton class using below 5 approaches and my favourite is static inner class and Enum.

-  Using Eager Initialization

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

-  Using Lazy Initialization

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

-  Using Double checked Locking

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

-  Using static inner static class

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

-  Using Enum

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


## Builder Design Pattern

It is a type of Creational Design Pattern.
Builder pattern was introduced to solve some of the problems with Factory and Abstract Factory design patterns when the Object contains a lot of attributes.
Static factories and constructors share a limitation, they dont scale well to large number of optional paramaters.
Builder pattern solves the issue with large number of optional parameters and inconsistent state by providing a way to build the object step-by-step and provide a method that will actually return the final Object.
Lets start coding

```JAVA

package com.praveenoruganti.designpatterns.creational.builder;

public class Employee {
	//All final attributes
	private final int empId;
	private final String empName;
	private final double empSalary;
	private final String empAddress;

	private Employee(EmployeeBuilder builder) {
		this.empId = builder.empId;
		this.empName = builder.empName;
		this.empSalary = builder.empSalary;
		this.empAddress = builder.empAddress;
	}

	//All getter, and NO setter to provde immutability
	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public static class EmployeeBuilder {
		private int empId;
		private String empName;
		private double empSalary;
		private String empAddress;

		EmployeeBuilder() {

		}

		public EmployeeBuilder empId(int empId) {
			this.empId = empId;
			return this;
		}

		public EmployeeBuilder empName(String empName) {
			this.empName = empName;
			return this;
		}

		public EmployeeBuilder empSalary(double empSalary) {
			this.empSalary = empSalary;
			return this;
		}

		public EmployeeBuilder empAddress(String empAddress) {
			this.empAddress = empAddress;
			return this;
		}
		 //Return the finally constructed  Employee object
		public Employee build() {
			Employee emp = new Employee(this);
			return emp;
		}
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAddress="
				+ empAddress + "]";
	}

	public static void main(String args[]) {
		Employee emp = new Employee.EmployeeBuilder().empId(149903).empName("Praveen").empSalary(1000000d)
				.empAddress("Hyderabad").build();
		System.out.println(emp);
	}

}


```
### Benefits
1. Solves the multiple constructor
2. problem(telescoping constructor)
3. Static inner class(builder class)
4. Internally required constructor
5. removes the need for setters

### Limitations
1. Immutable
2. Inner static class
3. Design first
4.Complex

### Builder Design Pattern Example in JDK
Some of the builder pattern example in Java classes are;
1. java.lang.StringBuilder#append() (unsynchronized)
2. java.lang.StringBuffer#append() (synchronized)
3. DocumentBuilder
4. Locale.Builder


## Factory Design Pattern
It is a type of Creational Design Pattern.
It doesn't exposes instantiation or creation logic instead subclass create the object.
Lets start coding

```JAVA

package com.praveenoruganti.designpatterns.creational.factory;

public interface NotificationExecutor {
	public void executeNotification();
}

```

```JAVA

package com.praveenoruganti.designpatterns.creational.factory;

public class EmailNotificationExecutor implements NotificationExecutor {

	@Override
	public void executeNotification() {
		System.out.println("Email notification sent");
	}

}


```

```JAVA

package com.praveenoruganti.designpatterns.creational.factory;

public class SMSNotificationExecutor implements NotificationExecutor {

	@Override
	public void executeNotification() {
		System.out.println("SMS notification sent.");
	}

}


```


```JAVA

package com.praveenoruganti.designpatterns.creational.factory;

public class NoNotificationExecutor implements NotificationExecutor {
	private String notificationType;

	NoNotificationExecutor(String notificationType) {
		this.notificationType = notificationType;
	}
	@Override
	public void executeNotification() {
		System.out.println("Notification Implementation not defined for "+ notificationType);
	}

}


```

```JAVA

package com.praveenoruganti.designpatterns.creational.factory;

public class NotificationExecutorFactory {
	public static NotificationExecutor getNotificationExecutor(String executorType) {

		switch (executorType) {
		case "Email":
			return new EmailNotificationExecutor();

		case "SMS":
			return new SMSNotificationExecutor();

		default:
			return new NoNotificationExecutor(executorType);

		}

	}
}

```


```JAVA

package com.praveenoruganti.designpatterns.creational.factory;

public class NotificationSender {

	public static void main(String[] args) {
		NotificationExecutorFactory.getNotificationExecutor("Email").executeNotification();
		NotificationExecutorFactory.getNotificationExecutor("SMS").executeNotification();
		NotificationExecutorFactory.getNotificationExecutor("FTP").executeNotification();
	}

}


```

### Benefits
1. Creation of different types of objects is possible at run time
2. It separates the object creation logic from the object usage logic
3.Removes duplicate code
Thus, makes changing or addition to object creation easier

### Limitations
1. The different types of objects created must have the same parent class
2. The addition of new classes and interfaces could increase the complexity of the code

### Factory Design Pattern Example in JDK
Some of the factory pattern example in Java classes are;
1. Calender.getInstance()
2. NumberFormat.getInstance()

