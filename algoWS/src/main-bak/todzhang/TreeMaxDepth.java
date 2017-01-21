package me.todzhang;

public class TreeMaxDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMaxDepth inst=new TreeMaxDepth();		
		TreeNode root=TreeBuilder.initTree();
		System.out.println("--- max length is :"+inst.maxDepth(root));
		System.out.println("--- min length is :"+inst.minDepth(root));
	}
	
	
	private int maxDepth(TreeNode node){
		if(node==null){
			return 0;
		}
		
		return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
	}
	
	private int minDepth(TreeNode node){
		if(node==null){
			return 0;
		}
		
		return 1+Math.min(maxDepth(node.left), maxDepth(node.right));
	}
	
	

}
