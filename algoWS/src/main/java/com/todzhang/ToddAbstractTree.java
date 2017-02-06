package com.todzhang;

/**
 * An abstract base class providing some functionality of the Tree interface
 * @author todzhang
 *
 * @param <T>
 */
public abstract class ToddAbstractTree<T> implements ToddITree<T> {

	@Override
	public boolean isInternal(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return numChildren(p)>0;
	}

	@Override
	public boolean isExternal(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return numChildren(p)==0;
	}

	@Override
	public boolean isRoot(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return root()==p;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	/**
	 * depth logically is "1 + it's parent"
	 * 
	 * @param p
	 * @return
	 */
	public int depth(Position<T> p){
		if(isRoot(p)){
			return 0;
		}
		
		return 1+depth(parent(p));
	}
	
	/**
	 * logic is : if it's external i.e. leaf node, get it's depth
	 * to get max of it's depth and the cached maximum value
	 * be awared this is O(n*n)
	 * 
	 * @return
	 */
	public int heightBad(){
		int h=0;
		
		for(Position<T> p: positions()){
			if(isExternal(p)){
				h=Math.max(h, depth(p));
			}
		}
		return h;
		
	}
	
	/**
	 * The complexity is O(n)
	 * 
	 * @param p
	 * @return
	 */
	public int height(Position<T> p){
		int h=0;
		for(Position<T> c: children(p) ){
			h=Math.max(h, height(c));
		}
		return h;
	}
	
}
