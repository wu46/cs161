package sort;
import java.util.*;

public class QuickSort{
    private int[] v;
    public long nIter;

    public QuickSort(int[] arr) {
        v = arr;
    }
    public void sort(){
        nIter = quickSort(v, 0, v.length);
        System.out.format("QuickSort made %d comparisons\n", nIter);
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
        int pivotIndex = getPivotIndex(v,init,len,3);
        int pivot = v[pivotIndex];
//        System.out.println("Beginning of quicksort");
//        System.out.format("init=%d, len=%d, position %d is pivot\n", init, len, pivotIndex);
//        System.out.println(Arrays.toString(v));

        // put pivot as first element
        v[pivotIndex] = v[init];
        v[init] = pivot;
//        System.out.println("After putting pivot first");
//        System.out.println(Arrays.toString(v));

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
//        System.out.println("End of quicksort:");
//        System.out.println(Arrays.toString(v));
//        System.out.format("Recursive calls with %d,%d and %d,%d\n", init, i-init, i, len-(i-init));
        // do the recursive calls
        return len-1+ quickSort(v, init, i-init-1) + quickSort(v, i, len-(i-init));
//        return 0;
            
    }
    private static int getPivotIndex(int[] v, int init, int len, int pivotMethod) {
        /* pivotMethod is an integer
         * 1 - first element of subarray
         * 2 - last element of subarray
         * 3 - median method
         */
        switch (pivotMethod) {
            case 1:
                return init;
            case 2:
                return init+len-1;
            case 3:
                // choose middle of 3
                int a = init;
                int b = init+len/2-1+len%2;
                int c = init+len-1;
                System.out.format("Choosing between {%d, %d, %d}\n", a, b, c);
                if (v[a] > v[b]) {
                    if (v[b] > v[c]) {
                        return b;
                    } else if (v[a] > v[c]) {
                        return c;
                    } else {
                        return a;
                    }
                } else {
                    if (v[a] > v[c]) {
                        return a;
                    } else if (v[b] > v[c]) {
                        return c;
                    } else {
                        return b;
                    }

                }

            default:
                return 0;
        }
    }
}
