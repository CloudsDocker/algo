package me.todzhang;
import static java.lang.System.out;

public class DoubleCheckedSingletonTester{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		DoubleCheckedSingletonTester t=new DoubleCheckedSingletonTester();
		Thread thread=null;
		
		for (int i = 0; i < 10; i++) {
			if(i%2==0)
			{
				thread=new Thread(t.new testerThread());
			}
			else
			{
				thread=new Thread(t.new testerThread2());
			}
			thread.start();			
		}
		
	}

	
	
	class testerThread  implements Runnable{

		public void run() {
			
			DoubleCheckedSingleton t=DoubleCheckedSingleton.getInstance();
			out.println(t);
		}
			
	}
	
	class testerThread2 extends Thread{

		public void run() {
			DoubleCheckedSingleton t=DoubleCheckedSingleton.getInstance();
			out.println(t);
		}
		
	}

}
