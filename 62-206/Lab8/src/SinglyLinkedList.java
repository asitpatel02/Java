public class SinglyLinkedList<E> {
    protected Node<E> start;

    protected int size;
    public SinglyLinkedList(){
        start = null;
        size = 0;
    }
    //insertAtLast
    public void add(E data){
        insertAtLast(data);
    }
    public void insertAtLast(E data){
        if(size==0){
            start = new Node<E>();
            start.next = null;
            start.element = data;
        }
        else{
            Node<E> currentNode = getNodeAt(size-1);
            Node<E> newNode = new Node<E>();
            newNode.element = data;
            newNode.next = null;
            currentNode.next = newNode;   }
        size++;
    }

    public void insertAtFirst(E data){
        if(size==0){
            start = new Node<E>();
            start.next = null;
            start.element = data;   }
        else{
            Node<E> newNode = new Node<E>();
            newNode.element = data;
            newNode.next = start;
            start = newNode;   }
        size++;  }

    public Node<E> getNodeAt(int nodePos) throws ArrayIndexOutOfBoundsException{
        if(nodePos>=size || nodePos<0){    throw new ArrayIndexOutOfBoundsException();   }
        Node<E> temp = start; //Move pointer to front   int counter = 0;
        for(int counter = 0;counter<nodePos;counter++){
            temp = temp.next;   }   return temp;
    }

    public void insertAt(int position, E data){ //  0 <= position <= size - 1
        if(position == 0){
            insertAtFirst(data);   }
        else if(position==size-1){
            insertAtLast(data);   }
        else{

            // put your work here

            Node<E> newNode = new Node<E>();
            newNode.element = data;
            Node<E> prevNode = getNodeAt(position - 1);
            Node<E> nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.next = nextNode;
            ++size;
        }
    }


    public Node<E> getFirst(){
        if (size == 0)
            return null;
        return getNodeAt(0);  }

    public Node<E> getLast(){
        if (size == 0) return null;
        return getNodeAt(size-1);  }

    public E removeAtFirst(){
        if(size==0){
            return null;  }
        E data = start.element;
        start = start.next;
        size--;
        return data;  }

    public E removeAtLast(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException();   }
        if (size == 1) {
            E temp = start.element;
            start = null;
            size--;
            return temp;
        }


        //  put your work here


        Node<E> temp = getNodeAt(size-2); // get Second last node
        E data = temp.next.element;
        temp.next = null; // delete last node
        size--; // decrease size
        return data;
    }


    public E removeAt(int position){
        if(position==0){    return removeAtFirst();   }
        else if(position == size-1){    return removeAtLast();   }
        else{
            Node<E> tempNode = getNodeAt(position-1);
            E data = tempNode.next.element;
            tempNode.next = tempNode.next.next;
            size--;
            return data;   }  }

    public int size(){   return size;  }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> SLL = new SinglyLinkedList<Integer>();
        for (int i = 0; i <= 10; i++) {
            SLL.add(i);
            SLL.removeAtLast();
        }
        System.out.println("The Size of List is:  " + SLL.size());
    }


}


class Node<E> {
    // Instance variables:
    public E element;
    public Node<E> next;
    /** Creates a node with null references to its element and next node. */
    public Node() {
        this(null, null);
    }
    /** Creates a node with the given element and next node. */
    public Node(E e, Node<E> n) {
        element = e;
        next = n;
    }
    // Accessor methods:
    public E getElement() {
        return element;
    }
    public Node<E> getNext() {
        return next;
    }
    // Modifier methods:
    public void setElement(E newElem) {
        element = newElem;
    }
    public void setNext(Node<E> newNext) {
        next = newNext;
    }
}
