package Maxim;

public class Container {
    Node head;
    int size;

    Container() {
        this.head = null;
        this.size = 0;
    }

    Container(Container container)
    {
        this.head = container.getHead();
        this.size = container.getSize();
    }

    private Node getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

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

    public boolean add(int index, int value) {
        if (this.head == null || index < 0 || index > this.getSize()) 
            throw new IndexOutOfBoundsException();
        else
        {
            Node new_node = new Node(value);
            Node current_node = this.getHead();
            Node prev_node = null;
            int current_index = 0;
            while (current_index != index && current_node != null) {
                current_index++;
                prev_node = current_node;
                current_node = current_node.getNext();
            }
            if (prev_node == null)
                this.head = new_node;
            else
                prev_node.setNext(new_node);
            new_node.setNext(current_node);
            size++;
            return true;
        }
    }

    public int set(int index, int value)
    {
        int prev_value = 0;
        if (this.head == null || index < 0 || index > this.getSize()) 
            throw new IndexOutOfBoundsException();
        else
        {
            Node current_node = this.getHead();
            int current_index = 0;
            while (current_index != index && current_node != null) {
                current_index++;
                current_node = current_node.getNext();
            }
            prev_value = current_node.getValue();
            current_node.setValue(value);
        }   
        return prev_value;     
    }

    public int remove(int index) {
        int value;
        if (this.getHead() == null || index > this.getSize() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node current_node = this.getHead();
            Node prev_node = null;
            int current_index = 0;
            while (current_index != index && current_node != null) {
                current_index++;
                prev_node = current_node;
                current_node = current_node.getNext();
            }
            if (prev_node == null)
                this.head = this.head.getNext();
            else
                prev_node.setNext(current_node.getNext());
            size--;
            value = current_node.getValue();
        }
        return value;
    }

    public void clear() {
        if (this.getHead() != null && this.getSize() > 0)
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

    public boolean contains(int value) {
        boolean is_contain = false;
        if (this.getHead() != null && this.getSize() > 0)
        {
            Node current = this.getHead();
            while (current != null && current.getValue() != value)
                current = current.getNext();
            if (current != null)
                is_contain = current.getValue() == value;
        }
        return is_contain;
    }

    public Container clone() {
        Container сontainer = new Container();
        Node current = this.head;
        while (current != null) {
            сontainer.add(current.getValue());
            current = current.getNext();
        }
        return сontainer;
    }

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

    public int get(int index) {
        int value = 0;
        if (this.getHead() == null || index > this.getSize() || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            Node current_node = this.getHead();
            int current_index = 0;
            while (current_index != index && current_node != null) {
                current_index++;
                current_node = current_node.getNext();
            }
            if (current_index == index)
                value = current_node.getValue();
        }
        return value;
    }

    public int indexOf(int value)
    {
        int index = -1;
        if (this.getHead() != null && this.getSize() > 0)
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

    public int lastIndexOf(int value)
    {
        int index = -1;
        if (this.getHead() != null && this.getSize() > 0)
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

    public boolean  isEmpty() {
        return this.size == 0;
    }

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
