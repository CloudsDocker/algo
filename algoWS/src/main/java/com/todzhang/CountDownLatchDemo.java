import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountDownLatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final CountDownLatch latch=new CountDownLatch(3);
		
		Thread cacheService=new Thread(new Service("cacheService",2,latch));
		Thread alertService=new Thread(new Service("alertService",5,latch));
		Thread validationService=new Thread(new Service("validationService",2,latch));
		cacheService.start();
		alertService.start();
		validationService.start();
		
		try {
			latch.await();
			Logger.getLogger(Service.class.getName()).log(Level.INFO,"==== All services up, Applicaiton starting up====");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	static class Service implements Runnable{
		private final String name;
		private final int timeToStart;
		private final CountDownLatch latch;
		
		public Service(String name, int timeToStart,CountDownLatch latch){
			this.name=name;
			this.timeToStart=timeToStart;
			this.latch=latch;
		}
		
		public void run(){
			try {
				Thread.sleep(timeToStart*1000);
			} catch (InterruptedException e) {
				Logger.getLogger(Service.class.getName()).log(Level.SEVERE,null,e);
			}
			
			Logger.getLogger(Service.class.getName()).log(Level.INFO, name + " is UP.");
			latch.countDown();
		}
	}

}
