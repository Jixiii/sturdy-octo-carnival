import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework004 {
    public static final char MY_CHAR = 'Q';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        int n = scanner.nextInt();
        try {
            myPrint(type, n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void myPrint(String type, int n) throws Exception {
        if (n == 1) {
            System.out.println(MY_CHAR);
            return;
        }
        System.out.print(MY_CHAR);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(" " + MY_CHAR);
        }
        System.out.println();
        switch (type) {
            case "a" -> myPrintA(n);
            case "b" -> myPrintB(n);
            case "c" -> myPrintC(n);
            case "d" -> myPrintD(n);
            case "e" -> myPrintE(n);
            default -> throw new Exception("非法输入");
        }
        System.out.print(MY_CHAR);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(" " + MY_CHAR);
        }
        System.out.println();
    }

    public static void myPrintA(int n) {
        for (int i = 0; i < n - 2; i++) {
            System.out.print(MY_CHAR);
            for (int j = 0; j < 2 * n - 3; j++) {
                System.out.print(" ");
            }
            System.out.print(MY_CHAR);
            System.out.println();
        }
    }

    public static void myPrintB(int n) {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            System.out.println(MY_CHAR);
        }
    }

    public static void myPrintC(int n) {
        for (int i = n - 2; i >= 1; i--) {
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            System.out.println(MY_CHAR);
        }
    }

    public static void myPrintD(int n) {
        for (int i = 1; i < (n - 1) >> 1; i++) {
            myPrintD01(n, i);
        }
//        奇偶数处理
        if (n % 2 == 1) {
            for (int i = 0; i < n - 1; i++) {
                System.out.print(" ");
            }
            System.out.println(MY_CHAR);
        } else {
            for (int i = 0; i < n - 2; i++) {
                System.out.print(" ");
            }
            System.out.println(MY_CHAR + " " + MY_CHAR);
            for (int i = 0; i < n - 2; i++) {
                System.out.print(" ");
            }
            System.out.println(MY_CHAR + " " + MY_CHAR);
        }
        for (int i = ((n - 1) >> 1) - 1; i >= 1; i--) {
            myPrintD01(n, i);
        }
    }

    private static void myPrintD01(int n, int i) {
        for (int j = 0; j < 2 * i; j++) {
            System.out.print(" ");
        }
        System.out.print(MY_CHAR);
        for (int j = 0; j < 2 * n - 4 * i - 3; j++) {
            System.out.print(" ");
        }
        System.out.println(MY_CHAR);
    }

    public static void myPrintE(int n) {
        for (int i = 1; i < (n - 1) >> 1; i++) {
            myPrintE01(n, i);
        }
        if (n % 2 == 1) {
            System.out.print(MY_CHAR);
            for (int i = 1; i < n - 1; i++) {
                System.out.print(" ");
            }
            System.out.print(MY_CHAR);
            for (int i = 1; i < n - 1; i++) {
                System.out.print(" ");
            }
            System.out.println(MY_CHAR);
        } else {
            myPrintE02(n);
            myPrintE02(n);
        }
        for (int i = ((n - 1) >> 1) - 1; i >= 1; i--) {
            myPrintE01(n, i);
        }
    }

    private static void myPrintE02(int n) {
        System.out.print(MY_CHAR);
        for (int i = 1; i < n - 2; i++) {
            System.out.print(" ");
        }
        System.out.print(MY_CHAR + " " + MY_CHAR);
        for (int i = 1; i < n - 2; i++) {
            System.out.print(" ");
        }
        System.out.println(MY_CHAR);
    }

    private static void myPrintE01(int n, int i) {
        System.out.print(MY_CHAR);
        for (int j = 1; j < 2 * i; j++) {
            System.out.print(" ");
        }
        System.out.print(MY_CHAR);
        for (int j = 0; j < 2 * n - 4 * i - 3; j++) {
            System.out.print(" ");
        }
        System.out.print(MY_CHAR);
        for (int j = 1; j < 2 * i; j++) {
            System.out.print(" ");
        }
        System.out.println(MY_CHAR);
    }
}