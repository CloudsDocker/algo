/**
 * Created by todzhang on 2017/1/31.
 *
 * Customized Thread Factory, used in ExecutionService. You implement ThreadFactory, and override "newThread"
 */
public class MyThreadFactory implements java.util.concurrent.ThreadFactory{
    private final String poolName;
    public MyThreadFactory(String name){
        this.poolName=name;
    }
    public Thread newThread(Runnable command){
        return new MyAppThread(command,poolName);
    }


}
