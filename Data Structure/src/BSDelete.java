/**
 * Implementation of Data Structure and Algorithms
 * Created by Ketki Mahajan on 1/20/2018.
 **/
import java.util.Scanner;

public class BSDelete {

    public static int bsearch(int[] a, int l, int h, int k) {
        if (h < l)
            return 0;

        int mid = (l + h) / 2;
        if (a[mid] == k) {
            return mid;
        }

        if (a[mid] < k) {
            return bsearch(a, mid + 1, h, k);
        } else
            return bsearch(a, l, mid - 1, k);

    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 33, 56, 89, 100};
        int low = 0;
        int high = arr.length - 1;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the item to be searched");
        int key = scn.nextInt();

        int ans = bsearch(arr, low, high, key);

        if (ans == 0) {
            System.out.println("Not found the element");
        } else {
            System.out.println("Found at :" + ans);
            for (int j = ans; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            System.out.println("Array after delete");
            for (int k = 0; k < arr.length - 1; k++) {

                System.out.println(arr[k]);
            }
        }
    }
}
