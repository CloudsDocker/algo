package com.todzhang;

public class TreeTraverser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root=TreeBuilder.initTree();
		System.out.println("----pre order ----");
		preOrder(root);	
		System.out.println("\n----in order ----");
		inOrder(root);
		System.out.println("\n----post order ----");
		postOrder(root);
	}

	
	private static void preOrder(TreeNode node){
		if(node==null){
			return;
		}
		
		System.out.print(node.value+",");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private static void inOrder(TreeNode node){
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.value+",");
		inOrder(node.right);
	}

	private static void postOrder(TreeNode node){
		if(node==null)
			return;
		postOrder(node.left);		
		postOrder(node.right);
		System.out.print(node.value+",");
	}
}
