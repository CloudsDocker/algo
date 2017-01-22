package me.todzhang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class NotifyWaitDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NotifyWaitDemo inst=new NotifyWaitDemo();
		Queue<Integer> buffer=new LinkedList<Integer>();
		int maxSize=3;
		new Thread(inst.new Producer("PRODUCER", buffer, maxSize)).start();
		new Thread(inst.new Consumer("CONSUMER", maxSize, buffer)).start();

	}
	
	class Producer extends Thread{
		private String name;
		private Queue<Integer> queue;
		private int maxSize;
		
		public Producer(String name, Queue<Integer> queue, int maxSize) {
			super(name);			
			this.queue = queue;
			this.maxSize = maxSize;
		}

		@Override
		public void run(){
			while(true){
				synchronized (queue) {
					while(queue.size()==maxSize){
						System.out.println("---- queue is full, Producer thread waiting fro consumer to take something from queue ");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					Random random=new Random();
					int i=random.nextInt();
					System.out.println("--- Producing value : "+i);
					queue.add(i);
					queue.notifyAll();
				}
			}			
		}
	}
	
	
	class Consumer extends Thread{
		private String name;
		private int maxSize;
		private Queue<Integer> queue;
		public Consumer(String name, int maxSize, Queue<Integer> queue) {
			super(name);			
			this.maxSize = maxSize;
			this.queue = queue;
		}
		
		@Override
		public void run(){
			while(true){
				synchronized(queue){
					while(queue.isEmpty()){
						System.out.println("==== consumer is empty, wating for producer to put something");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					System.out.println("==== consumer value: "+ queue.remove());
					queue.notifyAll();
				}
			}
		}
		
		
	}

}
