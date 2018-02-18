public class factorial {
    public static int factorial1(int n) {
        if (n == 0)
            return 1;
        int x = n * factorial1(n - 1);
        return x;
    }

    public static void main(String[] args) {
        System.out.println(factorial1(3));
    }
}
