import java.util.Scanner;

/**
 * @author 代珉玥
 */
public class Homework3to2in5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int startTime = scanner.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job();
            jobs[i].time = scanner.nextInt();
            jobs[i].cost = scanner.nextInt();
        }
        int sumTimeToN = startTime;
        int sumCostToN = 0;
        int[] finalCost = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sumCostToN += jobs[i].cost;
            sumTimeToN += jobs[i].time;
            int tempSumTime = sumTimeToN;
            finalCost[i] = tempSumTime * sumCostToN;
            for (int j = n - 2; j >= i; j--) {
                tempSumTime -= jobs[j + 1].time;
                finalCost[i] = Math.min(tempSumTime * sumCostToN + finalCost[j + 1], finalCost[i]);
            }
        }
        System.out.println(finalCost[0]);
    }
}

class Job {
    int time;
    int cost;
}