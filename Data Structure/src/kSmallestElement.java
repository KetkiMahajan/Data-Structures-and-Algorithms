import java.util.Scanner;

public class kSmallestElement {
    public static int FindkSmallest(int[] A, int p, int r, int k) {
        choosePivot(A, p, r);
        int q = partition(A, p, r);
        int left = q - p;
        int right = r - q;
        if (left >= k) {
            return FindkSmallest(A, p, q - 1, k);
        } else if (left + 1 == k)
            return q;
        else
            return FindkSmallest(A, q + 1, r, k - (left + 1));

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
        /*int[] Mi= new int[B.length/5];
        for(int s=0; s <= (B.length/5)-1; s++){

            insertionSort(B,p+(5*s),p+(5*s)+4);
            Mi[s]= B[p+(5*s)+2];
        }
        int m=FindkSmallest(Mi,0,(B.length/5)-1,B.length/10);
        //int x= bsearch(B,p,r,m);
       // int tem;
       // tem=B[x];
       // B[x]=B[r];
       // B[r]=tem;*/
    }

    public static int bsearch(int[] a, int l, int h, int k) {

        int mid = (l + h) / 2;
        if (k < a[mid]) {
            return bsearch(a, l, mid - 1, k);
        } else if (a[mid] <= k && a[mid + 1] > k) {
            return mid;
        } else
            return bsearch(a, mid + 1, h, k);
    }

    public static void insertionSort(int[] B, int p, int r) {
        for (int j = 0; j < B.length; j++) {
            int key = B[j];
            int i = j - 1;
            while (i >= 0 && B[i] > key) {
                B[i + 1] = B[i];
                i--;
            }
            B[i + 1] = key;
        }

    }

    public static void main(String[] args) {
        int[] A = {27, 10, 11, 1, 8, 3, 7, 18, 13, 2};
        int k;
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        System.out.println(FindkSmallest(A, 0, A.length - 1, k));

    }

}
