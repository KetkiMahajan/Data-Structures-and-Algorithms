import java.util.Scanner;

//Euclid's algorithm
public class gcd {
    public static int findGCD(int num1, int num2) {

        if (num1 % num2 == 0) {
            return num2;
        } else {
            int rem = num1 % num2;
            num1 = num2;
            return findGCD(num1, rem);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the greater number");
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        System.out.println("Enter the second number");
        int y = scn.nextInt();
        System.out.println("The gcd is : " + findGCD(x, y));

    }
}
