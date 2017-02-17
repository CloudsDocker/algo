package com.todzhang;

public class TreeGetMinDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode node=TreeBuilder.initTree();
		TreePrinter.printTree(node);
		System.out.println("==== min depth is :"+minDepth(node));
	}
	
	private static int minDepth(TreeNode root){
		if(root==null){
			return Integer.MAX_VALUE;
		}
		
		// this is leaf node, return 1;
		if(root.left==null && root.right==null){
			return 1;
		}
		
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}

}
