public class ConstructTreeByPreOrderAndInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root=TreeBuilder.initCompleteBST();
		TreePrinter.printTree(root);
		
		int[] in=new int[]{4,2,5,1,6,3,7};
		int[] pre=new int[]{1,2,4,5,3,6,7};
		Index index=new Index(0);
		
		System.out.println("========= construct tree ============");
		TreeNode newTree=constructTree(pre, in, 0, in.length-1, index);
		TreePrinter.printTree(newTree);
		
	}
	
	private static TreeNode constructTree(int[] pre,int[] in, int start, int end, Index index){
//		
//		if(start>end){
//			return null;
//		}
		
		// traverse from left one by one in pre-order list,
		int rootValue=pre[index.index];
		
		TreeNode root=new TreeNode(rootValue);
		
		// increase the pointer
		(index.index)++;
		
		// base case
		if(start==end){
			return root;
		}
		
		int nInPos=0;
		// find the location of 'root' in in-order traverse
		for(int i=0;i<in.length;i++){
			if(in[i]==rootValue){
				nInPos=i;
				break;
			}
		}
		
		// recursively construct sub tree
		root.left=constructTree(pre, in, start, nInPos-1, index);
		root.right=constructTree(pre, in, nInPos+1, end, index);
		
		return root;
		
	}
	
	static class Index{
		int index;
		public Index(int i){
			this.index=i;
		}
	}

}
