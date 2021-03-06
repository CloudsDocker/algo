public class ConstructTreeByInOrderAndPosOrder {

	public static void main(String[] args) {

		int[] aryInOrder=new int[]{4,2,5,1,6,3,7};
		// in in-order array, the root it at exact middle 
		// the sub array left of root is left sub tree
		int[] aryPostOrder=new int[]{4,5,2,6,7,3,1}; 
		// in post order array, the last element is root
		
//		int nRoot=aryPostOrder[aryPostOrder.length-1];
		Index index=new Index();
		index.index=aryPostOrder.length-1;
		// to construct tree from in-order and post-order traverse
		TreeNode root=buildTree(aryInOrder, aryPostOrder,0,aryPostOrder.length-1,index);
		TreePrinter.printTree(root);
	}
	
	// class index to implement pass by reference
	static class Index{
		int index;
	}
	
	private static TreeNode buildTree(int[] in, int[] post, int nStart, int nEnd, Index pIndex){
		
		// base case
		if(nStart>nEnd){
			return null;
		}
		
		int nRoot=post[pIndex.index];
		TreeNode focusRoot=new TreeNode(nRoot);
		(pIndex.index)--;
		// remove the index
		
		// if no children, return the node
		if(nStart==nEnd){
			return focusRoot;
		}
		
		int nPosInRoot=0;
		
		// find position index of root element
		// be advised the root may NOT in exact middle, as the subtree may NOT be complete
		for(int n=0;n<in.length-1;n++){
			if(in[n]==nRoot){
				nPosInRoot=n;
				break;
			}
		}
		focusRoot.right=buildTree(in, post, nPosInRoot+1, nEnd, pIndex);
		focusRoot.left=buildTree(in,post,nStart,nPosInRoot-1,pIndex);

//		focusRoot.left=buildTree(Arrays.copyOfRange(in, 0, nPosInRoot), Arrays.copyOfRange(post, 0, nPosInRoot));
//		focusRoot.right=buildTree(Arrays.copyOfRange(in, nPosInRoot+1,in.length-1), Arrays.copyOfRange(post, nPosInRoot+1,post.length-1));
		return focusRoot;
	}

}













//
//
//
//
//
////Java program to construct a tree using inorder
////and postorder traversals
//
///* A binary tree node has data, pointer to left
//child and a pointer to right child */
//class Node 
//{
// int data;
// Node left, right;
//
// public Node(int data) 
// {
//     this.data = data;
//     left = right = null;
// }
//}
//
////Class Index created to implement pass by reference of Index
//class Index 
//{
// int index;
//}
//
//class BinaryTree 
//{
// /* Recursive function to construct binary of size n
//    from  Inorder traversal in[] and Preorder traversal
//    post[].  Initial values of inStrt and inEnd should
//    be 0 and n -1.  The function doesn't do any error
//    checking for cases where inorder and postorder
//    do not form a tree */
// Node buildUtil(int in[], int post[], int inStrt,
//         int inEnd, Index pIndex) 
// {
//     // Base case
//     if (inStrt > inEnd)
//         return null;
//
//     /* Pick current node from Preorder traversal using
//        postIndex and decrement postIndex */
//     Node node = new Node(post[pIndex.index]);
//     (pIndex.index)--;
//
//     /* If this node has no children then return */
//     if (inStrt == inEnd)
//         return node;
//
//     /* Else find the index of this node in Inorder
//        traversal */
//     int iIndex = search(in, inStrt, inEnd, node.data);
//
//     /* Using index in Inorder traversal, construct left and
//        right subtress */
//     node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex);
//     node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex);
//
//     return node;
// }
//
// // This function mainly initializes index of root
// // and calls buildUtil()
// Node buildTree(int in[], int post[], int n) 
// {
//     Index pIndex = new Index();
//     pIndex.index = n - 1;
//     return buildUtil(in, post, 0, n - 1, pIndex);
// }
//
// /* Function to find index of value in arr[start...end]
//    The function assumes that value is postsent in in[] */
// int search(int arr[], int strt, int end, int value) 
// {
//     int i;
//     for (i = strt; i <= end; i++) 
//     {
//         if (arr[i] == value)
//             break;
//     }
//     return i;
// }
//
// /* This funtcion is here just to test  */
// void preOrder(Node node) 
// {
//     if (node == null)
//         return;
//     System.out.print(node.data + " ");
//     preOrder(node.left);
//     preOrder(node.right);
// }
//
// public static void main(String[] args) 
// {
//     BinaryTree tree = new BinaryTree();
//     int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
//     int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
//     int n = in.length;
//     Node root = tree.buildTree(in, post, n);
//     System.out.println("Preorder of the constructed tree : ");
//     tree.preOrder(root);
// }
//}
//
////This code has been contributed by Mayank Jaiswal(mayank_24)
