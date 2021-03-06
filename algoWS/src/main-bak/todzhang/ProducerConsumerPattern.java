package me.todzhang;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import static java.lang.System.out;


public class ProducerConsumerPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BlockingQueue sharedQueue=new ArrayBlockingQueue<Integer>(2);
		Thread prod=new Thread(new Producer(sharedQueue));
		Thread cons=new Thread(new Consumer(sharedQueue));
		prod.start();
		cons.start();
		
	}
	
	static class Producer implements Runnable{
		private final BlockingQueue queue;
		public void run(){
			for (int i = 0; i < 10; i++) {
				try {
					out.println("----Produced:"+i);
					queue.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public Producer(BlockingQueue queue) {
			super();
			this.queue = queue;
		}		
	}
	
	static class Consumer implements Runnable{
		private final BlockingQueue queue;
		public void run(){
			for (int i = 0; i < 10; i++) {
				try {
					out.println("consumed:"+queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//		public Consumer(BlockingQueue queue) {
//			super();
//			this.queue = queue;
//		}
		
		
		public Consumer(BlockingQueue sharedQueue){
			this.queue=sharedQueue;
		}
	}

}
