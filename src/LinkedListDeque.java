public class LinkedListDeque<T> {
    private LinkedList<T> linkedList;

    public LinkedListDeque() {
        this.linkedList = new LinkedList<>();
    }

    public void addAtHead(T item) {
        linkedList.addHead(item);
    }

    public void addAtTail(T item) {
        linkedList.addTail(item);
    }

    public Object popHead() {
        LinkedList.Node node = linkedList.popHead();
        return node.getData();
    }

    public Object popTail() {
        LinkedList.Node node = linkedList.popTail();
        return node.getData();
    }

    public void printDeque() {
        linkedList.printLinkedList();
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
        linkedListDeque.addAtHead(1);
        linkedListDeque.addAtHead(2);
        linkedListDeque.addAtHead(3);
        linkedListDeque.printDeque();
        linkedListDeque.popTail();
        linkedListDeque.printDeque();
    }
}
