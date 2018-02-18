//Selection sort

//here you pop out smallest number to ith position
public class selectionSort {
    public static void selectionsort(int[] a) {
        int minIndex;
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                    System.out.println(minIndex);
                }
            }
            temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
            System.out.println("Sorted array after " + i);
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
        System.out.println("Selection sort");
        int[] arr = {100, 5, 89, 7, 2};
        selectionsort(arr);
    }

}
