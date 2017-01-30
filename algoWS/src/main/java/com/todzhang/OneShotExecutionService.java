import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by todzhang on 2017/1/30.
 * If a method needs to process a batch of tasks and does not return
 * until all the tasks are finished, it can simplify service lifecycle management
 * by using a private Executor whose lifetime is bounded by that method.
 *
 *
 * The checkMail method in Listing checks for new mail in parallel
 * on a number of hosts. It creates a private executor and submits
 * a task for each host: it then shuts down the executor and waits
 * for termination, which occurs when all
 */
public class OneShotExecutionService {


    boolean checkMail(Set<String> hosts, long timeout, TimeUnit unit) throws InterruptedException{
        ExecutorService exec= Executors.newCachedThreadPool();
        final AtomicBoolean hasNewMail=new AtomicBoolean(false);
        try {
            for (final String host : hosts
                    ) {
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        if (checkMail(host)) {
                            hasNewMail.set(true);
                        }
                    }
                });
            }
        }
        finally{
            exec.shutdown();
            exec.awaitTermination(timeout,unit);
        }
        return hasNewMail.get();
    }

    boolean checkMail(String host){
        return true;
    }
}
