import java.util.Scanner;

public class binarySearch {

    public static int bsearch(int[] a, int l, int h, int k) {

        int mid = (l + h) / 2;
        if (k < a[mid]) {
            return bsearch(a, l, mid - 1, k);
        } else if (a[mid] <= k && a[mid + 1] > k) {
            return mid;
        } else
            return bsearch(a, mid + 1, h, k);
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 12, 12, 15, 36, 96};
        int low = 0;
        int high = arr.length - 1;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the item to be searched");
        int key = scn.nextInt();

        int ans = bsearch(arr, low, high, key);

        if (ans == -1) {
            System.out.println("We did not found the element");
        } else {
            System.out.println("Found at position:" + ans);
        }
    }
}
