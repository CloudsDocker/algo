import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

/**
 * Created by todzhang on 2017/1/30.
 */
public class TimedRun {

    public static void timedRunFoo(Runnable r, long timeout, TimeUnit unit) throws InterruptedException{
        ExecutorService taskExec=  Executors.newFixedThreadPool(10);

        Future<?> task= taskExec.submit(r);
        try {
            task.get(timeout,unit);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            //task will be canceled
            e.printStackTrace();
        }
        finally{
            // harmless if task already completed
            task.cancel(true); // interrupt if running.
        }


    }
}
