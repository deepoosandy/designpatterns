package com.designpattern.creational;

public class SingletonDesignPattern {
	private static volatile SingletonDesignPattern singletonDesignPattern = null;

	private SingletonDesignPattern() {
	}

	public static SingletonDesignPattern getSingletonDesignPattern() {

		if (singletonDesignPattern == null) {
			synchronized (SingletonDesignPattern.class) {
				if (singletonDesignPattern == null) {
					singletonDesignPattern = new SingletonDesignPattern();
				}
			}

		}

		return singletonDesignPattern;
	}
}
