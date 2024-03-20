/** 
 * Represents a container that holds a linked list of integer values.
 * @autor Максим Есаков
 * @version 1.0
*/
package Maxim;

public class Container {
    Node head;
    int size;

    /**
     * Constructs an empty Container
     */
    Container() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructs a Container by copying another Container
     * @param container - the Container to copy
     */
    Container(Container container)
    {
        this.head = container.getHead();
        this.size = container.getSize();
    }

    /**
     * Returns the head node of the list.
     * @return the head node of the list
     */
    private Node getHead() {
        return this.head;
    }

    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Appends the specified element to the end of this list
     * @param value - value to be appended to this list
     */
    public void add(int value) {
        Node new_node = new Node(value);
        this.size++;

        if (this.head == null) {
            this.head = new_node;
        } 
        else 
        {
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(new_node);
        }
    }

    /**
     * Inserts the specified element at the specified position in this list
     * @param index - index at which the specified element is to be inserted
     * @param value - value to be inserted
     * @return true if the value is inserted
     */
    public boolean add(int index, int value) {
        if (this.isIndexOutOfBounds(index)) 
            throw new IndexOutOfBoundsException();
        else
        {
            Node new_node = new Node(value);
            Node current_node = this.getHead();
            if (index == 0) {
                this.head = new_node;
            } else {
                Node prev_node = this.getNode(index-1);
                current_node = prev_node.getNext();
                prev_node.setNext(new_node); 
            }
            new_node.setNext(current_node);
            size++;
            return true;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     * @param index - index of the element to replace
     * @param value - value to be stored at the specified position
     * @return the element previously at the specified position
     */
    public int set(int index, int value)
    {
        int prev_value = 0;
        if (this.isIndexOutOfBounds(index)) 
            throw new IndexOutOfBoundsException();
        else
        {
            Node node = this.getNode(index);
            prev_value = node.getValue();
            node.setValue(value);
        }   
        return prev_value;     
    }

    /**
     * Returns the element at the specified position in this list
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        if (isIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        return this.getNode(index).getValue();
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left
     * @param index - the index of the element to be removed
     * @return - the element that was removed from the list
     */
    public int remove(int index) {
        int value;
        if (this.isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node current_node = this.getHead();
            if (index == 0) {
                this.head = size > 1 ? this.head.getNext() : null;
            } else {
                Node prev_node = this.getNode(index-1);
                current_node = prev_node.getNext();
                prev_node.setNext(current_node.getNext()); 
            }
            size--;
            value = current_node.getValue();
        }
        return value;
    }

    /**
     * Returns the element at the last position in this list
     * @return the element at the last position in this list
     */
    public int pop() {
        return this.remove(size-1);
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns
     */
    public void clear() {
        if (!this.isEmpty())
        {
            Node current = this.getHead();
            while (current != null) {
                Node next = current.getNext();
                current.setNext(null);
                current = next;
            }
            this.head = null;
            this.size = 0;
        }
    }

    /**
     * Returns true if this list contains the specified element
     * @param value - value whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(int value) {
        return this.indexOf(value) == -1 ? false : true;
    }

    /**
     * Returns a copy of this list instance
     * @return a copy of this list instance
     */
    public Container clone() {
        Container сontainer = new Container();
        Node current = this.head;
        while (current != null) {
            сontainer.add(current.getValue());
            current = current.getNext();
        }
        return сontainer;
    }

    /**
     * Compares the specified container with this list for equality
     * @param container - the container to be compared for equality with this list
     * @return true if the specified container is equal to this list
     */
    public boolean equals(Container container)
    {
        boolean is_equal = this.getSize() == container.getSize();
        if (is_equal)
        {
            Node first_node = this.getHead();
            Node second_node = container.getHead();

            while (first_node != null && second_node != null && is_equal)
            {
                if (first_node.getValue() != second_node.getValue())
                    is_equal = false;
                first_node = first_node.getNext();
                second_node = second_node.getNext();
            }
        } 
        return is_equal;
    }


    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     * @param value - value to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf(int value)
    {
        int index = -1;
        if (!this.isEmpty())
        {
            Node current_node = this.getHead();
            int current_index = 0;
            while (current_node != null && current_node.getValue() != value)
            {
                current_index++;
                current_node = current_node.getNext();
            }
            if (current_node != null && current_node.getValue() == value)
                index = current_index;
        }
        return index;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     * @param value - value to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(int value)
    {
        int index = -1;
        if (!this.isEmpty())
        {
            Node current_node = this.getHead();
            int current_index = 0;
            while (current_node != null)
            {
                if (current_node.getValue() == value)
                    index = current_index;
                current_index++;
                current_node = current_node.getNext();
            }
        }
        return index;
    }

    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean  isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the node at the specified index in the linked list.
     * @param index - index of the node to return
     * @return the node at the specified index, or null if the index is out of bounds
     */
    private Node getNode(int index)
    {
        Node node = null;
        int current_index = 0;
        if (!this.isIndexOutOfBounds(index))
        {
            node = this.getHead();
            while (current_index != index) 
            {
                current_index++;
                node = node.getNext();
            }
        }
        return node;
    }

    /**
     * Checks if the specified index is out of bounds for the linked list.
     * @param index - index to be checked
     * @return true if the index is out of bounds, false otherwise 
     */
    private boolean isIndexOutOfBounds(int index) {
        return this.getHead() == null || index >= this.getSize() || index < 0;
    }

    /**
     * Returns a string representation of this list
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        String string = "";
        if (this.head != null) {
            Node current_node = this.getHead();
            string += String.format("%s ", current_node.getValue());
            while (current_node.getNext() != null)
            {
                current_node = current_node.getNext();
                string += String.format("%s ", current_node.getValue());
            }
        }
        return string;
    }
}
