import java.lang.reflect.Array;

public class ArrayDeque<T> {
    private Object[] array;
    int headIndex;
    int tailIndex;

    public ArrayDeque() {
        array = new Object[16];
        headIndex = 0;
        tailIndex = array.length - 1;
    }

    public void addAtHeadIndex(T item) {
        checkArrayForResize(array);
        array[headIndex] = item;
        headIndex++;
    }

    public Object popAtHeadIndex() {
        Object itemToPop = array[headIndex];
        array[headIndex] = null;
        headIndex--;
        checkArrayForResize(array);
        return itemToPop;
    }

    public void addHead(T item) {
        checkArrayForResize(array);
        bumpUpArrayHead(array, item);
        headIndex++;
    }

    public Object popHead() {
        Object itemToPop = array[0];
        bumpDownArrayHead(array);
        return itemToPop;
    }

    public void addTail(T item) {
        checkArrayForResize(array);
        bumpUpArrayTail(array, item);
        tailIndex--;
    }

    public Object popTail() {
        Object itemToPop = array[array.length - 1];
        bumpDownArrayTail(array);
        tailIndex++;
        return itemToPop;
    }

    public void addAtTailIndex(T item) {
        checkArrayForResize(array);
        array[tailIndex] = item;
        tailIndex--;
    }

    public Object peakFirst() {
        return array[0];
    }

    public Object peakLast() {
        return array[array.length - 1];
    }

    public void checkArrayForResize(Object[] a) {
        int tailIndexDiff = array.length - 1 - tailIndex;
        int indexSum = tailIndexDiff + headIndex;
        resizeArray(indexSum);
    }

    private void resizeArray(int indexSum) {
        int newSize = 0;
        Object[] arrayTemp = new Object[0];

        if (indexSum == array.length) {
            System.out.println("ArrayDeque is full, resizing");
            newSize = 2 * array.length;
            arrayTemp = new Object[newSize];
        } else if (indexSum == array.length/4) {
            System.out.println("ArrayDeque can be reduced, resizing");
            newSize = array.length / 2;
            arrayTemp = new Object[newSize];
        }
        if(arrayTemp.length != 0) {
            copyArray(arrayTemp);
        }
    }

    private void copyArray(Object[] arrayTemp) {
        for (int i = 0; i < headIndex; i++) {
            arrayTemp[i] = array[i];
        }

        for (int i = tailIndex; i < array.length; i++) {
            arrayTemp[i] = array[i];
        }
        array = arrayTemp;
    }

    private void bumpUpArrayHead(Object[] a, T item) {

        Object[] tempArray = new Object[a.length+1];
        tempArray[0] = item;
        for(int i = 0; i < a.length; i++) {
            tempArray[i+1] = a[i];
        }
        headIndex++;
        array = tempArray;
    }

    private void bumpDownArrayHead(Object[] a) {
        Object[] tempArray = new Object[a.length];
        for(int i = 0; i < a.length - 1; i++) {
            tempArray[i] = a[i+1];
        }
        array = tempArray;
    }

    private void bumpUpArrayTail(Object[] a, T item) {
        Object[] tempArray = new Object[a.length];
        tempArray[tempArray.length-1] = item;
        for(int i = 0; i < headIndex; i++) {
            tempArray[i] = a[i];
        }
        for(int i = tailIndex; i < a.length - 1; i++) {
            tempArray[i] = a[i+1];
        }
        tailIndex--;
        array = tempArray;
    }

    private void bumpDownArrayTail(Object[] a) {
        Object[] tempArray = new Object[a.length];
        for(int i = 0; i < headIndex; i++) {
            tempArray[i] = a[i];
        }

        for(int tailCounter = tailIndex; tailCounter < a.length - 1; tailCounter++) {
            tempArray[tailCounter] = a[tailCounter];
        }

        array = tempArray;
    }

    public void printItemsIfPrintable() {
        for (Object item : array) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addHead(0);
        arrayDeque.addHead(1);
        arrayDeque.addTail(99);
        arrayDeque.addTail(50);
        arrayDeque.addTail(60);
        arrayDeque.addTail(61);
        arrayDeque.addTail(62);
        arrayDeque.addTail(63);
        arrayDeque.addTail(64);
        arrayDeque.addTail(65);
        arrayDeque.addTail(66);
        arrayDeque.addTail(67);
        arrayDeque.addTail(68);
        arrayDeque.addTail(69);

        arrayDeque.printItemsIfPrintable();
    }

}


