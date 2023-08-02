import java.util.Random;

/**
 * sort
 */
public class SimpleSort {

    public static void main(String[] args) {
        

        System.out.println("Bubble Sort:");
        int[] myArray = randomArray(10);
        printArray(myArray);
        bubbleSortOptimized(myArray);
        printArray(myArray);

        System.out.println("Selection Sort:");
        myArray = randomArray(10);
        printArray(myArray);
        selectionSortIndexed(myArray);
        printArray(myArray);

        System.out.println("Insertion Sort:");
        myArray = randomArray(10);
        printArray(myArray);
        insertionSort(myArray);
        printArray(myArray);

        System.out.println("Shaker Sort:");
        myArray = randomArray(10);
        printArray(myArray);
        shakerSort(myArray);
        printArray(myArray);
    }
    
    public static int[] randomArray(int size){
        Random r = new Random();
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = r.nextInt(10);
        }
        return newArray;
    }

    public static void printArray(int[] array){
        for (int item : array) {
            System.out.printf("%d ", item);
        }
        System.out.println("/n");
    }

    public static void bubbleSort(int[] array){ // move heavy elements to the end
        for (int i = 0; i < array.length; i++) { 
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp; 
                }
            }
        }
    }

    public static void bubbleSortOptimized(int[] array){ // number of cycles is minimized
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i]>array[i+1]){
                    int tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    finish = false;
                }
            }
        } while (!finish);
        
    }


    public static void selectionSort(int[] array){ // look for min in the unsorted part
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

        public static void selectionSortIndexed(int[] array){ // same but memorize the min index
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }

            }
            if (i!=min) {
                int tmp = array[min];
                array[min] = array[i];
                array[i] = tmp;
            }
        }
    }

    public static void insertionSort(int[] array) { // insert new value in sorted part by shifting values right
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            boolean shift;
            int position;
            for (int j = i-1; j >= 0 ; j--) { // shifting to the right
                if (array[j]>tmp) {
                    array[j+1] = array[j];
                    shift = true;
                    position = j;
                    
                } else {
                    break;
                }
            if (shift) {
                array[position] = tmp; // insertion as a separate function
            }

            }
        }
    }

    public static void shakerSort(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            for (int j = i; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }

            for (int j = array.length - 2 - i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }

        }
    }
}

