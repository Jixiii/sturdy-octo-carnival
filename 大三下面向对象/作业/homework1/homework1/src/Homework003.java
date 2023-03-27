import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfSubsequence = scanner.nextInt();
        try {
            Homework003.maximumProduct("homework0031.txt", lengthOfSubsequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void maximumProduct(String filePath, int lengthOfSubsequence) throws Exception {
        int max = 0;
        int firstIndex = 0;
        int tempProduct = 1;
        int tempIndex = 0;
        int numbers = 0;
        boolean allEqualTo0 = true;
        String str = readTxtFile(filePath);
        assert str != null;
        if (lengthOfSubsequence>=str.length()){
            throw new Exception("out of boundary");
        }
        for (; tempIndex < str.length(); tempIndex++) {
            int num = str.charAt(tempIndex) - '0';
            if (num>9||num<0){
                throw new Exception(str.charAt(tempIndex)+" is not a number");
            }
            if (num == 0) {
                tempProduct = 1;
                numbers = 0;
            } else {
                if (numbers < lengthOfSubsequence) {
                    tempProduct *= num;
                    numbers++;
                    if (tempProduct >= max && numbers == lengthOfSubsequence) {
                        max = tempProduct;
                        firstIndex = tempIndex - lengthOfSubsequence+1;
                    }
                } else {
                    allEqualTo0 = false;
                    tempProduct /= str.charAt(tempIndex - lengthOfSubsequence) - '0';
                    tempProduct *= num;
                    if (tempProduct >= max) {
                        max = tempProduct;
                        firstIndex = tempIndex - lengthOfSubsequence+1;
                    }
                }
            }
        }
        if (allEqualTo0(allEqualTo0)) {
            return;
        }
        if(tempProduct>=max){
            max = tempProduct;
            firstIndex = tempIndex-lengthOfSubsequence+1;
        }
        printResult(str,firstIndex,lengthOfSubsequence,max);

    }

    private static boolean allEqualTo0(boolean allEqualTo0) {
        if (allEqualTo0){
            System.out.println("All equal to 0");
            return true;
        }
        return false;
    }

    private static void printResult(String str,int firstIndex,int length,int max){
        System.out.print(max+"("+str.charAt(firstIndex));
        for (int i = 1; i < length; i++) {
            System.out.print("*");
            System.out.print(str.charAt(i+firstIndex));
        }
        System.out.println(")");
    }

    public static String readTxtFile(String filePath) {
        try {
            StringBuilder str = new StringBuilder();
            String encoding = "GBK";
            File file = new File(filePath);
            //判断文件是否存在
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        //考虑到编码格式
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    str.append(lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
            return str.toString();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return null;
    }
}