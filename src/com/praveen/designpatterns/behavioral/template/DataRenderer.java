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
