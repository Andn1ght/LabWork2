public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();

        // Test add() method
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
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
    }

}