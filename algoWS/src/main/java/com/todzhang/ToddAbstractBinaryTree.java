import java.util.ArrayList;
import java.util.List;

public abstract class ToddAbstractBinaryTree<T> extends ToddAbstractTree<T> implements ToddIBinaryTree<T> {

	/**
	 * 
	// the logic is :
	 * get parent
	 * if this == left(parent), then return right(parent)
	 * otherwise, return left(parent)
	 */
	
	public Position<T> sibling(Position<T> p){
		Position<T> parent=parent(p);
		if (parent==null)
			return null; // p must be root, as it has no parent
		if(p==left(parent)){
			return right(parent);
		}
		else{
			return left(parent);
		}
	}
	
	// return the number of children of current position
	public int numChildren(Position<T> p){
		int counter=0;
		if(left(p)!=null)
			++counter;
		if(right(p)!=null)
			++counter;
		return counter;
	}
	
	public Iterable<Position<T>> children(Position<T> p){
		List<Position<T>> snapshot=new ArrayList<>(2); // max children is 2
		if(left(p)!=null)
			snapshot.add(left(p));
		if(right(p)!=null)
			snapshot.add(right(p));
		return snapshot;
	}
}
