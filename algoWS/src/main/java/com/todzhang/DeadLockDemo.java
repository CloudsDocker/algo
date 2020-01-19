import static java.lang.System.out;

public class DeadLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DeadLockDemo inst=new DeadLockDemo();
		
		// below is dead lock
//		Thread trd1=new Thread(inst.new threadA());
//		Thread trd2=new Thread(inst.new threadB());
//		trd1.start();
//		trd2.start();
		
		// while below are NO dead lock
		Thread trd1=new Thread(inst.new threadSafeA());
		Thread trd2=new Thread(inst.new threadSafeA());
		trd1.start();
		trd2.start();
	}

	class threadA implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (String.class) {
				out.println("--- accquired lock String ---");
				synchronized(Integer.class){
					out.println("----- acuquired lock Integer ----");
				}
			}
		}
		
	}
	
	class threadB implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (Integer.class) {
				out.println("==== accquired lock  Integer  ====");
				synchronized(String.class){
					out.println("==== acuquired lock String ====");
				}
			}
		}
		
	}
	
	
	class threadSafeA implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (Integer.class) {
				out.println("--- accquired lock Integer ---");
				synchronized(String.class){
					out.println("----- acuquired lock String  ----");
				}
			}
		}
		
	}
	
	class threadSafeB implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (Integer.class) {
				out.println("==== accquired lock  Integer  ====");
				synchronized(String.class){
					out.println("==== acuquired lock String ====");
				}
			}
		}
		
	}
}
