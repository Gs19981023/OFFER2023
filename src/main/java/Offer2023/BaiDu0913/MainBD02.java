package Offer2023.BaiDu0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName MainBD01
 * @Description 小红打怪
 * @Author GuoSheng
 * @Date 2022/9/13  18:55
 * @Version 1.0
 **/
public class MainBD02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] params = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(params[i]);
        }
        while(br.readLine().equals(" ")){}
        int[] dp = new int[n + 1];
        dp[0] = 0;// 打0个怪兽需要消耗的mp值
        int ansMp = 0;
        for(int i = 0; i < n; i++){
            if(i + 3 > n){
                break;
            }else{
                while(nums[i] >= 1){
                    int a1 = nums[i];
                    int a2 = nums[i + 1];
                    int a3 = nums[i + 2];
                    if(a1 >= 1 && a2 >= 2 && a3 >= 3){
                        ansMp += 5;
                        nums[i] -= 1;
                        nums[i + 1] -= 2;
                        nums[i + 2] -= 3;
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            ansMp += nums[i];
        }
        System.out.println(ansMp);
    }
}
