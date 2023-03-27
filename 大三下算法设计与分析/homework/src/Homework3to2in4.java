import java.util.Scanner;

/**
 * @author 代珉玥
 */
public class Homework3to2in4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        System.out.println(costOfAToB(A, B));
    }

    public static int costOfAToB(String A, String B) {
        int lengthOfA = A.length();
        int lengthOfB = B.length();
        if (lengthOfA == 0) {
            return lengthOfB;
        }
        if (lengthOfB == 0) {
            return lengthOfA;
        }
        int[][] cost = new int[lengthOfA][lengthOfB];
        cost[0][0] = A.charAt(0) == B.charAt(0) ? 0 : 1;
        for (int indexOfA = 1; indexOfA < lengthOfA; indexOfA++) {
            cost[indexOfA][0] = A.charAt(indexOfA) == B.charAt(0) ? indexOfA : cost[indexOfA - 1][0] + 1;
        }
        for (int indexOfB = 1; indexOfB < lengthOfB; indexOfB++) {
            cost[0][indexOfB] = A.charAt(0) == B.charAt(indexOfB) ? indexOfB : cost[0][indexOfB - 1] + 1;
        }
        for (int indexOfA = 1; indexOfA < lengthOfA; indexOfA++) {
            for (int indexOfB = 1; indexOfB < lengthOfB; indexOfB++) {
                if (A.charAt(indexOfA) == B.charAt(indexOfB)) {
                    cost[indexOfA][indexOfB] = cost[indexOfA - 1][indexOfB - 1];
                } else {
                    cost[indexOfA][indexOfB] = 1 + Math.min(Math.min(cost[indexOfA - 1][indexOfB - 1], cost[indexOfA - 1][indexOfB]), cost[indexOfA][indexOfB - 1]);
                }
            }
        }
        return cost[lengthOfA - 1][lengthOfB - 1];
    }
}