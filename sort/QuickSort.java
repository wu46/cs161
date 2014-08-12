package sort;
import java.util.*;

public class QuickSort{
    private int[] v;
    public static void main (String args[]){
        System.out.println("Hello World");
        int[] arr = {5,9,8,7,4,6,3,1};
        System.out.println("Before sorting: \n");
        System.out.println(Arrays.toString(arr));
        int nPasses = quickSort(arr);
        System.out.println("After sorting: \n");
        System.out.println(Arrays.toString(arr));
    }
    public {

    }
    private void printArray() {
        int len = v.length;
        for (int i = 0; i < len; i++) {
            System.out.format("%d  ", v[i]);
        }

    }

    private static int quickSort(int[] v) {
        // choose pivot - use the first element
        int temp;
        int len = v.length;
        if (len == 1) {
            return 0;
        }
        // TODO: implement different ways to choose pivot - currently is first element
        int pivotIndex = 0;
        int pivot = v[pivotIndex];

        // put pivot as first element
        v[pivotIndex] = v[0];
        v[0] = pivot;


        int i = 1; // 
        for (int j = 1; j < len; j++) {
            System.out.println(Arrays.toString(v));
            if (v[j] < pivot) {
                System.out.format("Switching %d and %d\n", v[j], v[i]);
                temp = v[i];
                v[i] = v[j];
                v[j] = temp;  
                i++; 
            } 
        }

        // put pivot in the middle
        v[0] = v[i-1];
        v[i-1] = pivot;
        System.out.println("Switched pivot");
        System.out.println(Arrays.toString(v));

        return 0;
            

    }
}
