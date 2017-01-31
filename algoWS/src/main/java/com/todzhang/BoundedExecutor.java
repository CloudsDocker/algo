import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Using a Semaphore to throttle task submission.
 * Created by todzhang on 2017/1/31.
 */
public class BoundedExecutor {
    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, Semaphore semaphore) {
        this.exec = exec;
        this.semaphore = semaphore;
    }

    public void submitTask(final Runnable runnable) throws InterruptedException {

        semaphore.acquire();

        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        runnable.run();
                    } finally

                    {
                        semaphore.release();
                    }
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }
    }
}
