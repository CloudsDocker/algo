import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;

/**
 * We use checksum and CyclicBarrier to test multipe threads about BoundedQueue
 * @author todzhang
 *
 */
public class PutTakeTest {

	private static final ExecutorService pool = Executors.newCachedThreadPool();
	private final AtomicInteger putSum = new AtomicInteger(0);
	private final AtomicInteger takeSum = new AtomicInteger(0);
	private final CyclicBarrier barrier;
	private final BoundedBufferBySemaphore<Integer> bb;
	private final int nTrials, nPairs;

	public PutTakeTest(int capacity, int nPairs, int nTrails) {
		bb = new BoundedBufferBySemaphore<>(capacity);
		this.nPairs = nPairs;
		this.nTrials = nTrails;
		barrier = new CyclicBarrier(2 * nPairs + 1);
	}

	void test() {
		try {
			for (int i = 0; i < nPairs; i++) {
				pool.execute(new Producer());
				pool.execute(new Consumer());
			}
			barrier.await(); // wait for all threads to be ready
			barrier.await(); // wait for all threads to finish
			// We'll get errors if remove mutex in following methods
			//   private synchronized void doInsert(E x){
			System.out.println("----- putsum is :"+putSum.get());
			System.out.println("----- takesum is :"+takeSum.get());
			Assert.assertEquals(putSum.get(), takeSum.get());
			System.out.println("======= Test Done========");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------- test start-------");
		new PutTakeTest(10, 10, 1_00_000).test();
		pool.shutdown();
	}

	// Marsaglia, 2003
	static int xorShift(int y) {
		y ^= (y << 6);
		y ^= (y >>> 21);
		y ^= (y << 7);
		return y;
	}

	// inner class of PutTakeTest
	class Producer implements Runnable {
		public void run() {
			try {
				int seed = (this.hashCode() ^ (int) System.nanoTime());
				int sum = 0;
				// the first barrier await make sure go ahead testing when
				// both producer and consumer are all ready, so start testing
				// almost at same time
				barrier.await();
				for (int i = nTrials; i > 0; --i) {
					bb.put(seed);
					sum += seed;
					seed = xorShift(seed);
				}
				putSum.getAndAdd(sum);
				// this is the second barrier await, to make sure all
				// consumers and producers are all ready at almost same time
				barrier.await();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	class Consumer implements Runnable {
		public void run() {
			try {
				barrier.await();
				int sum = 0;
				for (int i = nTrials; i > 0; --i) {
					sum += bb.take();
				}
				takeSum.getAndAdd(sum);
				barrier.await();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
