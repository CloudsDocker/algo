package com.todzhang;

public class ToddLinkedBinaryTree<T> extends ToddAbstractBinaryTree<T> {

	/*
	 * nested Node class
	 */
	protected static class Node<T> implements Position<T>{

		private T element;  // an element stored in this node
		private Node<T> parent;	// a reference to parent (if any)
		private Node<T> left; 	// a reference to the left child (if any)
		private Node<T> right; 	// a reference to the right child (if any)
		
		
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
		
		//accessor method
		public Node<T> getParent(){return this.parent;}
		public Node<T> getLeft(){return this.left;}
		public Node<T> getRight(){return this.right;}


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
		
		/**
		 * Factory method to create a new node storing element e
		 */
		protected Node<T> createNode(T e,Node<T> parent,Node<T> left,Node<T> right){
			return new Node<T>(e, parent, left, right);
		}
	}
	
	/**
	 * LinkedBinaryTree instance variables
	 */
	
	protected Node<T> root=null;
	private int size=0;
	
	//constructor
	public ToddLinkedBinaryTree(){}; // construct an empty linked list binary tree.
	
}
