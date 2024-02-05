package datastructure.LinkedList;

public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size = size + 1;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size = size + 1;
    }

    public void insertNodeIndex(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        } else if (index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size = size + 1;

    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        //if list contains single element then head.next value is null and tail also becomes null
        if (head == null) {
            tail = null;
        }
        size = size - 1;
        return value;
    }

    public int deleteLast() {
        if (size<=1) {
            return deleteFirst();
        }
        int value = tail.value;
        Node secondLastNode = get(size - 2);
        tail = secondLastNode;
        tail.next = null;
        size = size - 1;
        return value;

    }

    //To get the secondLast node
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
