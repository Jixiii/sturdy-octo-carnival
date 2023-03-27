import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework2to3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long startTime;
        long endTime;
        while (n != 0) {
            //获取开始时间
            startTime = System.currentTimeMillis();
            System.out.print(halfSetNumber01(n));
            //获取结束时间
            endTime = System.currentTimeMillis();
            //输出程序运行时间
            System.out.println(" 程序运行时间：" + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();
            System.out.print(halfSetNumber02(n));
            endTime = System.currentTimeMillis();
            System.out.println(" 程序运行时间：" + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();
            System.out.print(halfSetNumber03(n));
            endTime = System.currentTimeMillis();
            System.out.println(" 程序运行时间：" + (endTime - startTime) + "ms");

            n=scanner.nextInt();
        }
    }

    static long halfSetNumber01(int n) {
        long result = 1L;
        for (int i = 1; i <= n / 2; i++) {
            result += halfSetNumber01(i);
        }
        return result;
    }


    static long halfSetNumber02(int n) {
        long[] halfSet02 = new long[n];
        halfSet02[0] = 1L;
        return halfSetNumber02(n, halfSet02);
    }

    static long halfSetNumber02(int n, long[] halfSet02) {
        if (halfSet02[n-1]>0){
            return halfSet02[n-1];
        }
        long result = 1L;
        for (int i = 1; i <= n / 2; i++) {
            result += halfSetNumber02(i, halfSet02);
        }
        halfSet02[n - 1] = result;
        return result;
    }

    static long halfSetNumber03(int n) {
        long[] halfSet03 = new long[n+1];
        for (int i = 0; i <= n/2; i++) {
            halfSet03[i] = 1L;
        }
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i * 2; j <= n; j++) {
                halfSet03[j]+=halfSet03[i];
            }
        }
        return halfSet03[n]+1;
    }
}
