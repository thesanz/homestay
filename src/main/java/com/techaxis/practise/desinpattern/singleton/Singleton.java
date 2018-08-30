package com.techaxis.practise.desinpattern.singleton;

public class Singleton {
	private static final Singleton instance = new Singleton();

	// private constructor to avoid client applications to use constructor
	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

	public void print() {
		System.out.println("This is singleTon Message!!");
	}

}