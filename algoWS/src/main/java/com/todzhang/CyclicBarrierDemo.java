import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierDemo {

	/**
	 * CyclicBarrier is useful for kind of map-reduce pattern
	 * the reduce job will start once all Map jobs done, 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CyclicBarrier cb=new CyclicBarrier(3, new Thread(){
			@Override
			public void run(){
				// this task will be executed once all threads reaches barrier
				System.out.println("====== All parties are arrived at barrier, let's do something together");
			}
		});
		
		new Thread(new Task(cb)).start();
		new Thread(new Task(cb)).start();
		new Thread(new Task(cb)).start();
	}
	
	private static class Task implements Runnable{
		private CyclicBarrier barrier;
		
		public Task(CyclicBarrier inBarrier){
			this.barrier=inBarrier;
		}
		
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+" is waiting on barrier");
			// it will be dormant before all parties to await   
			try {
				barrier.await();
				System.out.println("---"+Thread.currentThread().getName()+" has crossed the barrier");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.INFO,null,e);
				e.printStackTrace();
			
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.INFO,null,e);
				e.printStackTrace();
			}
		}
	}

}
