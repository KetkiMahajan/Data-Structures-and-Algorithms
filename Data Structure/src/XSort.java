public class XSort {
    public static void main(String[] args) {
        int[] A = {10, 7, 12, 17, 8, 5, 25, 1};
        xsort(A, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
    }

    public static void xsort(int[] A, int p, int r) {
        int n = r - p + 1;
        if (n <= 1)
            return;
        if (A[p] > A[r]) {
            int temp = A[p];
            A[p] = A[r];
            A[r] = temp;
        }
        if (n == 2) {
            return;
        }
        int nb3 = n / 3;
        xsort(A, p, r - nb3);  // sort first two-thirds
        xsort(A, p + nb3, r); // sort last two-thirds
        xsort(A, p, r - nb3); // sort first two-thirds again
    }
}