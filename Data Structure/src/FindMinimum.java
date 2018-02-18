public class FindMinimum {

    static int findMin(int[] B) {
        int min = B[0];
        int secMin = B[0];
        for (int i = 0; i < B.length; i++) {
            if (B[i] < min) {
                secMin = min;
                min = B[i];

            } else if (B[i] < secMin && B[i] != min) {
                secMin = B[i];
            }
        }
        System.out.println("second :" + secMin);
        return min;
    }

    public static void main(String[] args) {
        int[] A = {5, 9, 6, 2, 33};
        System.out.println(findMin(A));
    }
}
