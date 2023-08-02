import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int size = 10;
        int[] myArray = randomArray(size);
        printArray(myArray);
        heapSort(myArray);
        printArray(myArray);
    }

    public static int[] randomArray(int size) {
        Random r = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(10);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static void heapNode(int[] array, int limit, int root) {
        int max = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        if (left <= limit && array[left] > array[root]) {
            max = left;
        }

        if (right <= limit && array[right] > array[root]) {
            if (array[left]>array[right]) {
                max = left;
            } else {
                max = right;
            }
        }

        if (max!=root) {
            int tmp = array[max];
            array[max] = array[root];
            array[root] = tmp; 
            heapNode(array, limit, max);
        }
    }

    public static void heapFull(int[] array, int limit) {

        for (int i = (array.length-1)/2; i >= 0; i--) {
            heapNode(array, limit, i);
        }

    }

    public static void heapSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            heapFull(array, array.length-1-i);
            int max = array[0];
            array[0] = array[array.length-1-i];
            array[array.length-1-i] = max;
        }
    }
}
