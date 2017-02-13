package me.todzhang;

public class FindLowestCommonAncestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root=TreeBuilder.initBinaryTree();
		TreeNode ancestor=findCommonAncestor(new TreeNode(6), new TreeNode(17), root);
		System.out.println("the common ancestor is:"+ancestor);
	}
	
	public static TreeNode findCommonAncestor(TreeNode node1,TreeNode node2,TreeNode focusNode){
		TreeNode rtn=null;
		if(node1.value<focusNode.value&&node2.value<focusNode.value){
			rtn=findCommonAncestor(node1, node2, focusNode.left);			
		}
		else if(node1.value>focusNode.value&&node2.value>focusNode.value){
			rtn=findCommonAncestor(node1, node2, focusNode.right);			
		}
		else
		{
			rtn = focusNode;
		}
		return rtn;
	}

}


Regards,

Todd Zhang PMP 张磊 
HSBC Operations, Services & Technology (HOST) GB&M, Project Management | The Hongkong and Shanghai Banking Corporation Limited
29/F, HSBC Building, Shanghai IFC, 8 Century Avenue, Shanghai 200120
___________________________________________________________________________________

Phone.     86-21-38883959; 71862183959
Mobile.      135 2430 6108
Email.       todd.zhang@hsbc.com.cn
___________________________________________________________________________________

