package com.todzhang;

public class TreeNode {

	public  int value=Integer.MIN_VALUE;
	
	public  TreeNode left=null;
	public  TreeNode right=null;
	public TreeNode(int value) {
		super();
		this.value = value;
	}
	@Override
	public String toString() {		
		return String.format(" value is %d, and left is [%s], right is [%s]",value,left==null?"":left,right==null?"":right);
	}
	
}
