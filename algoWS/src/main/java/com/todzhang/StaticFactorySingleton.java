import java.io.Serializable;


public class StaticFactorySingleton implements Serializable{

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
