public class insertionSort {

    public static void insertionsort(int[] a) {
        int current;
        for (int i = 0; i < a.length; i++) {
            current = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > current) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
            System.out.println("Sorted array pass" + i);
            for (int k = 0; k < a.length; k++) {
                System.out.println(a[k]);
            }
        }
        System.out.println("Sorted array");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Insertion sort");
        int[] arr = {10, 5, 89, 7, 2};
        insertionsort(arr);
    }
}
