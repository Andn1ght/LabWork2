public class MyArrayList<T> implements MyList<T>{
    private Object[] list;
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

    public void add(T item) {
        add(item, size);
    }

    public void add(T item, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == list.length) {
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


}
