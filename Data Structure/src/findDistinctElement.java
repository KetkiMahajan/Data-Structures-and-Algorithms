
import java.util.ArrayList;

public class findDistinctElement {
    static ArrayList<Integer> C = new ArrayList<>();

    public static void findD(int[] A, int p, int r, ArrayList<Integer> D) {
        int c = 1;
        if (A[p] == A[r]) {
            if (!D.contains(A[p])) {
                D.add(A[p]);
                C.add(r - p + 1);
            }
        } else {
            int q = (p + r) / 2;
            findD(A, p, q, D);
            findD(A, q + 1, r, D);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 2, 2, 3, 3, 4, 5, 5};
        ArrayList<Integer> D = new ArrayList<>();
        findD(A, 0, A.length - 1, D);
        System.out.print(D);
        System.out.println(C);
    }
}
