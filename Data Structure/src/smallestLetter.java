public class smallestLetter {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println("a: " + (int) target);
        System.out.println(nextGreatestLetter(arr, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        for (char ch : letters) {
            if (ch > target)
                return ch;
        }
        return letters[0];
    }
}
