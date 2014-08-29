package sort;
import java.util.Arrays;

public class MergeSort{
    private int[] v;

    public MergeSort(int[] arr){
        v = arr;
    }

    public void sort() {
        v = mergeSort(v);
    }
    public void display(){
        System.out.println(Arrays.toString(v));
    }
    public int[] getSortedArray(){
        return v;
    }
    private static int[] mergeSort(int[] v) {
    	int n = v.length;
    	int mid = n/2;
    	if (n <= 1) {
    		return v;
    	}
    	
    	return merge(mergeSort(Arrays.copyOfRange(v, 0, mid)),
    		mergeSort(Arrays.copyOfRange(v,mid,n)) );
    }
    private static int[] merge(int[] v1, int[] v2) {
        int i1 = 0; int i2 = 0; int iout = 0;
        int len1 = v1.length; int len2 = v2.length;
        int[] out = new int[len1+len2];
        int[] v=v1; int i=0;
        while(i1 < len1 && i2 < len2) {
        	if (v1[i1] < v2[i2]) {
        		out[iout] = v1[i1];
        		iout++; i1++;
        	} else {
        		out[iout] = v2[i2];
        		iout++; i2++;
        	}
        }
        
        // copy from the rest of the unexhausted vector
        if (i1 < len1) {
        	v = v1; i = i1;
        } else if (i2 < len2) {
        	v = v2; i = i2;
        }
        while(iout < len1+len2) {
        	out[iout] = v[i];
        	iout++; i++;
        }
        return out; 
    }

}
