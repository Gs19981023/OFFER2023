package Offer2023.Wy0904;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName MainWY01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/4  15:05
 * @Version 1.0
 **/
public class MainWY01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = 0;
        int max = nums[n - 1];

        for (int num : nums) {
            if(num == max) {
                res++;
                continue;
            }
            while(num < max){
                num += k;
                if(num == max) res++;
            }
        }
        System.out.println(res);
        System.out.println(getMinNumber(nums,k));

    }
    public static int getMinNumber(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int now_max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            now_max = Math.max(nums[i], now_max);
        }
        return get1(nums, k, now_max);
    }

    // k > 0
    public static int get1(int[] nums, int k, int now_max) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int abc = (int) (Math.ceil((now_max - nums[i]) / (k * 1.0)));
            int def = nums[i] + abc * k;
            map.putIfAbsent(def, 0);
            int jump = map.get(def) + 1;
            map.put(def, jump);
            max = Math.max(max, jump);
        }
        // System.out.println(map);
        return max;
    }
}
