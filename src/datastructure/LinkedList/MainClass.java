package datastructure.LinkedList;

public class MainClass {
    public static void main(String args[]) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.displayList();
    }
}
