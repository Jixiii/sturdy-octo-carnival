import java.util.Arrays;
import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework4to1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = scanner.nextInt();
            endTime[i] = scanner.nextInt();
        }
        System.out.println(findTheNumberOfVenues(n, startTime, endTime));
    }

    public static int findTheNumberOfVenues(int n, int[] startTime, int[] endTime) {
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int result = 0;
        int endIndex = 0;
        for (int startIndex = 0; startIndex < n; startIndex++) {
            if (startTime[startIndex] < endTime[endIndex]) {
                result++;
            } else {
                endIndex++;
            }
        }
        return result;
    }
}