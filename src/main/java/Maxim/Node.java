/** 
 * Represents a node in a linked list with an integer value.
 * @autor Максим Есаков
 * @version 1.0
*/
package Maxim;


class Node {
    private int value;
    private Node next;

    /**
     * Constructs a new Node with the specified integer value.
     * @param value the integer value of the node
    */
    Node(int value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Sets the value of the node to the specified integer.
     * @param value the integer value to set
    */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * Returns the integer value of the node.
     * @return the integer value of the node
    */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets the next node that this node points to.
     * @param next the next node in the linked list
    */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Returns the next node that this node points to.
     * @return the next node in the linked list
     */
    public Node getNext() {
        return this.next;
    }
}
