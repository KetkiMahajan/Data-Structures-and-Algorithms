/**
 * Implementation of Data Structure and Algorithms
 * Activity Selection Problem-DP
 * Created by Ketki Mahajan on 2/22/2018.
 **/

class activities {
    int start;
    int finish;
    int value;

    activities(int start, int finish, int value) {
        this.start = start;
        this.finish = finish;
        this.value = value;
    }
}

public class activitySelectionProblem {

    public static void main(String[] args) {
        activities[] a = {
                new activities(0, 0, 0),
                new activities(1, 4, 3),
                new activities(3, 5, 2),
                new activities(0, 6, 6),
                new activities(5, 7, 2),
                new activities(3, 8, 5),
                new activities(5, 9, 4)
        };
        selectActivities(a);
    }

    private static void selectActivities(activities[] a) {
        int[] ASP = new int[a.length];
        boolean[] use = new boolean[a.length];
        int[] prev = new int[a.length];

        ASP[0] = 0;
        use[0] = false;
        prev[0] = 0;

        int j;
        for (int i = 1; i < a.length; i++) {
            ASP[i] = ASP[i - 1];
            use[i] = false;
            j = i - 1;
            while (a[j].finish > a[i].start) {
                j--;
            }
            prev[i] = j;
            if (ASP[i] < a[i].value + ASP[j]) {
                ASP[i] = a[i].value + ASP[j];
                use[i] = true;
            }
        }
        System.out.println("Maximum profit by selecting activities :" + ASP[a.length - 1]);
        System.out.print("Activities taken in solution: ");
        printSolution(ASP, use, prev);
    }

    private static void printSolution(int[] asp, boolean[] use, int[] prev) {
        int current = asp.length - 1;
        while (current > 0) {
            if (use[current]) {
                System.out.print(" " + current);
                current = prev[current];
            } else
                current--;
        }
    }
}
