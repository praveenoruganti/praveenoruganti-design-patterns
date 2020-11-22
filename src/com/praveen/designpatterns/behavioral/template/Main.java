package com.praveen.designpatterns.behavioral.template;

public class Main {

	public static void main(String[] args) {

		DataRenderer renderer = new XMLDataRenderer();
		renderer.render();
	}

}
