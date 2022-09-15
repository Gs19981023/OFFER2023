package MT2021_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

/**
 * @ClassName Main02_04
 * @Description 派遣车辆，第i行可以选择派出到a地，或派出到b地
 * DP动态规划推导。
 * DP[a][b]
 * Dp[j][k]代表着当前派出j个车到a，k个车到b的最大利润
 * 背包问题的多维展现，一次派遣只能选择一辆或者选择不派遣，因此是01背包问题
 * 01背包问题是先遍历物品，再遍历容量，倒序遍历容量
 * @Author GuoSheng
 * @Date 2022/8/24  11:44
 * @Version 1.0
 **/
public class Main02_04 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        String[] params;
        int n = Integer.parseInt(one[0]);
        int a = Integer.parseInt(one[1]);
        int b = Integer.parseInt(one[2]);
        int x,y;
        int[][] dp = new int[a+1][b+1];
        for(int i = 1; i <=n; i++){
            params = br.readLine().split(" ");
            x = Integer.parseInt(params[0]);
            y = Integer.parseInt(params[1]);
            // i辆车中，有j量车去A点，有i - j辆车去B点
            for(int j = Math.min(a,i); j >= 0; j--){
                for(int k = Math.min(b,i - j); k >=0; k--){
                    if(j == 0 && k == 0) continue;
                    // b地车够了，a地继续派车或者不派车
                    if(k == 0){
                        dp[j][k] = Math.max(dp[j][k],dp[j - 1][k] + x);
                    }else if(j == 0){
                        dp[j][k] = Math.max(dp[j][k],dp[j][k - 1] + y);
                    }else{
                        dp[j][k] = Math.max(dp[i][j],Math.max((dp[j - 1][k] + x),(dp[j][k - 1] + y)));
                    }
                }
            }
        }
        System.out.println(dp[a][b]);

    }
}

class Node{
    public int a;
    public int b;
    public boolean choosed;
    public Node(int a, int b){
        this.a = a;
        this.b = b;
    }
}
