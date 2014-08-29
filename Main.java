import sort.*;
import java.util.Arrays;
public class Main{
    public static void main(String args[]) {
        System.out.println("Hello World");
        int[] arr = {6,6,6,3,2,2};

        //MergeSort sorter = new MergeSort(arr);
        QuickSort sorter = new QuickSort(arr);
        sorter.sort();
        System.out.println(Arrays.toString(sorter.getSortedArray()));
    }
}
