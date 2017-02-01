/**
 * Created by todzhang on 2017/2/1.
 *
 * A basic doubly linked list implementation
 */
public class DoublyLinkedList<E> {

    // ------ nested Node class --------
    private static class Node<E>{
        private E element;          // reference to the element stored at this node
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            this.element=e;
            prev=p;
            next=n;
        }

        public E getElement(){return element;}
        public Node<E> getPrev(){return prev;}
        public Node<E> getNext(){return next;}
        public void setPrev(Node<E> p){prev=p;}
        public void setNext(Node<E> n){next=n;}
    }
    // ------- end of nested Node class----------

    // instance variables of the DoublyLinkedList
    private Node<E> header;                         // header sentinel
    private Node<E> trailer;                        // trailer sentinel
    private int size=0;

    /** Construct a new empty list*/
    public DoublyLinkedList(){
        header=new Node<E>(null,null,null);
        trailer=new Node<E>(null,header,null);      // trailer is prcededed by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    public int size(){return size;}

    public boolean isEmpty(){return size==0;}

    /**
     * Returns (but does not remove) the first element of the list
     */
    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();       // first element is beyond header
    }

    /**
     * return (but does not remove) the last element of the list
     */
    public E last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();      // last element is before trailer
    }

    // private update methods
    // adds elements e to the linked list in between the given nodes
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        // cread and link a new node
        Node<E> newest=new Node<E>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    // remove the given node from the list and returns its element
    private E remove(Node<E> node){
        Node<E> predecessor=node.getPrev();
        Node<E> successor=node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return  node.getElement();
    }
    // public update methods
    // add elements e to the front of the list
    // due to header sentinel, so we can share universal same addBetween
    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }

    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}
