import java.util.concurrent.BlockingQueue;

/**
 * Created by todzhang on 2017/2/1.
 * Imagine an application where N threads execute doWork in Listing 11.1,
 * fetch- ing tasks from a shared work queue and processing them;
 * assume that tasks do not depend on the results or side effects of other tasks.
 * Ignoring for a moment how the tasks get onto the queue, how well will this application
 * scale as we add processors? At first glance, it may appear that the application
 * is completely paral- lelizable: tasks do not wait for each other, and the
 * more processors available, the more tasks can be processed concurrently.
 * However, there is a serial component as well—fetching the task from the work queue.
 * The work queue is shared by all the worker threads, and it will require some amount
 * of synchronization to main- tain its integrity in the face of concurrent access.
 * If locking is used to guard the state of the queue, then while one thread is dequeing a task,
 * other threads that need to dequeue their next task must wait—and this is
 * where task processing is serialized.
 */
public class SerialAccessToTaskQueue extends Thread{
    private final BlockingQueue<Runnable> queue;

    public SerialAccessToTaskQueue(BlockingQueue<Runnable> inputQueue){
        this.queue=inputQueue;
    }

    public void run(){
        while(true){
            try{
                Runnable task=queue.take();
                task.run();
            } catch (InterruptedException e){
                break; /* allow thread to exit */
            }
        }
    }
}
