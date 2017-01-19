package me.todzhang;

public class DoubleCheckedSingleton {

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
