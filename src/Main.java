public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();

        myList.add(3);
        myList.add(1);
        myList.add(23);
        myList.add(4);
        myList.add(34);
        myList.add(-123);
        myList.add(-32);
        myList.add(123);
        myList.add(2);
        myList.add(3);
        myList.add(62);
        myList.add(235);


        System.out.println("Original list:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        myList.sort();

        // Print the sorted list
        System.out.println("Sorted list:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }
}