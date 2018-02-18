import java.util.Arrays;

public class sumThree {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0};
        int target = 3;
        int ans = threeSumClosest(arr, target);
        System.out.println("Sum is " + ans);

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int leastSum = nums[0] + nums[1] + nums[nums.length - 1];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < Math.abs(leastSum - target)) {
                        leastSum = sum;
                    }
                }
            }
        }
        return leastSum;
    }
}
