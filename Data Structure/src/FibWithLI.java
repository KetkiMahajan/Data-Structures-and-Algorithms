/**
 * Implementation of Data Structure and Algorithms
 * Created by Ketki Mahajan on 2/19/2018.
 **/
public class FibWithLI {
    public static int fib(int n) {
        int[] temp = new int[n + 1];
        if (n == 0) {
            temp[0] = 0;
        }
        if (n == 1) {
            temp[1] = 1;
        } else {
            for (int i = n; i > 1; i--) {
                temp[i] = fib(n - 1) + fib(n - 2);
            }
        }
        return temp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
