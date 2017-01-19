package me.todzhang;

public class StaticFactorySingleton {

	// this is private, static and final instance
	// as it's static, so this variable will be
	// initialized during class loading, so it's
	// singleton inherently
	private static final StaticFactorySingleton INSTANCE=new StaticFactorySingleton();
	
	// private constructor
	private StaticFactorySingleton(){
		System.out.println("----Singleton iniatilized----");
	};
	
	public static StaticFactorySingleton getInstance(){
		return INSTANCE;
	}
	

}
