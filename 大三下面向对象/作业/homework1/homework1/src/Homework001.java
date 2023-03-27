import java.util.Scanner;

/**
 * @author 顾几希
 */
public class Homework001 {
    public static int totalLength = 12;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        while (inputStr.length() == 0) {
            inputStr = scanner.nextLine();
        }
        System.out.println(turnToUpc(inputStr));
    }

    public static String turnToUpc(String inputStr) {
        int[] nums = new int[12];
        try {
            input(inputStr, nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateUpc(nums);
        return printUpc(nums);
    }

    /**
    *输入数字*/
    private static void input(String inputStr, int[] nums) throws Exception {
//        判断输入位数
        int inputLength = 11;
        if (inputStr.length() > inputLength) {
            throw new Exception("超过11位");
        }
        for (int i = 0; i < inputStr.length(); i++) {
//            判断字符是否为数字
            if (inputStr.charAt(i) < '0' || inputStr.charAt(i) > '9') {
                throw new Exception("输入非数字:\"" + inputStr.charAt(i) + "\"");
            }
            nums[i + 11 - inputStr.length()] = inputStr.charAt(i) - '0';
        }
    }

    private static void updateUpc(int[] nums) {
        int sum = 0;
//        所有偶数位相加
        for (int i = 2; i < totalLength; i += 2) {
            sum += nums[i];
        }
        sum *= 3;
//        所有奇数位相加
        for (int i = 1; i < totalLength; i += 2) {
            sum += nums[i];
        }
//        计算d1
        if (sum == 0) {
            nums[11] = 0;
        } else {
            nums[11] = 10 - sum % 10;
        }
    }

    private static String printUpc(int[] nums) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < totalLength; i++) {
            str.append(nums[i]);
        }
        return str.toString();
    }
}