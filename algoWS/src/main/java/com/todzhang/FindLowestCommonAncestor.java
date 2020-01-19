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


