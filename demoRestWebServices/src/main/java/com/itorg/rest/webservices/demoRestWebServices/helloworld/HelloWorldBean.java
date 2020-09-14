package com.itorg.rest.webservices.demoRestWebServices.helloworld;

public class HelloWorldBean {

	private String message;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("Hello World Bean[message=%s]", message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
