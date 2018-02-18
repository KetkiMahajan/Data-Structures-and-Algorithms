import java.util.Scanner;

//Deleting Array
public class ShiftingArray {

    public static void deleteFromArray(int[] a, int key) {
        int pos = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                pos = i;
        }
        for (int j = pos; j < a.length - 1; j++) {
            a[j] = a[j + 1];
        }
        System.out.println("Array after delete");
        for (int k = 0; k < a.length - 1; k++) {

            System.out.println(a[k]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 8, 9, 10};
        System.out.println("Enter number to delete");
        Scanner scn = new Scanner(System.in);
        int key = scn.nextInt();
        deleteFromArray(arr, key);
    }
}
