public class toh {
    public static void move(int numberofDisc, char from, char to, char inter) {
        if (numberofDisc == 1) {
            System.out.println("Moving disc 1 from:" + from + "to:" + to);
        } else {
            move(numberofDisc - 1, from, inter, to);
            System.out.println("Moving disc" + numberofDisc + "from:" + from + "to:" + to);
            move(numberofDisc - 1, inter, to, from);
        }
    }

    public static void main(String[] args) {
        move(3, 'A', 'C', 'B');
    }
}
