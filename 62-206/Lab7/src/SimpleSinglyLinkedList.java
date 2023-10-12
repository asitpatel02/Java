import java.util.Scanner;

/*
A node class is a generic class that comprises fields such as next, which is a reference to the next Node element, and data,
 which is the data for that object. It'll be utilised to keep track of the values.
 */
////////////////////////////////////////////////////////////////////////// Elem
// Simple class to hold data are sometimes defined with public fields.
// This practice isn't good, but was done here for simplicity.
class Node <E> {
    public Node <E> next;    // Link to next element in the list.
    public E data;  // Reference to the data.
}

public class SimpleSinglyLinkedList <E> {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        The type Node's front and back pointers are defined to point to the linked list's front and back nodes, respectively.
        It has been specified as a String type, which means it will point to and contain data of the String type.
        */
        Node <String> front = null;    // First element of list.
        Node <String>  back  = null;    // Last element of list.

        //... Read a list of words.
        System.out.println("please enter a list of words:");
        /*
        The new Node object with String type is generated first in the loop, and then it is tested if this is the first node by checking where the front is pointing.
         If this is the case, the newly formed Node object is allocated to the front. The newly generated object also has back and forth assigned to it.
         */
        while (in.hasNext()) {
            String word = in.next();

            Node <String> e = new Node <String>();     // Create a new list element.
            e.data = word;           // Set the data field.

            //... Two cases must be handled differently
            if (front == null) {
                //... When the list is empty, we have to set the front pointer.
                front = e;            // Back element will be set below.
            } else {
                /*
                If the front is not null, the first existing back node now points to the newly generated node, and back is then transferred to the newly produced object e.
                 */
                //... When we already have elements, we need to link to it.
                back.next = e;       // Link last elem to new element.
            }
            back = e;                // Update back to link to new element.
        }

        //... While loop to print list in forward order.
        System.out.println("*** Print words in order of entry");
        Node<String> curr = front;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }

        System.out.println("*** Print words in order of entry");
        for (Node<String> e = front; e != null; e = e.next) {
            System.out.println(e.data);
        }


    }
}
/*
this program make singal linked list and print whaterver in linedlist
 */