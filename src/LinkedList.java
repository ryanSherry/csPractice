public class LinkedList<T> {

    private Node head;
    private Node tail;
    private Node previousTail;
    private int itemCount;

    static class Node<T> {
        T data;
        Node next;

        Node(T item, Node<T> next) {
            this.data = item;
            this.next = next;
        }
    }

    public void addHead(T item) {

        Node<T> itemToAdd = new Node<>(item, null);

        if (head == null) {
            head = itemToAdd;
            tail = itemToAdd;
            itemCount++;
        } else {
            Node tmp = head;
            itemToAdd.next = tmp;
            head = itemToAdd;
            itemCount++;
        }
    }

    public void addTail(T item) {

        Node<T> itemToAdd = new Node<>(item, null);

        if (head == null) {
            head = itemToAdd;
            tail = itemToAdd;
            itemCount++;
        } else {
            Node tmp = tail;
            tmp.next = itemToAdd;

            if (itemCount > 1) {
                previousTail = tail;
            }

            tail = tmp.next;
            itemCount++;
        }
    }

    public Node popHead() {
        Node itemToPop;
        if (head == null) {
            System.out.println("No head to pop");
            itemToPop = null;
        } else if (head.equals(tail)) {
            itemToPop = head;
            head = null;
            tail = null;
            itemCount--;
            System.out.println(itemToPop.data);
        } else {
            itemToPop = head;
            head = head.next;
            itemCount--;
            System.out.println(itemToPop.data);
        }
        return itemToPop;
    }

    public Node popTail() {
        Node itemToPop;
        if (head == null) {
            System.out.println("No head to pop");
            itemToPop = null;
        } else if (head.equals(tail)) {
            itemToPop = tail;
            head = null;
            tail = null;
            itemCount--;

            System.out.println(itemToPop.data);
        } else {
            itemToPop = tail;
            tail = previousTail;
            itemCount--;

            System.out.println(itemToPop.data);
        }
        return itemToPop;
    }

    public void printLinkedList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data + ",");
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addHead(1);
        linkedList.addHead(2);
        linkedList.addHead(3);
    }
}
