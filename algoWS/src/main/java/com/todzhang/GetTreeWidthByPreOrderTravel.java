import java.util.Arrays;

//the idea is have an array, representing node counts for each layer
// use pre order traverse to get node and add counter, then traverse left sub tree and right sub tree
public class GetTreeWidthByPreOrderTravel {

 	class Node{
 		int value;
 		Node left,right;

 		public Node(int inValue){
 			this.value=inValue;
 		}
 	}
 	
 	private static int getMaxWidth(Node node){
 		int h=getHeight(node);
 		
 		int count[]=new int[h];
 		
 		int level=0;
 		getMaxWithRecur(node, count, level);
 		Arrays.sort(count);
 		return count[count.length-1];
 	}
 	
 	private static void getMaxWithRecur(Node node, int[] count, int level){
 		if(node!=null){
 			count[level]++;
 			getMaxWithRecur(node.left, count, level+1);
 			getMaxWithRecur(node.right, count, level+1);
 		}
 	}
 	
 	private static int getHeight(Node node){
 		if(node==null)
 			return 0;
 		return 1+Math.max(getHeight(node.left), getHeight(node.right));
 	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetTreeWidthByPreOrderTravel inst=new GetTreeWidthByPreOrderTravel();
		/*
        Constructed bunary tree is:
              1
            /  \
           2    3
          / \    \
         4   5    8
                 / \
                6   7 */
		Node root=inst.new Node(1);
 		root.left=inst.new Node(2);
 		root.right=inst.new Node(3);
 		root.left.left=inst.new Node(4);
 		root.left.right=inst.new Node(5);
 		root.right.right=inst.new Node(8);
 		root.right.right.left=inst.new Node(6);
 		root.right.right.right=inst.new Node(7);
  
        System.out.println("Maximum width is " + getMaxWidth(root));
	}

}
