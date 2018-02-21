/**
 * Implementation of Data Structure and Algorithms
 * Created by Ketki Mahajan on 2/08/2018.
 **/
public class weightedMedeian {
    public static int FindkSmallest(int[] A, int p, int r, int SumWM) {
        choosePivot(A, p, r);
        int q = partition(A, p, r);
        int left = q - p;
        int lSum = 0;

        for (int i = p; i <= left; i++) {
            lSum = lSum + A[i];
        }

        if (lSum >= SumWM) {
            return FindkSmallest(A, p, q - 1, SumWM);
        } else if (lSum + A[q] >= SumWM)
            return A[q + 1];
        else
            return FindkSmallest(A, q + 1, r, SumWM - (lSum + A[q]));

    }

    public static int partition(int[] B, int p, int r) {
        int pivot = B[r];
        int i = (p - 1); // index of smaller element
        for (int j = p; j < r; j++) {
            if (B[j] <= pivot) {
                i++;
                int temp = B[i];
                B[i] = B[j];
                B[j] = temp;
            }
        }
        int temp = B[i + 1];
        B[i + 1] = B[r];
        B[r] = temp;

        return i + 1;
    }

    public static void choosePivot(int[] B, int p, int r) {
        int x = (p + r) / 2;
        int tem;
        tem = B[x];
        B[x] = B[r];
        B[r] = tem;
    }

    public static void main(String[] args) {
        int[] A = {10, 15, 16, 30, 40};
        System.out.println(FindkSmallest(A, 0, A.length - 1, 28));

    }
}
