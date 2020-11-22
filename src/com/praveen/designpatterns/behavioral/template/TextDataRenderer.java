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
