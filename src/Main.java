public class Main {
    public static void main(String[] args) {

        // Test MyArrayList
        MyList<Integer> myList = new MyArrayList<>();

        // Test add() method
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println();
        System.out.println("After adding 5 elements: " + myList);

        // Test add(index) method
        myList.add(0, 0);
        myList.add(3, 6);
        myList.add(7, 2);
        System.out.println("After adding 3 elements at specific indices: " + myList);

        // Test get() method
        System.out.println("Element at index 2: " + myList.get(2));

        // Test remove() method
        myList.remove(2);
        myList.remove(5);
        System.out.println("After removing 2 elements: " + myList);

        // Test clear() method
        myList.clear();
        System.out.println("After clearing the list: " + myList);

        // Test size() method
        System.out.println("Size of the list: " + myList.size());

        // Test contains() method
        myList.add(10);
        myList.add(20);
        myList.add(30);
        System.out.println("List contains 20: " + myList.contains(20));

        // Test indexOf() method
        System.out.println("Index of 20: " + myList.indexOf(20));

        // Test lastIndexOf() method
        myList.add(20);
        System.out.println("Last index of 20: " + myList.lastIndexOf(20));

        // Test sort() method
        myList.sort();
        System.out.println("After sorting: " + myList);

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println();

        // Test MyLinkedList
        MyList<String> list = new MyLinkedList<>();

        // Test add() method
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Durian");
        list.add("Elderberry");

        // Test size() method
        System.out.println("Size of the list: " + list.size());

        // Test contains() method
        System.out.println("List contains \"Apple\": " + list.contains("Apple"));
        System.out.println("List contains \"Mango\": " + list.contains("Mango"));

        // Test get() method
        System.out.println("Item at index 3: " + list.get(3));

        // Test indexOf() method
        System.out.println("Index of \"Durian\": " + list.indexOf("Durian"));

        // Test lastIndexOf() method
        System.out.println("Last index of \"Banana\": " + list.lastIndexOf("Banana"));

        // Test remove() method
        System.out.println("Removing \"Cherry\" from list...");
        list.remove("Cherry");

        // Test size() method
        System.out.println("Size of the list: " + list.size());

        // Test indexOf() method
        System.out.println("Index of \"Cherry\": " + list.indexOf("Cherry"));

        // Test add() method
        System.out.println("Adding \"Grapes\" to index 2...");
        list.add("Grapes", 2);

        // Test size() method
        System.out.println("Size of the list: " + list.size());

        // Test get() method
        System.out.println("Item at index 2: " + list.get(2));


        // Test remove() method
        System.out.println("Removing item at index 4...");
        list.remove(4);

        // Test size() method
        System.out.println("Size of the list: " + list.size());

        // Test get() method
        System.out.println("Item at index 4: " + list.get(4));

        // Test clear() method
        System.out.println("Clearing the list...");
        list.clear();

        // Test size() method
        System.out.println("Size of the list: " + list.size());
    }

}