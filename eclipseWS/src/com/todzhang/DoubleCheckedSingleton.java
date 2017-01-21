package me.todzhang;

import java.io.Serializable;

public class DoubleCheckedSingleton implements Serializable{

	/**
	 * Another problem with conventional Singletons are that once you implement serializable
	 *  interface they are no longer remain Singleton because readObject() method 
	 *  always return a new instance just like constructor in Java. 
	 *  you can avoid that by using readResolve() method and discarding newly created
	 *   instance by replacing with Singeton as shwon in below example :

	    //readResolve to prevent another instance of Singleton
	    private Object readResolve(){
	        return INSTANCE;
	    }
	This can become even more complex if your Singleton Class maintain state, 
	as you need to make them transient, but witn Enum Singleton, Serialization is guarnateed by JVM.
	 * 
	 *
	 */
	private Object readResolve(){
		return INSTANCE;
	}
	
	private static volatile DoubleCheckedSingleton INSTANCE;
	
	private DoubleCheckedSingleton(){};
	
	public static DoubleCheckedSingleton getInstance(){
		//lazy loaded Singleton
		if(INSTANCE==null){
			synchronized(DoubleCheckedSingleton.class){
				//double checking Singleton instance
				if(INSTANCE==null){
					INSTANCE=new DoubleCheckedSingleton();
				}
			}
		}
		return INSTANCE;
	}

}
