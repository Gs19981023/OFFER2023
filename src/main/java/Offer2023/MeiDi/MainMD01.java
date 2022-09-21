package Offer2023.MeiDi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName MainMD01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/21  20:49
 * @Version 1.0
 **/
public class MainMD01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] params = sc.nextLine().split(",");
        int n = params.length;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(params[i].trim());
        }
        Arrays.sort(nums);
        System.out.print("[");
        for(int i = 0; i < n - 1; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.print(nums[n - 1]);
        System.out.print("]");
    }

}
