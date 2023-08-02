import java.util.Random;

/**
 * bsearch
 */
public class BiSearch {

    public static void main(String[] args) {
        
        int[] myArray = randomArray(10);
        printArray(myArray);
        bubbleSortOptimized(myArray);
        printArray(myArray);
        System.out.println(bSearchNR(myArray,5));
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

    public static int bSearch(int[] array, int target){
        return bSearch(array, target, 0, array.length-1);
    }

    public static int bSearch(int[] array, int target, int min, int max){
        if (min>max) {
            return -1;
        }
        
        int midPoint = ((min + max) / 2);

        if (array[midPoint]>target) {
            max = midPoint - 1;
        } else if (array[midPoint]<target) {
            min = midPoint + 1;
        } else {
            return midPoint;
        } 

        return bSearch(array, target, min, max);

    }

    public static int bSearchNR(int[] array, int target) {
        int left = 0, right = array.length-1;
        while (right - left > 1) {
            int mid = (left+right) / 2;
            if (array[mid]>target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}