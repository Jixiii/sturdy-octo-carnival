import java.util.HashMap;
import java.util.Scanner;

/**
 * @author IDK You Yet
 */
public class Homework2to1 {
    /*
    * 众数*/
    public static int mode;
    //重数
    public static int repeatTimes;

    //找到等于中间值元素的元素个数
    public static int midRepeatTimes(int[] arr, int left, int right) {
        int sum = 0;
        int mid = (left + right) >>> 1;
        int n = arr[mid];
        for (int i = left; i < right; i++) {
            if (arr[i] == n) {
                sum++;
            }
        }
        return sum;
    }

    //找出等于中间值元素的第一个元素下标
    public static int midFirstIndex(int[] arr, int left, int right) {
        int x = 0;
        int mid = (left + right) >>> 1;
        for (int i = left; i < right; i++) {
            if (arr[mid] == arr[i]) {
                x = i;
                break;
            }
        }
        return x;
    }

    public static void searchMode(int[] arr, int first, int last) {
//        等于中间值元素的元素个数
        int midRepeatTimes = midRepeatTimes(arr, first, last);
//        等于中间值元素的第一个元素下标
        int midFirstIndex = midFirstIndex(arr, first, last);
        if (midRepeatTimes > repeatTimes) {
            mode = arr[midFirstIndex];
            repeatTimes = midRepeatTimes;
        }
        if (midFirstIndex > repeatTimes) {
            searchMode(arr, first, midFirstIndex);
        }
        if ((last - midFirstIndex - midRepeatTimes) > repeatTimes) {
            searchMode(arr, midFirstIndex + midRepeatTimes, last);
        }
    }

    public static void searchMode01(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j : arr) {
            int count = hashMap.get(j) == null ? 1 : hashMap.get(j) + 1;
            hashMap.put(j, count);
        }
        int resultNum = 0;
        int times = 0;
        for (Integer num : hashMap.keySet()) {
            if (hashMap.get(num)>times){
                resultNum = num;
                times = hashMap.get(num);
            }
        }
        System.out.println(resultNum);
        System.out.println(times);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        searchMode01(arr);
        searchMode(arr, 0, n);
        System.out.println(mode);
        System.out.println(repeatTimes);
    }
}
