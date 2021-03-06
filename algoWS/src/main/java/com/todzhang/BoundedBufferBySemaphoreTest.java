import static org.junit.Assert.*;

/**
 * Created by todzhang on 2017/2/2.
 */
public class BoundedBufferBySemaphoreTest {
    @org.junit.Test
    public void isEmpty() throws Exception {

    }

    @org.junit.Test
    public void isFull() throws Exception {

    }

    @org.junit.Test
    public void put() throws Exception {

    }

    @org.junit.Test
    public void take() throws Exception {

    }
    
    @org.junit.Test
    public void testTakeBlocksWhenEmpty(){
    	final BoundedBufferBySemaphore<Integer> bb=new BoundedBufferBySemaphore<>(10);
    	Thread taker=new Thread(){
    		public void run(){
    			try{
    				int unused=bb.take();
    				fail("if we get here, failed as above take() does NOT blocked");
    			}
    			catch(InterruptedException success){}
    		}
    	};
    	
    	try{
    		taker.start();
    		Thread.sleep(2*1000);
    		taker.interrupt();
    		taker.join(2*1000);
    		assertFalse(taker.isAlive());
    	}
    	catch(Exception unexpected){
    		fail();
    	}
    }
    
    
    
    
    

}