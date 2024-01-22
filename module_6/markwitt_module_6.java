/*
 * mark witt
 * csd-420
 * module 6 assignment
 * 4/9/23
 */

 import java.util.Comparator;

 public class markwitt_module_6 {

    //generic that calls the comparator bubblesort to sort the values
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        bubbleSort(list, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
      }

    //comparator method to compare/swap values to sort the list
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator){
        boolean anotherPass = true;
        for (int k = 1; k < list.length && anotherPass; k++){
            anotherPass = false;
            for (int j = 0; j < list.length - k; j++){
                if (comparator.compare(list[j], list[j+1]) > 0){
                    //compares two numbers in the list, [j] and [j+1]. if the numbers are in wrong order, 
                    //uses the following to swap their positions, then sets anotherPass back to true, 
                    //indicating it needs to run comparison again
                    E temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    anotherPass = true;
                }
            }
        }
    }
    //print method to print out the list. 
    public static <E> void printList(E[] list){
        for (int a = 0; a < list.length; a++){
            System.out.print(list[a] + " ");
        }
    }
    //main method
    public static void main(String[] args){
        //create int list, print original, sort then print sorted list:
        Integer[] list = {14, 10, 44, 13, 8, -8, 37, 99, 2, 61, 7};
        System.out.print("\nOriginal List: ");
        printList(list);
        bubbleSort(list);
        System.out.print("\nSorted List: ");
        printList(list);

        //create string list, print original, sort then print sorted list:

        String[] list2 = {"Mark", "John", "Adam", "Zach", "Kevin", "BRIAN", "paul", "george"};
        System.out.print("\nOriginal List: ");
        printList(list2);
        bubbleSort(list2, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.print("\nSorted List: ");
        printList(list2);
    }

}


