public class ToddLinkedBinaryTree<T> extends ToddAbstractBinaryTree<T> {

	/*
	 * nested Node class
	 */
	protected static class Node<T> implements Position<T> {

		private T element; // an element stored in this node
		private Node<T> parent; // a reference to parent (if any)
		private Node<T> left; // a reference to the left child (if any)
		private Node<T> right; // a reference to the right child (if any)

		public Node(T element, Node<T> parent, Node<T> left, Node<T> right) {
			super();
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		@Override
		public T getElement() {
			// TODO Auto-generated method stub
			return element;
		}

		// accessor method
		public Node<T> getParent() {
			return this.parent;
		}

		public Node<T> getLeft() {
			return this.left;
		}

		public Node<T> getRight() {
			return this.right;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

	}

	/**
	 * Factory method to create a new node storing element e
	 */
	protected Node<T> createNode(T e, Node<T> parent, Node<T> left, Node<T> right) {
		return new Node<T>(e, parent, left, right);
	}

	/**
	 * LinkedBinaryTree instance variables
	 */

	protected Node<T> root = null;
	private int size = 0;

	// constructor
	public ToddLinkedBinaryTree() {
	}; // construct an empty linked list binary tree.

	// non public utility
	/**
	 * validate the position and returns it as a node
	 */

	protected Node<T> validate(Position<T> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not a valid position type");

		Node<T> node = (Node<T>) p; // safe cast
		if (node.getParent() == node) {
			throw new IllegalArgumentException("p is not in tree anymore");
		}

		return node;
	}

	// return the number of nodes in the tree
	public int size() {
		return size;
	}

	// return the position of root
	public Position<T> root() {
		return root;
	}

	// return the position of parent
	public Position<T> parent(Position<T> p) throws IllegalArgumentException {
		Node<T> node = validate(p);
		return node.getParent();
	}

	// return the position of left
	public Position<T> left(Position<T> p) throws IllegalArgumentException {
		Node<T> node = validate(p);
		return node.getLeft();
	}

	// return the position of right
	public Position<T> right(Position<T> p) throws IllegalArgumentException {
		Node<T> node = validate(p);
		return node.getRight();
	}

	// update methods supported by this class

	public Node<T> addRoot(T e) throws IllegalStateException {
		if (!isEmpty())
			throw new IllegalStateException("not empty tree");

		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	// create a left child of Position p storing element e ; return its position
	public Position<T> addLeft(Position<T> p, T e) throws IllegalArgumentException {
		Node<T> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException("p already has a left child");
		}

		Node<T> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	// create a right child of Position p storing element e , return its
	// position
	public Position<T> addRight(Position<T> p, T e) throws IllegalArgumentException {
		Node<T> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException("p already has a right child");
		}

		Node<T> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	// replace the element at Position p with e and return the replaced element
	public T set(Position<T> p, T e) throws IllegalArgumentException {
		Node<T> node = validate(p);
		T temp = node.getElement();
		node.setElement(e);
		return temp;
	}

	// attach tree t1 and t2 as left and right subtree of external p
	public void attach(Position<T> p, ToddLinkedBinaryTree<T> t1, ToddLinkedBinaryTree<T> t2)
			throws IllegalArgumentException {
		Node<T> node = validate(p);
		if (isInternal(p))
			throw new IllegalArgumentException("p must be a leaft");
		size = t1.size() + t2.size();

		// attach t1 as left subtree of node
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.size = 0;
			t1.root = null;
		}

		// attach t2 as right subtree of note
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	// remove the node of postion p and replaces it with its subtree
	public T remove(Position<T> p) throws IllegalArgumentException {
		Node<T> node = validate(p);
		if (numChildren(p) == 2)
			throw new IllegalArgumentException("p has two position ");
		Node<T> child = (node.getLeft() != null ? node.getLeft() : node.getRight());

		if (child != null) {
			child.setParent(node.getParent());// child's grandparent become its
												// parent
		}

		// child becomes root
		if (node == root) {
			root = child;
		} else {
			Node<T> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		size--;
		T temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}

}
