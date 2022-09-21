

import java.util.Scanner;

/**
 * @ClassName MainBS04
 * @Description 买卖股票最佳时机
 * @Author GuoSheng
 * @Date 2022/9/21  14:41
 * @Version 1.0
 **/
public class MainBS04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[5];
        dp[1] = -arr[0];
        dp[3] = -arr[0];
        for(int i = 1; i < n; i++){
            dp[1] = Math.max(dp[1],dp[0] - arr[i]);
            dp[2] = Math.max(dp[2],dp[1] + arr[i]);
            dp[3] = Math.max(dp[3],dp[2] - arr[i]);
            dp[4] = Math.max(dp[4],dp[3] + arr[i]);
        }
        System.out.println(dp[4]);
    }

}
