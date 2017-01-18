package me.todzhang;

public class TreeMaxDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMaxDepth inst=new TreeMaxDepth();		
		TreeNode root=inst.initTree();
		System.out.println("--- max length is :"+inst.maxDepth(root));
	}
	
	
	private int maxDepth(TreeNode node){
		if(node==null){
			return 0;
		}
		
		return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
	}
	
	private TreeNode initTree(){
		
		TreeNode root=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		TreeNode node8=new TreeNode(8);
		
		root.left=node2;
		root.right=node3;
		
		node2.left=node4;
		node2.right=node5;
		
		node3.left=node6;
		node3.right=node7;
		
		node4.left=node8;
		
		return root;
	}

}
