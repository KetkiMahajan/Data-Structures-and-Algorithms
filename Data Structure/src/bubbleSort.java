//Ketki Mahajan
//we check the elements of j loop and find the largest number and then push it to last index
public class bubbleSort {

    public static void bubblesort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Bubble sort");
        int[] arr = {100, 5, 89, 7, 2};

        bubblesort(arr);

    }
}
