package me.todzhang;

public enum EnumSingleton {

	INSTANCE;

	private EnumSingleton() {
		System.out.println("---- enum singleton inlialized---");
	}
	
	

}