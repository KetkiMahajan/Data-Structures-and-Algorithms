/**
 * Implementation of Data Structure and Algorithms
 * Created by Ketki Mahajan on 1/16/2018.
 **/
public class MaxSubarrayDAC {
    public static int[] findMaxSubarray(int[] A, int low, int high) {
        int[] B = new int[3];
        if (low == high) {
            B[0] = low;
            B[1] = high;
            B[2] = A[high];
            return B;
        } else {
            int mid = (low + high) / 2;
            int[] leftArray = findMaxSubarray(A, low, mid);
            int[] rightArray = findMaxSubarray(A, (mid + 1), high);
            int[] crossOver = findCrossSum(A, low, mid, high);

            if (leftArray[2] > rightArray[2] && leftArray[2] > crossOver[2])
                return leftArray;
            else if (rightArray[2] > leftArray[2] && rightArray[2] > crossOver[2])
                return rightArray;
            else
                return crossOver;
        }
    }

    public static int[] findCrossSum(int[] A, int low, int mid, int high) {
        int leftSum = -99999;
        int rightSum = -9999;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = mid; i >= low; i--) {
            sum1 = sum1 + A[i];
            if (sum1 > leftSum) {
                leftSum = sum1;
                maxLeft = i;
            }
        }
        for (int j = mid + 1; j <= high; j++) {
            sum2 = sum2 + A[j];
            if (sum2 > rightSum) {
                rightSum = sum2;
                maxRight = j;
            }
        }
        sum = rightSum + leftSum;
        int[] Ans = {maxLeft, maxRight, sum};
        return Ans;
    }

    public static void main(String[] args) {

        int[] arr = {-5, 15, -1, 20};
        int[] ans = findMaxSubarray(arr, 0, (arr.length - 1));
        System.out.println(ans[0] + ", " + ans[1] + ", " + ans[2]);
    }
}
