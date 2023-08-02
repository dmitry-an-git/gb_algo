import java.util.Random;

public class LogSort {

    public static void main(String[] args) {
        
        System.out.println("QuickSort");
        int[] myArray = randomArray(10);
        //myArray = new int[]{1,0,6,0,3,0,9,3,9,5};
        printArray(myArray);
        quickSort(myArray);
        printArray(myArray);

        System.out.println("MergeSort");
        myArray = randomArray(10);
        //myArray = new int[]{1,0,6,0,3,0,9,3,9,5};
        printArray(myArray);
        mergeSort(myArray);
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

    
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int[] array, int min, int max){
        if (max-min<1) {return;}

        int pivot = ((min+max)/2);
        int pivotVal = array[pivot];
        int start = min;
        int finish = max;
        
        while (start<finish) {
            boolean foundStart = false;
            boolean foundFinish = false;

            while (start < pivot) {
                if (array[start] > pivotVal) {
                    foundStart = true;
                    break;
                }
                start++;
            }

            while (finish > pivot ) {
                if (array[finish] < pivotVal) {
                    foundFinish = true;
                    break;
                }
                finish --;
            }

            if (foundStart && foundFinish) {
                int tmp = array[start];
                array[start] = array[finish];
                array[finish] = tmp;
            } else if (foundStart) { // finish is at the pivot here
                array[pivot] = array[start];
                array[start] = pivotVal;
                pivot = start;
            } else if (foundFinish) {
                array[pivot] = array[finish];
                array[finish] = pivotVal;
                pivot = finish;
             }
        
        }

        quickSort(array, min, pivot-1);
        quickSort(array, pivot+1, max);

    }


    static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int left, int right){
        
        if (right == left) {
            return ;
        }

        int mid = (right+left) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);

        int i = left, j = mid+1, k = left;

        int[] buf = new int[array.length];
        
        while (i <= mid && j <= right) {
            if (array[i]<array[j]) {
                buf[k++] = array[i++];
            } else {
                buf[k++] = array[j++];
            }
        }

        while (i<=mid) {
            buf[k++] = array[i++];
        }

        while (j<=right) {
            buf[k++] = array[j++];
        }

        for (int l = left; l <= right; l++) {
            array[l] = buf[l];
        }
        printArray(array);
        
    }
}
