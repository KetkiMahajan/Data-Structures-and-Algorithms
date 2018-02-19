/**
 * Implementation of Data Structure and Algorithms-counting Sort
 * Created by Ketki Mahajan on 2/19/2018.
 **/

public class countingSort {
    public static int[] cSort(int[] A, int k) {
        int[] C = new int[k + 1];

        int[] B = new int[A.length];

        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }
        for (int j = 0; j < A.length; j++) {
            C[A[j]]++;
        }
        for (int m = 1; m < C.length; m++) {
            C[m] = C[m] + C[m - 1];
        }
        for (int n = A.length - 1; n >= 0; n--) {
            B[C[A[n]] - 1] = A[n];
            C[A[n]] = C[A[n]] - 1;
        }
        /*for (int i = 0; i<B.length; ++i)
        {
            B[C[A[i]]-1] = A[i];
            --C[A[i]];
        }*/
        return B;
    }

    public static void main(String[] args) {
        System.out.println("Counting sort");
        int[] A = {1, 1, 2, 3, 4, 3};
        int[] temp = cSort(A, 4);

        for (int i = 0; i < temp.length; i++) {
            System.out.print(" " + temp[i]);
        }
    }
}
