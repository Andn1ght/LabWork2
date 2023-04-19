import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {

    public class Node {
        public E element;
        public Node next;
        private Node previous;

        public Node(E element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public Node() {
            this.element = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    @Override
    public int size() {
        Node current = head; //create temporary reference to update
        int count = 0;
        while(current != null) {
            count = count + 1;
            current = current.next; //move it to the next node
        }
        return count;
    }

    private boolean isEmpty() {
        return head == null; //if head is null, return true, else return false
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(E item) {
        Node newNode = new Node(item, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(item);
            return;
        }
        Node currentNode = getNode(index);
        Node newNode = new Node(item, currentNode, currentNode.previous);
        currentNode.previous.next = newNode;
        currentNode.previous = newNode;
        size++;
    }

    private Node getNode(int index) {
        Node currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode;
    }

    @Override
    public boolean remove(E item) {
        Node currentNode = head;
        while (currentNode != null && !currentNode.element.equals(item)) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            return false;
        }
        if (currentNode.previous != null) {
            currentNode.previous.next = currentNode.next;
        } else {
            head = currentNode.next;
        }
        if (currentNode.next != null) {
            currentNode.next.previous = currentNode.previous;
        } else {
            tail = currentNode.previous;
        }
        size--;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = getNode(index);
        if (currentNode.previous != null) {
            currentNode.previous.next = currentNode.next;
        } else {
            head = currentNode.next;
        }
        if (currentNode.next != null) {
            currentNode.next.previous = currentNode.previous;
        } else {
            tail = currentNode.previous;
        }
        size--;
        return currentNode.element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).element;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node currentNode = head;
        while (currentNode != null && !currentNode.element.equals(o)) {
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == null) {
            return -1;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        Node currentNode = tail;
        while (currentNode != null && !currentNode.element.equals(o)) {
            currentNode = currentNode.previous;
            index--;
        }
        if (currentNode == null) {
            return -1;
        }
        return index;
    }

    @Override
    public void sort() {

    }
}
