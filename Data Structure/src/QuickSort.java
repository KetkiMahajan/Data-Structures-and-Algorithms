public class QuickSort {

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {-2, 4, 1, 4, 7, 4, 4, 4};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }

    int[] partition(int arr[], int low, int high) {
        int flag = 0;
        int pivot = arr[high];

        int i = (low - 1); // index of smaller element
        int k = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                if (flag != 1) {
                    k++;
                }
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] == pivot) {
                k++;
                int temp1 = arr[j];
                arr[j] = arr[k];
                arr[k] = temp1;
                flag = 1;
            }
        }
        int temp = arr[k + 1];
        arr[k + 1] = arr[high];
        arr[high] = temp;
        int[] part = new int[2];
        part[0] = i + 1;
        part[1] = k + 1;
        return part;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi[] = partition(arr, low, high);
            System.out.println(pi[0] + " ," + pi[1]);
            sort(arr, low, (pi[0] - 1));
            sort(arr, (pi[1] + 1), high);
        }
    }
}

