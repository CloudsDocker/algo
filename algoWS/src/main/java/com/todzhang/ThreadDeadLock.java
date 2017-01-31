import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by todzhang on 2017/1/31.
 */
public class ThreadDeadLock {
    ExecutorService exec= Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String> {
        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            Future<String> header,footer;
            header=exec.submit(new LoadFileTask("header.html"));
            footer=exec.submit(new LoadFileTask("footer.html"));
            String body=renderBody();
            return header.get()+body+footer.get();
        }
    }
}
