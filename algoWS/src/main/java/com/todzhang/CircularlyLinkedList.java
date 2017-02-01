/**
 * Created by todzhang on 2017/2/1.
 */
public class CircularlyLinkedList<E> {
    //nested node class
    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element=e;
            next=n;
        }
        public E getElement(){return element;}
        public Node<E> getNext(){return next;}
        public void setNext(Node<E> n){next=n;}
    }

    // instance variables of the CircularylyLinkedList
    private Node<E> tail=null; // we store tail, but not head
    private int size=0;         // number of nodes in the list
    public CircularlyLinkedList(){} // constructs an initially empty list

    //access methods
    public int size(){return size;}
    public boolean isEmpty(){return size==0;}
    public E first(){
        if(isEmpty()) return null;
        return tail.getNext().getElement();  // the head is *after* the tail
    }

    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    public void rotate(){
        // rotate the first element to the back of the list
        if(tail!=null){
            tail=tail.getNext();
        }
    }

    public void addFirst(E e){
        if(size()==0){
            tail=new Node<>(e,null);
            tail.setNext(tail);                 // link to itself circularly
        }
        else{
            Node<E> newest=new Node<E>(e,tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e){
        addFirst(e);            //adds element e to the end of the list, insert new element at front of list
        tail=tail.getNext();    // now new element becomes the tail
    }

    public E removeFirst(){
        if(isEmpty()) return null;  // nothing to remove
        Node<E> head=tail.getNext();
        if(head==tail) tail=null;    // must be the only node left
        else tail.setNext(head.getNext()); // remove "head" from the list
        size--;
        return head.getElement();

    }
}
