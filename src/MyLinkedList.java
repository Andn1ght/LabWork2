public class MyLinkedList<E> implements MyList<E> {

    public static class Node<E> {
        public E element;
        public Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.prev = previous;
        }

        public Node(E element, Node<E> next) {
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

    private Node<E> head;
    private Node<E> tail;
    private int size;


    @Override
    public int size() {

        Node<E> current = head; //create temporary reference to update

        int count = 0;

        while(current != null) {
            count = count + 1;
            current = current.next; //move it to the next node
        }

        return count;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(E item) {
        addLast(item);
    }

    @Override
    public void add(E item, int index) {

        checkIndex(index);
        if(index == size){
            addLast(item);
        }
        else
            addBefore(item, node(index));
    }

    @Override
    public boolean remove(E item) {

        Node<E> currentNode = head;

        while (currentNode != null && !currentNode.element.equals(item)) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return false;
        }

        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        } else {
            head = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        } else {
            tail = currentNode.prev;
        }

        size--;
        return true;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return unInsert(node(index));
    }

    public E removeFirst(int index) {
        checkIndex(index);
        return unInsertFirst(node(index));
    }

    public E removeLast(int index) {
        checkIndex(index);
        return unInsertLast(node(index));
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) getNode(index).element;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> currentNode = head;
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
        Node<E> currentNode = tail;
        while (currentNode != null && !currentNode.element.equals(o)) {
            currentNode = currentNode.prev;
            index--;
        }
        if (currentNode == null) {
            return -1;
        }
        return index;
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException();
    }

    //Helper methods

    Node<E> node(int index) {

        if(index < (size >> 1)) {
            Node<E> indexFirstHalf = head;
            for (int i = 0; i < index; i++) {
                indexFirstHalf = indexFirstHalf.next;
            }
            return indexFirstHalf;
        }
        else {
            Node<E> indexLastHalf = tail;
            for (int i = size - 1; i > index ; i--) {
                indexLastHalf = indexLastHalf.prev;
            }
            return indexLastHalf;
        }
    }

    private void addBefore(E element, Node<E> such) {
        Node<E> preSuch = such.prev;
        Node<E> newNode = new Node<>(element, such, preSuch);
        such.prev = newNode;
        if (preSuch == null)
            such = newNode;
        else
            preSuch.next = newNode;
        size++;
    }

    private void addLast(E element) {
        Node<E> lastNode = tail;
        Node<E> newNode = new Node<>(element, null, lastNode);
        tail = newNode;
        if (lastNode == null)
            head = newNode;
        else {
            lastNode.next = newNode;
        }
        size++;
    }

    private void addFirst(E element) {
        Node<E> newNode = new Node<>(element, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    private void checkIndex(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        Node<E> temp = head;
        while (temp.next != null) {
            str.append(temp.element + ", ");
            temp = temp.next;
        }
        str.append(temp.element + " ]");
        return str.toString();
    }

    private E unInsert(Node<E> lastNode) {
        E element = lastNode.element;
        Node<E> next = lastNode.next;
        Node<E> prev = lastNode.prev;

        if (prev == null)
            head = next;
        else {
            prev.next = next;
            lastNode.prev = null;
        }

        if (next == null)
            tail = prev;
        else {
            next.prev = prev;
            lastNode.next = null;
        }
        lastNode.element = null;
        size--;
        return element;
    }

    private E unInsertFirst(Node<E> firstNode) {
        E element = firstNode.element;
        Node<E> next = firstNode.next;
        firstNode.element = null;
        firstNode.next = null;
        head = next;
        if (next == null)
            tail = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private E unInsertLast (Node<E> lastNode) {
        E element = lastNode.element;
        Node<E> prev = lastNode.prev;
        lastNode.element = null;
        lastNode.prev = null;
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        size--;
        return element;
    }

}
