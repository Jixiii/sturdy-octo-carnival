import java.util.Scanner;

/**
 * @author 代珉玥
 */
public class Homework3to13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int numberOfSegments = scanner.nextInt();
        long[] numOf0 = new long[]{0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        long[][] numItoJ = new long[length][length];
        numItoJ[0][length - 1] = scanner.nextLong();
        for (int j = length - 2; j >= 0; j--) {
            numItoJ[0][j] = numItoJ[0][j + 1] / 10;
        }
        for (int i = 1; i < length; i++) {
            numItoJ[i][length - 1] = numItoJ[0][length - 1] % numOf0[length - i];
            for (int j = length - 2; j >= 0; j--) {
                numItoJ[i][j] = numItoJ[i][j + 1] / 10;
            }
        }
        long[][] largestProduct = new long[length][numberOfSegments + 1];
        for (int i = 0; i < length; i++) {
            largestProduct[i][0] = numItoJ[i][length - 1];
        }
        for (int k = 1; k < numberOfSegments; k++) {
            for (int i = 0; i < length - k; i++) {
                for (int j = i; j < length - k; j++) {
                    largestProduct[i][k]=Math.max(numItoJ[i][j]*largestProduct[j+1][k-1],largestProduct[i][k]);
                }
            }
        }
        System.out.println(largestProduct[0][numberOfSegments-1]);
    }
}