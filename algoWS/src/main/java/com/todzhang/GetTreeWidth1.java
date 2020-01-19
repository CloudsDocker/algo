public class GetTreeWidth1{
	 
	 
 	class Node{
 		int value;
 		Node left,right;

 		public Node(int inValue){
 			this.value=inValue;
 		}
 	}

 	public static void main(String[] args){
 		GetTreeWidth1 inst=new GetTreeWidth1();
 		Node root=inst.new Node(1);
 		root.left=inst.new Node(2);
 		root.right=inst.new Node(3);
 		root.left.left=inst.new Node(4);
 		root.left.right=inst.new Node(5);
 		root.right.right=inst.new Node(8);
 		root.right.right.left=inst.new Node(6);
 		root.right.right.right=inst.new Node(7);

 		System.out.println(" ==== the max width ===");
 	}
 }