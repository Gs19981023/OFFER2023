package Help.XHS0904;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName MainXHS9401
 * @Description 数组为7的倍数
 * @Author GuoSheng
 * @Date 2022/9/4  16:44
 * @Version 1.0
 **/
public class MainXHS9402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int idx7 = 0;
        Arrays.sort(nums);
        // 数组中和7最接近的数
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 7 == 0 && nums[i] != 0){
                idx7 = i;
                break;
            }
            minGap = Math.min(minGap , 7 - Math.abs(nums[i] % 7));

        }
        // 首先至少要有一个7

        System.out.println(getMinOpr(nums,idx7) + minGap);

    }
    public static int getMinOpr(int[] nums,int idx){
        int min = 0;
        // 当前数进行和7取余操作，取距离1和7的最近值。
        for(int i = 0; i < nums.length; i++){
            // 跳过和7最接近的第一个数
            if(idx == i) continue;
            int temp = nums[i];
            if(temp == 0){
                min++;
                continue;
            }
            if(temp % 7 == 0 || temp == 1) continue;
            temp = Math.abs(temp);
            if(temp > 0 && temp < 7){
                min += Math.min((7 - temp),(temp - 1));
            }else if(temp > 7){
                min += Math.min((7 - temp % 7),temp % 7);
            }
        }
        return min;
    }
}
