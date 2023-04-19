# LabWork2 🚀

## Laboratory work for assignment 2 in AITU. The program is about two lists - `MyArrayList` and `MyLinkedList`. It implemented by `MyList` interface:🎯
```java
public interface MyList<T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
```
# 🎉 **Solution**:
## `MyArrayList` class [module src](https://github.com/Andn1ght/LabWork2/blob/master/src/MyArrayList.java):
### `size` method 📈:
```java
public int size() {
        return size;
    }
```
### `contains` method 📈:
```java
public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
```
### `add` method 📈:
```java
public void add(T item) {
        if (isFull()) {
            increaseBuffer();
        }
        list[size++] = item;
    }
```
### `add` method 📈:
```java
public void add(T item, int index) {
        checkIndex(index);
        if (isFull()) {
            increaseBuffer();
        }
        for (int i = size - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = item;
        size++;
    }
```
### `remove` method 📈:
```java
public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }
```
### `remove` method 📈:
```java
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
```
### `clear` method 📈:
```java
public void clear() {
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
```
### `get` method 📈:
```java
public T get(int index) {
        checkIndex(index);
        return (T) list[index];
    }
```
### `indexOf` method 📈:
```java
public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
```
### `lastIndexOf` method 📈:
```java
public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
```
### `sort` method 📈:
```java
public void sort() {
        Arrays.sort(list, 0, size);
    }
```
### `toString` method 📈:
```java
public String toString() {

        if(size == 0) {
            return "[]";
        }

        String result = "[";

        for(int i=0; i < size; i++) {
            result = result + list[i] + ", ";
        }

        result = result.substring(0,result.length()-2);

        result = result + "]";

        return result;
    }
```
### `increaseBuffer` method 📈:
```java
private void increaseBuffer(){

        T[] newArr = (T[]) new Object[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            newArr[i] = (T) list[i]; 
        }

        list = newArr; 
    }
```
### `checkIndex` method 📈:
```java
private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
```
### `isFull` method 📈:
```java
private boolean isFull() {
        if(size == list.length)
            return true;
        else
            return false;
    }
```

## `MyLinkedList` class [module src](https://github.com/Andn1ght/LabWork2/blob/master/src/MyLinkedList.java):
### `size` method 📈:
```java
public int size() {
        Node<E> current = head; 
        int count = 0; 
        while (current != null) { 
            count++;
            current = current.next; 
        }
        return count; 
    }
```
### `contains` method 📈:
```java
public boolean contains(Object o) {
        return indexOf(o) != -1; 
    }
```
### `add` method 📈:
```java
public void add(E item) {
        addLast(item);
    }
```
### `add` method 📈:
```java
public void add(E item, int index) {
        checkIndex(index); 
        if (index == size) { 
            addLast(item); 
        } else {
            addBefore(item, node(index)); 
        }
    }
```
### `remove` method 📈:
```java
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
```
### `remove` method 📈:
```java
 public E remove(int index) {
        checkIndex(index); 
        return unInsert(node(index));
    }
```
### `clear` method 📈:
```java
public void clear() {
        head = null; 
        tail = null; 
        size = 0; 
    }
```
### `get` method 📈:
```java
public E get(int index) {
        checkIndex(index);
        return (E) getNode(index).element;
    }
```
### `indexOf` method 📈:
```java
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
```
### `lastIndexOf` method 📈:
```java
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
```
### `sort` method 📈:
```java
public void sort() {
        throw new UnsupportedOperationException();
    }
```
### `node` method 📈:
```java
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
```
### `addBefore` method 📈:
```java
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
```
### `addLast` method 📈:
```java
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
```
### `getNode` method 📈:
```java
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
```
### `checkIndex` method 📈:
```java
private void checkIndex(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
```
### `toString` method 📈:
```java
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
```
### `unInsert` method 📈:
```java
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
```


