import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeLevelOrderTraverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=TreeBuilder.initTree();
		System.out.println("\n----level order traverse----");
		// the two dimension list
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		levelOrderBFS(result,root,0);
		for (List<Integer> list : result) {
			for (Integer integer : list) {
				System.out.print(integer+",");
			}
			System.out.println();
		}
		/*
		Stack<Integer> levelOrderStack=new Stack<Integer>();
		levelOrderTraverse(root,levelOrderStack);
		for (Integer integer : levelOrderStack) {
			System.out.print(integer+",");
		}
		*/
	}
	private static void levelOrderBFS(List<List<Integer>> result,TreeNode node, int level){
		if(node==null)
			return;
			
		if(level>=result.size()){
			// means we are in next level, add a new sub list
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(node.value);
		levelOrderBFS(result,node.left,level+1);
		levelOrderBFS(result,node.right,level+1);
	}
	private static void levelOrderTraverse(TreeNode node,Stack<Integer> levelOrderStack){
		if(node==null)
			return;
		levelOrderStack.push(node.value);
		levelOrderTraverse(node.left, levelOrderStack);
		levelOrderTraverse(node.right, levelOrderStack);
		
	}

}
