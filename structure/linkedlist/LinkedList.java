package Algorithm.structure.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;

    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);

        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(int k, Object input) {
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;

            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }

        Node temp = head;
        StringBuilder str = new StringBuilder("[");

        while (temp.next != null) {
            str.append(temp.data).append(",");
            temp = temp.next;
        }

        str.append(temp.data);
        return str + "]";
    }

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;

        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if (k == 0)
            return removeFirst();

        Node temp = node(k - 1);
        Node todoDeleted = temp.next;

        temp.next = temp.next.next;

        Object returnData = todoDeleted.data;
        if (todoDeleted == tail) {
            tail = temp;
        }

        todoDeleted = null;
        size--;
        return returnData;
    }

    public int size() {
        return size;
    }

    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    public int indexOf(Object data){
        Node temp = head;
        int index = 0;

        while(temp.data != data){
            temp = temp.next;
            index++;
            if(temp == null) return -1;
        }

        return index;
    }
}
