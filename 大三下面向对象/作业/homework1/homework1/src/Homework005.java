import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework005 {
    public int[] nums = new int[10];
    public char myChar = '*';
    public String[] horizontalRanges = new String[]{" 0 -  9: ", "10 - 19: ", "20 - 29: ",
            "30 - 39: ", "40 - 49: ", "50 - 59: ", "60 - 69: ", "70 - 79: ", "80 - 89: ", "90 -100: "};
    public String[] verticalRanges = new String[]{"0 - 9  ", " 10 - 19 ", " 20 - 29 ",
            " 30 - 39 ", " 40 - 49 ", " 50 - 59 ", " 60 - 69 ", " 70 - 79 ", " 80 - 89 ", " 90 - 100"};

    public static void main(String[] args) {
        Homework005 work = new Homework005();
        try {
            work.initializeNums(Objects.requireNonNull(readTxtFile("homework005.txt")));
            Scanner scanner = new Scanner(System.in);
            int type = scanner.nextInt();
            if (type==1) {
                work.horizontalPrint();
            } else {
                work.verticalPrint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void horizontalPrint() {
        for (int i = 0; i < 10; i++) {
            System.out.print(horizontalRanges[i]);
            for (int j = 0; j < nums[i]; j++) {
                System.out.print(myChar);
            }
            System.out.println();
        }
    }

    public void verticalPrint() {
        int maxLine = 0;
        for (int i = 0; i < 10; i++) {
            if (maxLine <= nums[i]) {
                maxLine = nums[i];
            }
        }
        boolean[][] hasChar = new boolean[10][maxLine];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                hasChar[i][j] = true;
            }
        }
        for (int i = maxLine - 1; i >= 0; i--) {
            System.out.print("  ");
            for (int j = 0; j < 10; j++) {
                if (hasChar[j][i]) {
                    System.out.print(myChar);
                } else {
                    System.out.print(" ");
                }
                System.out.print("        ");
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(verticalRanges[i]);
        }
    }

    public void initializeNums(StringBuffer str) throws Exception {
        for (int i = 0; i < str.length(); i++) {
            int num = 0;
            while (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num *= 10;
                num += str.charAt(i) - '0';
                i++;
            }
            if (num > 100) {
                throw new Exception("输入数据超过100");
            }
            if (num == 100) {
                nums[9]++;
            } else {
                nums[num / 10]++;
            }
        }
    }

    public static StringBuffer readTxtFile(String filePath) {
        try {
            StringBuffer str = new StringBuffer();
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
                    str.append(" ");
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
            return str;
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return null;
    }
}