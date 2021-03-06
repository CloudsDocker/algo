/**
 * This is sample class from https://www.youtube.com/watch?v=M6lYob8STMI
 * @author todzhang
 *
 */
public class TreeBinaryTreeTester<E extends Integer> {

	Node<E> root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeBinaryTreeTester<Integer> inst=new TreeBinaryTreeTester<>();
		inst.addNode(50, "Boss");
		inst.addNode(40, "VP");
		inst.addNode(30, "Team Leader");
		inst.addNode(20, "Developer");
		inst.addNode(60, "Scientist");
		inst.addNode(70, "Board");
		inst.addNode(80, "PE");
		inst.addNode(90, "CEO");
		
		inst.inOrderTraverse(inst.root);
		System.out.println("find result: "+ inst.find(30));

	}

	public void addNode_Default(E key,String name){
		Node<E> newNode=new Node<E>(key, name);
		if(root==null){
			root=newNode;
		}
		else{
			Node<E> focusNode=root;
			Node<E> parent;
			while(true){
				parent=focusNode;
				if(key<focusNode.key){
					focusNode=focusNode.leftChild;
					if(focusNode==null){
						parent.leftChild=newNode;
						return;
					}
				}
				else {
					focusNode=focusNode.rightChild;
					if(focusNode==null){
						parent.rightChild=newNode;
						return;
					}
				}
			}
		}
	}
	
	public void addNode(E key,String name){
		Node<E> newNode=new Node<E>(key, name);
		if(root==null){
			root=newNode;
		}
		else{
			Node<E> focusNode=root;
			while(true){
				if(key<focusNode.key){
					if(focusNode.leftChild==null){
						focusNode.leftChild=newNode;
						return;
					}
					else{
						focusNode=focusNode.leftChild;
					}
				}
				else {
					if(focusNode.rightChild==null){
						focusNode.rightChild=newNode;
						return;
					}
					else{
						focusNode=focusNode.rightChild;
					}
				}
			}
		}
	}
	
	// inOrderTraverse will print binaryTree in assending order
	public void inOrderTraverse(Node<E> node){
		if(node!=null){
			inOrderTraverse(node.leftChild);
			System.out.println(node);
			inOrderTraverse(node.rightChild);
		}
	}
	
	public Node<E> find(E findKey){
		Node<E> focusNode=root;
		while(focusNode.key!=findKey){

			if( focusNode.key > findKey){
				focusNode=focusNode.leftChild;
			}
			else{
				focusNode=focusNode.rightChild;
			}
			if(focusNode==null)
				return null;
		}
		
		return focusNode;
	}

	
	public class Node<E>{
		E key;
		String name;
		public Node(E inKey,String inName){
			this.key=inKey;
			this.name=inName;
		}
		
		Node<E> leftChild;
		Node<E> rightChild;
		public String toString(){
			return name+ " has " + key;
		}
	}
}
