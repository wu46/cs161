import sort.*;
import java.util.Arrays;
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) {
        System.out.println("Hello World");
        int[] arr = getIntegerFromFile("intQuickSort.txt");

        //MergeSort sorter = new MergeSort(arr);
        QuickSort sorter = new QuickSort(arr);
        sorter.sort();
        //System.out.println(Arrays.toString(sorter.getSortedArray()));
    }

    private static int[] getIntegerFromFile(String filename){
        Scanner sc = null;
        int n = 10000; int i = 0;
        int[] arr = new int[n];
        try{ 
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage());
        }

        while (sc != null && sc.hasNextInt()){
            arr[i++] = sc.nextInt();
        }
        return arr;
    }
}
