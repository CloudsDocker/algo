import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by todzhang on 2017/1/31.
 *
 *
 * To customize a Thread base
 */

public class MyAppThread extends Thread{
    private static final String DEFAULT_NAME="MyAppThread";

    private static volatile boolean debugLifeCycle=false;
    private static final AtomicInteger created=new AtomicInteger();
    private static final AtomicInteger alive=new AtomicInteger();
    private static final Logger log=Logger.getAnonymousLogger();

    public MyAppThread(Runnable commad){
        this(commad,DEFAULT_NAME);
    }

    // constructor, to setup UnCaughtExceptionHandler, e.g. to log it
    public MyAppThread(Runnable command,String name){
        super(command,name+"-"+created.incrementAndGet());
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            public void uncaughtException(Thread t, Throwable e){
                log.log(Level.SEVERE,"UNCAUGHT in thread "+t.getName(),e);
            }
        });
    }

    public void run(){
        // copy debug flag to ensure consistent value throughtout
        boolean debug=debugLifeCycle;
        if(debug){
            log.log(Level.FINE,"Created "+getName());
        }

        try{
            alive.incrementAndGet();
            super.run();
        }
        finally {
            alive.decrementAndGet();
            if(debug){
                log.log(Level.FINE,"Existing "+getName());
            }
        }
    }

    public static int getThreadCreated(){return created.get();}
    public static int getThreadsAlive(){return alive.get();}
    public static boolean getDebug(){return debugLifeCycle;}
}