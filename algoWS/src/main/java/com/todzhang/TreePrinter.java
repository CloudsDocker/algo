import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePrinter {

	
	public static int getHeight(TreeNode root){
		if(root==null)
			return 0;
		return 1+Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static void printTree(TreeNode root){
		// get tree height
		int height=getHeight(root);
		// print the tree node recursively
		printNodeWorker(Collections.singletonList(root), 1, height);
	}
	
	private static boolean isAllEmpty(List<TreeNode> list){
		for(TreeNode node: list){
			if(node!=null)
				return false;
		}
		return true;
	}
	
	private static void printNodeWorker(List<TreeNode> nodes, int level,int height){
		
		if(nodes.isEmpty() || isAllEmpty(nodes)){
			return;
		}
		
		int floor=height-level; // if height=4 , so floor =4-1=3
		int edgeLines=(int)Math.pow(2, (Math.max(floor-1, 0))); 
		// floor -1 =2, so lines is 2*2=4
		// this is been 2 times N
		int firstSpaces=(int)Math.pow(2, floor)-1; 
		// floor is 3, so it's return 7
		int betweenSpaces=(int)Math.pow(2, (floor+1))-1;
		// floor + 1=4, so betweenSpaces is 15
		
		printSpaces(firstSpaces);
		List<TreeNode> newNodes=new ArrayList<>();
		for(TreeNode node : nodes){
			if(node!=null){
				System.out.print(node.value);
				newNodes.add(node.left);
				newNodes.add(node.right);
			}else{
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			// after print one node,
			// print the spaces between it and its sibling
			printSpaces(betweenSpaces);
		}
		System.out.println("");
		// the next part is printing / or \
		// link this layer with its children
		for(int i=1;i<=edgeLines;i++){
			for(int j=0;j<nodes.size();j++){
				printSpaces(firstSpaces-i);
				// no child, just print space
				if(nodes.get(j)==null){
					printSpaces(edgeLines+edgeLines+i+1);
					continue;
				}
				
				if(nodes.get(j).left!=null){
					System.out.print("/");
				}else{
					printSpaces(1);
				}
				
				printSpaces(i+i-1);
				
				if(nodes.get(j).right!=null){
					System.out.print("\\");
				}else{
					printSpaces(1);
				}
				printSpaces(edgeLines+edgeLines-i);
			}
			System.out.println("");
		}
		printNodeWorker(newNodes, level+1, height);
	}
	
	private static void printSpaces(int n){
		for (int i = 0; i < n; i++) {
			// to force 'visible' the placeholder, use tide
			// once confirmed the algorithm, replace it with space
			System.out.print("~");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root=TreeBuilder.initTree();
		TreeNode root=TreeBuilder.initCompleteBST();
		printTree(root);
	}

}
