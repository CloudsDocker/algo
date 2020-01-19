import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement an own semaphore based on Lock java.util.concurrent is NOT
 * implemented like this.
 * 
 * @author todzhang
 *
 */
public class SemaphoreOnLock {
//	AbstractQueuedSynchronizer aqs=new 
	private final Lock lock = new ReentrantLock();
	// condition predicate : permitAvailable (permits>0)
	private final Condition permitsAvailable = lock.newCondition();
	private int permits;

	public SemaphoreOnLock(int initPermits) {
		lock.lock();
		try {
			this.permits = initPermits;
		} finally {
			lock.unlock();
		}
	}
	
	// block until: permitAvaiable
	public void accquire() throws InterruptedException{
		lock.lock();
		try {
			while(permits<=0)
				permitsAvailable.await();
			--permits;
		} finally {
			lock.unlock();
		}
	}
	
	public void release(){
		lock.lock();
		try {
			++permits;
			permitsAvailable.signal();
		} finally {
			lock.unlock();
		}
	}
}
