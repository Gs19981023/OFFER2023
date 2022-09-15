package Offer2023.T2_360_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main36001
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/9  14:59
 * @Version 1.0
 **/
public class Main36003 {
    static int maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int I = Integer.parseInt(br.readLine());
        for(int i = 0; i < I; i++){
            maxValue = 0;
            String[] one = br.readLine().split(" ");
            int n = Integer.parseInt(one[0]), m = Integer.parseInt(one[1]);
            int[][] nums = new int[n][m];
            int no = 0;
            for(int j = 0; j < n; j++){
                String[] params = br.readLine().split(" ");
                for (int i1 = 0; i1 < params.length; i1++) {
                    nums[j][i1] = Integer.parseInt(params[i1]);
                    if(nums[j][i1] == - 1) no++;
                }
            }
            if(no == n * m){
                System.out.println(0);
                break;
            }
            int[][] dp = new int[n][m];
            for(int j = 0; j < n; j++){
                for(int l = 0; l < m ;l++){
                    if(nums[j][l] >= 0){
                        if(j == 0 || l == 0){
                            dp[j][l] = nums[j][l];
                        }else{
                            dp[j][l] = Math.max(dp[j - 1][l] + nums[j][l],dp[j][l - 1] + nums[j][l]);
                        }
                        maxValue = Math.max(maxValue, dp[j][l]);
                    }
                }
            }

            System.out.println(maxValue);
            // 在这输出结果
        }
    }
}
