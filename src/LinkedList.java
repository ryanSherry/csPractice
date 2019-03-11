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

        public T getData() {
            return this.data;
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
            previousTail = head;
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
            itemCount++;

            if (itemCount > 1) {
                previousTail = tmp;
            }

            tail = tmp.next;
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

            if (itemCount < 2) {
                previousTail = null;
            }

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
            tail.next = null;
            itemCount--;

            if (itemCount < 2) {
                previousTail = null;
            }

            System.out.println(itemToPop.data);
        }
        return itemToPop;
    }

    public Node retrieveHead() {
        return head;
    }

    public void printLinkedList() {
        Node tmp = head;
        String separator = ", ";
        while (tmp != null) {

            if (tmp.equals(tail)) {
                separator = "";
            }

            System.out.print(tmp.data + separator);
            tmp = tmp.next;
        }
        System.out.println(" ");
    }

    private void printNode(Node node) {
        if (node == null) {
            System.out.println("This node is null, can't print data");
        } else {
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addHead(1);
        linkedList.addHead(2);
        linkedList.addHead(3);
        linkedList.printLinkedList();
        linkedList.addTail(5);
        linkedList.addTail(6);
        linkedList.addTail(7);
        linkedList.printLinkedList();
        System.out.println(linkedList.itemCount);
        linkedList.popHead();
        linkedList.popHead();
        linkedList.popHead();
        linkedList.printLinkedList();
        System.out.println(linkedList.itemCount);
        linkedList.popHead();
        linkedList.popHead();
        linkedList.popHead();
        linkedList.printLinkedList();
        linkedList.popHead();
        System.out.println(linkedList.itemCount);
        linkedList.printNode(linkedList.previousTail);
        linkedList.addTail(10);
        linkedList.printNode(linkedList.head);
        linkedList.printNode(linkedList.tail);
        linkedList.printNode(linkedList.previousTail);
        linkedList.addTail(11);
        linkedList.printNode(linkedList.tail);
        linkedList.printNode(linkedList.previousTail);
        linkedList.addTail(12);
        linkedList.printNode(linkedList.tail);
        linkedList.printNode(linkedList.previousTail);
        linkedList.printLinkedList();
        linkedList.popTail();
        linkedList.printNode(linkedList.previousTail);
    }
}
