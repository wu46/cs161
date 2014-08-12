import sort.*;
import java.util.Arrays;
public class Main{
    public static void main(String args[]) {
        System.out.println("Hello World");

        int[] arr = {6,5,4,3,2,1};
        MergeSort sorter = new MergeSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
        sorter.display();
    }
}
