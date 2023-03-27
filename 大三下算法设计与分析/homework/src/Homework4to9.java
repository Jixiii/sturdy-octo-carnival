import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework4to9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distance = scanner.nextInt();
        int numberOfGasStations = scanner.nextInt() + 1;
        int[] distanceOfGasStation = new int[numberOfGasStations];
        for (int i = 0; i < numberOfGasStations; i++) {
            distanceOfGasStation[i] = scanner.nextInt();
        }
        System.out.println(findTheMinimumRefuelingTimes(distance, numberOfGasStations, distanceOfGasStation) == -1 ?
                "No solution" :
                findTheMinimumRefuelingTimes(distance, numberOfGasStations, distanceOfGasStation));

    }

    public static int findTheMinimumRefuelingTimes(int distance, int numberOfGasStations,
                                                   int[] distanceOfGasStation) {
        int result = 0;
        int tempDistance = 0;
        for (int i = 0; i < numberOfGasStations; i++) {
            if (distanceOfGasStation[i] > distance) {
                return -1;
            }
            tempDistance += distanceOfGasStation[i];
            if (tempDistance >= distance) {
                result++;
                tempDistance = 0;
                i--;
            }
        }
        return result;
    }
}