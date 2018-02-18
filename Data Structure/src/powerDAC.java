public class powerDAC {
    public static void main(String[] args) {
        int ans = DACPower(2, 5);
        System.out.println(ans);
    }

    public static int DACPower(int x, int n) {
        int p = 0;
        if (n == 0)
            return 1;
        else {
            p = DACPower(x * x, n / 2);
            if (n % 2 != 0) {
                return p * x;
            } else {
                return p;
            }
        }
    }
}
