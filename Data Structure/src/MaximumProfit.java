public class MaximumProfit {
    public static int maxProfit(int[] prices) {
        int maxCurrent = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (maxCurrent < 0) {
                maxCurrent = prices[i] - prices[i - 1];
            } else {
                maxCurrent = maxCurrent + (prices[i] - prices[i - 1]);
            }
            if (maxProfit < maxCurrent) {
                maxProfit = maxCurrent;
            }
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
