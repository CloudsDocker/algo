import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBoundedBuffered<T> {

	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	private final T[] items = (T[]) new Object[10]; // buffer size 10

	private int tail, head, count;

	// block until : not full
	public void put(T x) throws InterruptedException {
		lock.lock();

		try {
			while (count == items.length) {
				System.out.println("before notFull await");
				notFull.await();
				System.out.println("after notFull await");
			}
			items[tail] = x;
			System.out.println("assign " + x + " to " + tail);
			if (++tail == items.length) {
				System.out.println("reset tail to 0 ");
				tail = 0;
			}
			++count;
			notEmpty.signal();

		} finally {
			lock.unlock();
		}
	}

	// block until: notEmpty
	public T take() throws InterruptedException {
		lock.lock();
		try {

			while (count <= 0) {
				System.out.println("before notEmpty await");
				notEmpty.await();
				System.out.println("after notEmpty await");
			}
			T x = items[head];
			if (++head == items.length) {
				System.out.println("reset tail to 0 ");
				head = 0;
			}
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConditionBoundedBuffered<Integer> queue = new ConditionBoundedBuffered<>();
		Random r = new Random();
		for (int i = 0; i < 15; i++) {
			new Thread() {
				@Override
				public void run() {

					try {
						int i = r.nextInt(20);
						queue.put(i);
						System.out.println("=== put:" + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}.start();
		}

		for (int i = 0; i < 15; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						int i = queue.take();
						System.out.println("---- get :" + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}.start();
		}

	}

}
