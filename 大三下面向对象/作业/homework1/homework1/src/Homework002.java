import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework002 {
    int num;
    int maxNum = 999999999;
    int million = 1000000;
    int thousand = 1000;
    int hundred = 100;
    int twenty = 20;
    int ten = 10;
    final String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety", "hundred", "thousand", "million"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Homework002 homework002 = new Homework002(scanner.nextInt());
        try {
            System.out.println(homework002.numToString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Homework002(int num) {
        this.num = num;
    }

    public String numToString() throws Exception {
        int tempNum = num < 0 ? -num : num;
        if (num>maxNum){
            throw new Exception("超过数据范围");
        }
        boolean continueTag = false;
        StringBuilder outputStr = new StringBuilder();
        if (num < 0) {
            outputStr.append("negative ");
        }
        if (tempNum > million) {
            continueTag = true;
            outputStr.append(threeNumToString(tempNum / million));
            outputStr.append(" million");
            tempNum %= million;
        }
        if (tempNum > thousand) {
            if (continueTag) {
                outputStr.append(" ");
            }
            continueTag = true;
            outputStr.append(threeNumToString(tempNum / thousand));
            outputStr.append(" thousand");
            tempNum %= 1000;
        }
        if (tempNum > 0) {
            if (continueTag) {
                outputStr.append(" ");
            }
            outputStr.append(threeNumToString(tempNum));
        }
        return outputStr.toString();
    }

    private StringBuffer threeNumToString(int n) {
        StringBuffer result = new StringBuffer();
        boolean continueTag = false;
        if (n >= hundred) {
            continueTag = true;
            result.append(numbers[n / hundred]);
            result.append(" hundred");
            n %= hundred;
        }
        if (n >= twenty) {
            if (continueTag) {
                result.append(" ");
            }
            continueTag = true;
            result.append(numbers[n / 10 + 18]);
            n %= 10;
            if (n > 0) {
                result.append(" ");
                result.append(numbers[n]);
            }
        } else if (n >= ten) {
            if (continueTag) {
                result.append(" ");
            }
            result.append(numbers[n]);
        }
        if (n > 0) {
            if (continueTag) {
                result.append(" ");
            }
            result.append(numbers[n]);
        }
        return result;
    }
}