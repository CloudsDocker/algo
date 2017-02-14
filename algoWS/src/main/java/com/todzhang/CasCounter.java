package com.todzhang;

/**
 * a thread safe counter make use CAS, rather than Locks
 * @author todzhang
 *
 */
public class CasCounter {

	private SimulatedCAS value;
	
	public int getValue(){
		return value.get();
	}
	
	public int increment(){
		int v;
		do{
			// to get the value from cache
			v=value.get();
		} while (v!=value.compareAndSwap(v, v+1)); 
		// the value returned is differnt with the value in 
		// current thread stack, means other threads 
		// interferenced, as CAS is opptimistic 
		// so keep on retrying
		return v+1;
	}
}
