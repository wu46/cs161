package sort;
import java.util.*;

public class QuickSort{
    private int[] v;
    public int nIter;

    public QuickSort(int[] arr) {
        v = arr;
    }
    public void sort(){
        nIter = quickSort(v, 0, v.length);
    }

    public void display(){
        System.out.println(Arrays.toString(v));
    }

    public int[] getSortedArray() {
        return v;
    }

    private void printArray() {
        int len = v.length;
        for (int i = 0; i < len; i++) {
            System.out.format("%d  ", v[i]);
        }

    }

    private static int quickSort(int[] v, int init, int len) {
        // init: index of first element of subarray

        // base case: if length is 1
        if (len <= 1) {
            return 0;
        }
        // TODO: implement different ways to choose pivot - currently is first element
        int pivotIndex = init;
        int pivot = v[pivotIndex];

        // put pivot as first element
        v[pivotIndex] = v[init];
        v[init] = pivot;


        int i = init + 1; // i is index of first element larger than pivot
        int temp;
        for (int j = i; j < len+init; j++) {
            if (v[j] < pivot) {
                temp = v[i];
                v[i] = v[j];
                v[j] = temp;  
                i++; 
            } 
        }

        // put pivot in the middle
        v[init] = v[i-1];
        v[i-1] = pivot;
        
        // do the recursive calls
        return quickSort(v, init, i-init) + quickSort(v, i, len-(i-init));
            
    }
}
