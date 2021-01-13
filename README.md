![screenshot of the app](https://raw.githubusercontent.com/praveenorugantitech/praveenorugantitech-express-js/master/tech.PNG)


# Design Patterns Course

## Why Design Patterns?
1. Design patterns are used for solving recursive problems in a software application design.
2. A design pattern is a description for how to solve a recursive problem.
3. Design patterns are not a technology or a tool or a language or a platform or a framework.
4. Design patterns are effective proven solutions for recursive problems.

## How many Design Patterns?
SUN Microsystems constituted a group with four professional with the name of Gang of Four (GOF) to find effective solutions for the recursive problems.
According to GOF, they found 23 design patterns as effective solutions for re-occurring problems.
Java design patterns are divided into 3 i.e. Creational, Structural and Behavioral.

![screenshot of the app](https://raw.githubusercontent.com/praveenorugantitech/praveenorugantitech-design-patterns/master/images/1.jpg)

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

- It is a type of Creational Design Pattern.
- This is a pattern which restricts the instantiation of a class to one object.
- We can make singleton class using below 5 approaches and my favourite is static inner class and Enum.

1.  Using Eager Initialization

```JAVA
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

```

2. Using Lazy Initialization

```JAVA

package com.praveen.designpatterns.creational.singleton;

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

3.  Using Double checked Locking

```JAVA
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

```

4.  Using static inner static class

```JAVA

package com.praveen.designpatterns.creational.singleton;

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

5.  Using Enum

```JAVA

package com.praveen.designpatterns.creational.singleton;

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
- Limits the objects creations
- Reduces the memory required
- Reduces garbage collection
- Helps in Lazy initialization. That means, an object is not created until we need it and call the getInstance() method
- Saves memory as the instances are reused

### Limitations
- Same object is shared hence the object must be immutable
- We can not have class level variables,If we use they will be overridden by other client
- Extra code need to write for making it singleton this increases complexity
-  The getInstance() method is not thread safe, but can be overcome by using synchronized keyword

Singleton Pattern is generally used for logging,driver objects,caching and threadpool.

### Singleton Design Pattern Example in JDK
Some of the singleton pattern example in Java classes are;
- java.lang.Runtime.getRuntime(): This method gives Runtime class that has only one instance in a JVM.
- java.lang.System.getSecurityManager(): This method returns a SecurityManager for the current platform.
- java.awt.Desktop.getDesktop()


## Builder Design Pattern

It is a type of Creational Design Pattern.
Builder pattern was introduced to solve some of the problems with Factory and Abstract Factory design patterns when the Object contains a lot of attributes.
Static factories and constructors share a limitation, they dont scale well to large number of optional paramaters.
Builder pattern solves the issue with large number of optional parameters and inconsistent state by providing a way to build the object step-by-step and provide a method that will actually return the final Object.
Lets start coding

```JAVA

package com.praveen.designpatterns.creational.builder;

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
- Solves the multiple constructor
- problem(telescoping constructor)
- Static inner class(builder class)
- Internally required constructor
- removes the need for setters

### Limitations
- Immutable
- Inner static class
- Design first
- Complex

### Builder Design Pattern Example in JDK
Some of the builder pattern example in Java classes are;
- java.lang.StringBuilder#append() (unsynchronized)
- java.lang.StringBuffer#append() (synchronized)
- DocumentBuilder
- Locale.Builder


## Factory Design Pattern
- It is a type of Creational Design Pattern.
- It doesn't exposes instantiation or creation logic instead subclass create the object.

Lets start coding

```JAVA

package com.praveen.designpatterns.creational.factory;

public interface NotificationExecutor {
	public void executeNotification();
}

```

```JAVA

package com.praveen.designpatterns.creational.factory;

public class EmailNotificationExecutor implements NotificationExecutor {

	@Override
	public void executeNotification() {
		System.out.println("Email notification sent");
	}

}


```

```JAVA

package com.praveen.designpatterns.creational.factory;

public class SMSNotificationExecutor implements NotificationExecutor {

	@Override
	public void executeNotification() {
		System.out.println("SMS notification sent.");
	}

}


```


```JAVA

package com.praveen.designpatterns.creational.factory;

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

package com.praveen.designpatterns.creational.factory;

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

package com.praveen.designpatterns.creational.factory;

public class NotificationSender {

	public static void main(String[] args) {
		NotificationExecutorFactory.getNotificationExecutor("Email").executeNotification();
		NotificationExecutorFactory.getNotificationExecutor("SMS").executeNotification();
		NotificationExecutorFactory.getNotificationExecutor("FTP").executeNotification();
	}

}


```

### Benefits
- Creation of different types of objects is possible at run time
- It separates the object creation logic from the object usage logic
- Removes duplicate code
Thus, makes changing or addition to object creation easier

### Limitations
- The different types of objects created must have the same parent class
- The addition of new classes and interfaces could increase the complexity of the code

### Factory Design Pattern Example in JDK
Some of the factory pattern example in Java classes are;
- Calender.getInstance()
- NumberFormat.getInstance()
- DriverManager.getConnection(-,-,-)


## Abstract Factory Design Pattern
It is a type of Creational Design Pattern.
Abstract factory design pattern is used to mange different object types of same family. All the object should belong to same family but they are of different categories.

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public interface Animal {

	public void display();
}


```

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public class Cat implements Animal{

	@Override
	public void display() {
		System.out.println("I'm the Cat");
	}

}

```

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public class Fox implements Animal{
	@Override
	public void display() {
		System.out.println("I'm the Fox");
	}

}


```

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public class Owl implements Animal{

	public void display() {
		System.out.println("I'm the Owl");
	}

}


```

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public abstract class AnimalFactory {

	public abstract Animal create(String animal);

}


```

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public class BirdsFactory extends AnimalFactory{

	@Override
	public Animal create(String animal) {
		animal = animal.toUpperCase();
		if(animal.equals("OWL")){
			return new Owl();
		}
		return null;
	}

}


```

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public class MammalsFactory extends AnimalFactory {

	@Override
	public Animal create(String animal) {
		animal = animal.toUpperCase();
		switch (animal) {
		case "CAT":
			return new Cat();
		case "FOX":
			return new Fox();
		default:
			return null;
		}

	}

}


```

```JAVA

package com.praveen.designpatterns.creational.abstractfactory;

public class Main {

	public static void main(String[] args) {
		AnimalFactory factory = new BirdsFactory();
		Animal owl = factory.create("Owl");
		owl.display();
		factory = new MammalsFactory();
		Animal fox = factory.create("Fox");
		fox.display();

	}

}


```

### Benefits
- It helps to group related objects or functions
- Also, reduces errors of mixing of objects or functions from different groups
- Helps to abstract code so that user don’t need to worry about object creations

### Limitations
- Only useful when we have to group processes or objects
- Before getting object or calling the function we need to get the factory which adds one more processes
- Adds more classes and abstraction hence code could become complex

### Abstract Factory Design Pattern Example in JDK
Some of the Abstract factory pattern example in Java classes are;
- javax.xml.parsers.DocumentBuilderFactory#newInstance()
- javax.xml.transform.TransformerFactory#newInstance()
- javax.xml.xpath.XPathFactory#newInstance()


## Bridge Design Pattern
- It is a type of Structural Design Pattern.
- It allows you to separate the abstraction from implementation.
- A classic example of bridge is Drivers.

```JAVA

package com.praveen.designpatterns.structural.bridge;

public abstract class Message {
	MessageSender messageSender;

	Message(MessageSender messageSender) {
		this.messageSender = messageSender;
	}

	abstract void send();
}



```

```JAVA

package com.praveen.designpatterns.structural.bridge;

public interface MessageSender {
	void sendMessage();
}


```


```JAVA

package com.praveen.designpatterns.structural.bridge;

public class EmailMessage extends Message {

	EmailMessage(MessageSender messageSender) {
		super(messageSender);
	}

	@Override
	void send() {
		messageSender.sendMessage();
	}

}


```


```JAVA

package com.praveen.designpatterns.structural.bridge;

public class EmailMessageSender implements MessageSender {

	@Override
	public void sendMessage() {
		System.out.println("Email Message Sent");
	}
}


```


```JAVA

package com.praveen.designpatterns.structural.bridge;

public class TextMessage extends Message {

	TextMessage(MessageSender messageSender){
		super(messageSender);
	}

	@Override
	void send() {
		messageSender.sendMessage();
	}



}


```


```JAVA

package com.praveen.designpatterns.structural.bridge;

public class TextMessageSender implements MessageSender {

	@Override
	public void sendMessage() {
		System.out.println("Text Message Sent");
	}

}


```


```JAVA

package com.praveen.designpatterns.structural.bridge;

public class MessageTest {

	public static void main(String args[]) {
		MessageSender txtmessageSender = new TextMessageSender();
		Message txtMessage= new TextMessage(txtmessageSender);
		txtMessage.send();

		MessageSender emailmessageSender = new EmailMessageSender();
		Message emailMessage= new EmailMessage(emailmessageSender);
		emailMessage.send();
	}

}


```

### Benefits
- It enables the separation of implementation from the interface.
- It improves the extensibility.
- It allows the hiding of implementation details from the client.


## Adapter Design Pattern
- It is a type of structural design pattern.
- It converts the interface of a class into another interface that a client expects.

Lets start coding

```JAVA

package com.praveen.designpatterns.structural.adapter;

public interface ITarget {
	void request();
}


```

```JAVA

package com.praveen.designpatterns.structural.adapter;

public class Adaptee {

	public void specificRequest() {
		System.out.println("In Adaptee");
	}

}


```


```JAVA

package com.praveen.designpatterns.structural.adapter;

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


```


```JAVA

package com.praveen.designpatterns.structural.adapter;

public class Main {

	public static void main(String args[]) {
		ITarget target= new Adapter(new Adaptee());
		target.request();
	}

}


```

### Benefits
- It allows two or more previously incompatible objects to interact.
- It allows reusability of existing functionality.

### Limitations
- No new functionalities can be added
- Multiple Adapters difficult to maintain

### Adapter Design Pattern in JDK
- java.util.Arrays#asList()
- java.util.Collections#list()
- java.util.Collections#enumeration()
- java.io.InputStreamReader(InputStream) (returns a Reader)


## Decorator Pattern

- It is a type of Structural Design Pattern.
- A Decorator Pattern says that just "attach a flexible additional responsibilities to an object dynamically".
- In other words, The Decorator Pattern uses composition instead of inheritance to extend the functionality of an object at runtime.
- The Decorator Pattern is also known as Wrapper.


```JAVA

package com.praveen.designpatterns.structural.decorator;

public interface MenuItem {

	public double cost();

	public String description();

}


```

```JAVA

package com.praveen.designpatterns.structural.decorator;

public class Decorator implements MenuItem{

	protected MenuItem beverage;

	public Decorator(MenuItem _beverage){
		beverage = _beverage;
	}

	@Override
	public double cost() {
		return beverage.cost();
	}

	@Override
	public String description() {
		return beverage.description();
	}

}


```

```JAVA

package com.praveen.designpatterns.structural.decorator;

public class Milk extends Decorator{

	public Milk(MenuItem _beverage) {
		super(_beverage);
	}

	@Override
	public double cost() {
		return beverage.cost() + 7.4;
	}

	@Override
	public String description() {
		return beverage.description() + ", Milk";
	}
}


```

```JAVA

package com.praveen.designpatterns.structural.decorator;

public class HotChocolate implements MenuItem{

	@Override
	public double cost() {
		return 20.5;
	}

	@Override
	public String description() {
		return "Hot Chocolate";
	}

}


```

```JAVA

package com.praveen.designpatterns.structural.decorator;

public class Mocha extends Decorator{

	public Mocha(MenuItem _beverage) {
		super(_beverage);
	}

	@Override
	public double cost() {
		return beverage.cost() + 5.0;
	}

	@Override
	public String description() {
		return beverage.description() + ", Mocha";
	}

}


```

```JAVA

package com.praveen.designpatterns.structural.decorator;

public class Espresso implements MenuItem{

	@Override
	public double cost() {
		return 18.0;
	}

	@Override
	public String description() {
		return "Espresso roast";
	}
}


```

```JAVA

package com.praveen.designpatterns.structural.decorator;

public class Main {

	public static void main(String[] args) {

		// Order hot chocolate
		MenuItem beverage = new HotChocolate();

		// add mocha flavor to it
		beverage = new Mocha(beverage);

		// get invoice
		System.out.println("Your Order: " + beverage.description());
		System.out.println("Total Cost: " + beverage.cost());

	}

}


```

### Limitations
- New class for every feature
- Number of Objects are more hence more complexity
- More complex for client

### Decorator pattern examples in JDK
- All subclasses of java.io.InputStream, OutputStream, Reader and Writer have a constructor taking an instance of same type.
- java.util.Collections, the checkedXXX(), synchronizedXXX() and unmodifiableXXX() methods.
- javax.servlet.http.HttpServletRequestWrapper and HttpServletResponseWrapper
- javax.swing.JScrollPane

## Template Method Design Pattern

Template Method Design Pattern is a Behavioral Design Pattern.
In this pattern, we will have base template method; it defines an algorithm with some abstract steps. These steps have to be implemented by sub-classes.

For example, I have a class called DataRenderer this class is responsible for rendering the data to output console. But to render the data first; we need to read and process it. so we have methods like readData() and processData(). But these methods will be declared as abstract as there are multiple sources from which you can read the data and multiple ways you can process it. But to render the data you need to read and process it, so the algorithm for render() is fixed which is read and process but how to read, from where to read and how to process is left to sub-classes to handle as shown below.

```JAVA

package com.praveen.designpatterns.behavioral.template;

public abstract class DataRenderer {

	// algorithm is fixed
	public final void render() {
		String data = null;
		String pData = null;
		data = readData();
		pData = processData(data);
		System.out.println(pData);
	}

	protected abstract String readData();

	protected abstract String processData(String data);

}


```

```JAVA

package com.praveen.designpatterns.behavioral.template;

public class XMLDataRenderer extends DataRenderer {
	
	@Override
	protected String readData() {
		return "xml data";
	}

	@Override
	protected String processData(String data) {
		return "processed " + data;
	}

	

}


```

```JAVA

package com.praveen.designpatterns.behavioral.template;

public class TextDataRenderer extends DataRenderer {
	
	@Override
	protected String readData() {
		return "text data";
	}

	@Override
	protected String processData(String data) {
		return "processed " + data;
	}

	

}


```

```JAVA

package com.praveen.designpatterns.behavioral.template;

public class Main {

	public static void main(String[] args) {

		DataRenderer renderer = new XMLDataRenderer();
		renderer.render();
	}

}


```

In the above example the responsibilities of reading and processing the data is left to the sub-classes. render() method remains same calling the methods of your sub-classes.

Now if client wants to render the data, he can create an object of XMLDataRenderer or TextDataRenderer and has to call the render() method which thereby delegate the call to readData() and processData() as per the algorithm shown above.

We have declared the render() method as final in base class so that the subclasses cannot change the behavior of it.

### Advantages

- There is no code duplication.
- Code reuse happens with the Template Method pattern as it uses inheritance and not composition. Only a few methods need to be overridden.
- Flexibility lets subclasses decide how to implement steps in an algorithm.

### Disadvantages

- Debugging and understanding the sequence of flow in the Template Method pattern can be confusing at times. You may end up implementing a method that shouldn't be implemented or not implementing an abstract method at all. Documentation and strict error handling has to be done.











 




