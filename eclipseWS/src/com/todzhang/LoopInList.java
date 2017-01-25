package me.todzhang;

public class LoopInList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1. -----------test non cyclic list ---------");
		LoopInList list=new LoopInList();
		list.appendToTail(new LoopInList.Node("101"));
		list.appendToTail(new LoopInList.Node("201"));
		list.appendToTail(new LoopInList.Node("301"));
		list.appendToTail(new LoopInList.Node("401"));
		System.out.println(" this list contains loop? ");
		System.out.println(list.isCyclic()?"yes":"no");
		// head->101->201->301->401->null
		System.out.println("2. -----------test list contains loops---------");
		LoopInList list2=new LoopInList();
		list2.appendToTail(new LoopInList.Node("101"));
		LoopInList.Node cycle=new Node("201");
		list2.appendToTail(cycle);
		list2.appendToTail(new LoopInList.Node("301"));
		list2.appendToTail(new LoopInList.Node("401"));
		list2.appendToTail(cycle);
		System.out.println(" this list contains loop? ");
		System.out.println(list2.isCyclic()?"yes":"no");

	}

	private Node head;
	
	public LoopInList(){
		this.head=new Node("head");
	}
	
	public Node head(){
		return head;
	}
	
	public void appendToTail(Node node){
		Node current=head;
		
		// find last element of this list, i.e. tail
		while(current.next()!=null){
			current=current.next();
		}
	
		// appending new node to tail
		current.setNext(node);
	}
	
	public boolean isCyclic(){
		Node hare=head;
		Node tortoise=head;
		
		while(hare!=null&&hare.next!=null){
			hare=hare.next().next();
			tortoise=tortoise.next();
			
			// if fast and slow pointers meet then link list is cyclic
			if(hare==tortoise){
				return true;
			}
		}
		return false;
		
	}
	
		static class Node {
			private Node next;
			private String value;
			
			public Node(String value) {
				super();
				this.value = value;
			}
			
			public String data(){
				return value;
				}
			public void setData(String inValue){
				this.value=inValue;
			}
			
			public Node next(){
				return next;
			}
			
			public void setNext(Node node){
				this.next=node;
			}
			
			@Override
			public String toString(){
				return String.valueOf(this.value);
			}
		}

		
		

}
