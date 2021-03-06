/**
 * An interface for a binary tree, in which each node has at most two children
 * @author todzhang
 *
 * @param <T>
 */
public interface ToddIBinaryTree<T> extends ToddITree<T> {

	Position<T> left(Position<T> p) throws IllegalArgumentException;
	Position<T> right(Position<T> p) throws IllegalArgumentException;
	Position<T> sibling(Position<T> p) throws IllegalArgumentException;
	
	
}
