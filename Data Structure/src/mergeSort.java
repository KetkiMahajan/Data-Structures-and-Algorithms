public class mergeSort {
    public static int mergeS(int[] A, int p, int r) {
        int inv = 0;
        if (p < r) {
            int q = (p + r) / 2;
            int l = mergeS(A, p, q);
            int rr = mergeS(A, q + 1, r);
            inv = merge(A, p, q, r) + l + rr;
            return inv;
        }
        return inv;
    }

    public static int merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int inv = 0;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int j = 0; j < n1; j++) {
            left[j] = A[p + j];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = A[q + j + 1];
        }
        left[n1] = 999999;
        right[n2] = 999999;

        int m = 0;
        int n = 0;
        for (int k = p; k <= r; k++) {
            if (n > r || (m <= q && left[m] <= right[n])) {
                A[k] = left[m];
                m++;
            } else {
                A[k] = right[n];

                n++;
                inv = inv + n;

            }
        }
        return inv;

    }

    public static void main(String[] args) {
        int[] A = {25, 15, 10};
        System.out.println(mergeS(A, 0, A.length - 1));
        /*for(int i=0;i<B.length;i++){
            System.out.print(" "+ B[i]);
        }*/
    }
}
