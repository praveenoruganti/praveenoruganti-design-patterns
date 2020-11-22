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
