package Help.XHS0904;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName MainXHS9401
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/4  16:44
 * @Version 1.0
 **/
public class MainXHS9401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[n];
        int[] revers = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            revers[n - 1 - i] = sc.nextInt();
        }

        for(int i = 0; i < m ;i++){

        }


    }
}
