package MT2021_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main06_02
 * @Description 填数游戏
 * 输入 n （取和的结果） , k (填入的数字必须都小于等于k，大于等于1)，d（填入的数字最大值必须大于等于d）
 *
 * 动态规划
 * dp[i][j]
 * dp[i][0] 表示，凑出结果为i时，没有使用大于等于d的数的方案个数
 * dp[i][1] 表示，凑出结果为i，用了大于等于d的方案数
 * 背包容量n
 * @Author GuoSheng
 * @Date 2022/8/31  13:24
 * @Version 1.0
 **/
public class Main06_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int n = Integer.parseInt(one[0]);
        int k = Integer.parseInt(one[1]);
        int d = Integer.parseInt(one[2]);

        long[][] dp = new long[n + 1][2];
        // 拼凑出结果为0,0个大于k的数有一种拼凑方法
        dp[0][0] = 1L;

        //先遍历背包容量，再遍历物品
        for(int i = 1; i <= n; i++){
            // j为填充背包的物品，选择MIN是因为题目要求
            // 背包里的数字
            for(int j = 1; j <= Math.min(k,i); j++){
                // 如果当前这个数字小于要求的d
                // 更新背包，填满当前i的方法个数 = 不放当前元素且没有大于d的元素方案+不放当前元素有大于d的方案
                // 当 j < d，那么dp[i][0] 只能从没有大于d的呢一行进行转移
                // dp[i][1] 也只能从上一个i - j已经有大于的d的呢一行转移。
                if(j < d){
                    // 当前数字放进来后，不会有影响大于d的个数
                    dp[i][0] = (dp[i][0] + dp[i - j][0]) % 998244353;
                    dp[i][1] = (dp[i][1] + dp[i - j][1]) % 998244353;
                }else{
                    // 当前数字放进来后，会有影响大于d的个数，因此肯定是只在第二行放了
                    // 此时目标已达成，从dp[i - j]来的是否有大于d的要求已经无所谓了，因此把两个情况的上一状态也相加
                    dp[i][1] = (dp[i][1] + dp[i - j][0] + dp[i - j][1]) % 998244353;
                }
            }
        }
        System.out.println(dp[n][1]);
    }
}
