public class BikePath {

    public static void main(String[] args) {
        int len = 9;
        int[][] A = {{1, 10}, {2, 8}, {1, 6}, {3, 5}, {9, 11}};
        findNumofFlowerist(A);
    }

    private static void findNumofFlowerist(int[][] a) {

        int[] start = new int[a.length];
        int[] end = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                start[i] = a[i][j];
                j++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                j++;
                end[i] = a[i][j];
            }
        }
        for (int i = 0; i < end.length - 1; i++) {
            for (int j = end.length - 1; j >= i + 1; j--) {

                if (end[j] < end[j - 1]) {
                    int temp = end[j];
                    end[j] = end[j - 1];
                    end[j - 1] = temp;

                    int tem2 = start[j];
                    start[j] = start[j - 1];
                    start[j - 1] = tem2;
                }
            }
        }

        int i = 0;
        int count = 1;
        System.out.println("You can choose activities at this position:");
        System.out.print(i + " ");

        // Consider rest of the activities
        for (int j = 1; j < end.length; j++) {
            if (start[j] >= end[i]) {
                System.out.print(j + " ");
                i = j;

            } else if (count < 3) {
                System.out.print(j + " ");
                i = j;
                count++;
            }
        }

    }
}
