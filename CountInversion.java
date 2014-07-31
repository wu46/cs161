import java.util.*;
import java.io.*;
public class CountInversion{
    public static void main(String[] args) {
    	int n = 100000;
    	int[] arr_unsorted = new int[n];
        int i = 0;
    	Scanner sc = null;
    	/*
    	try {
    		sc = new Scanner(new File("IntegerArray.txt"));
    	} catch (FileNotFoundException e) {
    		System.err.println("FileNotfoundException: " + e.getMessage());
    	}

        while (sc !=null && sc.hasNextInt()) {
        	arr_unsorted[i++] = sc.nextInt();
        }
        System.out.format("last int is %d\n", arr_unsorted[n-1]);
        */
        
        //System.out.println("sorted array: ");
        //System.out.println(Arrays.toString(arr_sorted));
        
        int[] v = new int[10];
        System.out.println(Arrays.toString(v));
        testArray(Arrays.copyOfRange(v, 0, 5));
        System.out.println(Arrays.toString(v));
    }
    
    private static void testArray(int[] v) {
    	for (int i = 0; i < v.length; i++) {
    		v[i] = i*3;
    	}
    }
    
    private static int sortAndCount(int[] v) {
    	int n = v.length;
    	int mid = n/2;
    	if (n <= 1) {
    		return 0;
    	}
    	int[] left = Arrays.copyOfRange(v,0,mid);
    	int[] right = Arrays.copyOfRange(v,mid,n);
    	return sortAndCount(left) + sortAndCount(right) + mergeAndCountSplit(left,right);
    }
    private static int mergeAndCountSplit(int[] v1, int[] v2) {
    	int nSplit = 0;
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
        return -1; 
    }

}
