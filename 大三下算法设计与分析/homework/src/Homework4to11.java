import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework4to11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int deleteDigits = scanner.nextInt();
        System.out.println(minNumber(number, deleteDigits));
    }

    public static String minNumber(String number, int deleteDigits) {
        StringBuilder num = new StringBuilder(number);
        int deleteTimes = 0;
        for (int i = 1; i < num.length(); ) {
            if (num.charAt(i - 1) > num.charAt(i)) {
                num.deleteCharAt(i - 1);
                deleteTimes++;
                if (i != 1) {
                    i--;
                }
                if (deleteTimes == deleteDigits) {
                    return num.toString();
                }
            } else {
                i++;
            }
        }
        return num.substring(0, num.length() - deleteDigits + deleteTimes);
    }
}
