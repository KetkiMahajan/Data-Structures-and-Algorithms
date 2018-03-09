import java.util.HashMap;

/**
 * Implementation of Data Structure and Algorithms
 * Find sequence all distinct elements from array where largest element can be  equal to length
 * of array. We need to find minimum window of such elements
 * Created by Ketki Mahajan on 3/5/2018.
 **/
public class MinWindowMaxDistinct {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 4, 5, 4, 1, 7};
        findSubString(arr);
    }

    static void findSubString(int[] A) {
        int n = A.length;
        int distinctNo = 0;
        int[] myArr = new int[n];
        int start = 0;
        int min_len = n;
        int count = 0; //
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            myArr[A[i]] = 1;
        }

        for (int i = 0; i < A.length; i++) {
            if (myArr[i] == 1) {
                distinctNo = distinctNo + 1;
            }
        }
        System.out.println("distinctNo: " + distinctNo);

        for (int l = 0; l < A.length; l++) {
            hm.put(A[l], 0);
        }
        for (int j = 0; j < n; j++) {

            if (hm.get(A[j]) == 0 && myArr[A[j]] == 1) {
                count = count + 1;
            }
            int temp = hm.get(A[j]);
            hm.put(A[j], temp + 1);

            if (count == distinctNo) {

                while (hm.get(A[start]) > 1 || myArr[A[start]] != 1) {
                    int tempElem = hm.get(A[start]) - 1;

                    hm.put(A[start], tempElem - 1);
                    start = start + 1;
                }
                if (j - start < min_len) {
                    min_len = j - start;
                }
            }
        }
        System.out.println("Window size: " + (min_len + 1));
        System.out.println("Window position: " + start + " , " + (start + min_len));
    }

}
