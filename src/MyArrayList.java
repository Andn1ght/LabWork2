public class MyArrayList<T> implements MyList<T>{
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        } else {
            list = (T[]) new Object[capacity];
            size = 0;
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {

        for (int i = 0; i < size; i++) {

            if (list[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    private boolean isFull() {
        if(size == list.length)
            return true;
        else
            return false;
    }

    public void add(T item) {
        add(item, size);
    }

    public void add(T item, int index) {

        checkIndex(index);

        if (isFull()) {
            increaseBuffer();
        }

        for (int i = size - 1; i >= index; i--) {
            list[i+1] = list[i];
        }

        list[index] = item;
        size++;
    }

    public void increaseBuffer(){

        T[] newArr = (T[]) new Object[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            newArr[i] = (T) list[i];
        }

        list = newArr;
    }

    public boolean remove(T item) {

        for (int i = 0; i < size; i++) {

            if (list[i].equals(item)) {

                remove(i);

                return true;
            }
        }
        return false;
    }

    public T remove(int index) {

        checkIndex(index);

        T removedItem = (T) list[index];

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        size--;
        list[size] = null;

        return removedItem;
    }

    private void checkIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void clear() {
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) list[index];
    }

    public int indexOf(Object o) {

        for (int i = 0; i < size; i++) {

            if (list[i].equals(o)) {

                return i;
            }

        }

        return -1;
    }

    public int lastIndexOf(Object o) {

        for (int i = size - 1; i >= 0; i--) {

            if (list[i].equals(o)) {
                return i;
            }

        }
        return -1;
    }

    public void sort() {
        bubbleSort(this.list);
    }

    private void bubbleSort(T[] arr) {
        boolean sorted = false;
        int length = arr.length;
        T temp;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < length - 1; i++) {
                if (((Comparable<T>) arr[i]).compareTo(arr[i + 1]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
            length--;
        }
    }
}
