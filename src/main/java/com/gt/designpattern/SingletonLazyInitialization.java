package com.gt.designpattern;

public class SingletonLazyInitialization {

	private static SingletonLazyInitialization instance;

	private SingletonLazyInitialization() {
	}

	public static SingletonLazyInitialization getInstance() {
		if (instance == null) {
			instance = new SingletonLazyInitialization();
		}
		return instance;
	}

}
