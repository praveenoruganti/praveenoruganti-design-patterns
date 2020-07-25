package com.praveenoruganti.designpatterns.creational.abstractfactory;

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
