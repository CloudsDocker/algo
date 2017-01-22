package me.todzhang;

import java.util.concurrent.Semaphore;

public class SemaphoneTest {

	Semaphore mutal = new Semaphore(1);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SemaphoneTest test = new SemaphoneTest();

//		for (int i = 0; i < 3; i++) {

			new Thread() {
				@Override
				public void run() {
					test.mutalExclusion();
				}
			}.start();
			
			
			new Thread() {
				@Override
				public void run() {
					test.mutalExclusion();
				}
			}.start();
//		}

	}

	private void mutalExclusion() {
		try {
			mutal.acquire();
			System.out
					.println("==== get mutal exclusion signal, then sleep ====");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mutal.release();
			System.out
					.println("------------ released semahpone ---------------");
		}
	}

}
