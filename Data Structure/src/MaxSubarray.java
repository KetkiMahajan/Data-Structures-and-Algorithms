
/**
 * Implementation of Data Structure and Algorithms
 * Created by Ketki Mahajan on 1/15/2018.
 **/
public class MaxSubarray {
    public static void main(String[] args) {

        int[] arr = {-5, -9, 15, 20, -6, 10, -1};
        int ans = findMaxSubarray(arr);
        System.out.println(ans);
    }

    public static int findMaxSubarray(int[] arr) {
        int sum = 0;
        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum = sum + arr[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
