public class maxsubArraywithIndex {
    public static void main(String[] args) {

        int[] arr = {-9, -8, -7, -5, -2};
        findMaxSubarray(arr);

    }

    public static void findMaxSubarray(int[] arr) {
        int sum = 0;
        int maxSum = arr[0];
        int left = 0, right = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
                left = i;
                right = i;
            } else {
                sum = sum + arr[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                right = i;
            }
            if (maxSum < 0) {
                left = 1;
                right = 0;

            }
        }
        System.out.println(left + " " + right);
        System.out.println(maxSum);
    }

}