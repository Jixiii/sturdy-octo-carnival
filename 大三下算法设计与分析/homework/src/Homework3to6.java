import java.util.Scanner;

/**
 * @author 代珉玥
 */
public class Homework3to6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cost[][] = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n ; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }
        int[] costToN = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            costToN[i] = cost[i][n - 1];
            for (int j = i + 1; j < n - 1; j++) {
                costToN[i] = Math.min(costToN[i], cost[i][j] + costToN[j]);
            }
        }
        System.out.println(costToN[0]);
    }
}