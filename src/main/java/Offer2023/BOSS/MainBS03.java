package Offer2023.BOSS;

import java.util.Scanner;

/**
 * @ClassName MainBS03
 * @Description 加分二叉树
 * @Author GuoSheng
 * @Date 2022/9/21  15:10
 * @Version 1.0
 **/
public class MainBS03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 30;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // 根节点的情况
        int[][] root = new int[max][max];
        // 最大得分
        int[][] dp = new int[max][max];

        for(int i = 1; i <= n; i++){
            // 根节点的值
            dp[i][i] = arr[i - 1];
            dp[i][i - 1] = 1;
            root[i][i] = i;
        }
        for(int len = 1; len < n; len++){
            for(int i = 1; i + len <= n; i++){
                int j = i + len;
                dp[i][j] = dp[i][i] + dp[i + 1][j];
                root[i][j] = i;
                for(int k = i + 1; k < j; k++){
                    if(dp[i][j] < dp[i][k - 1] * dp[k + 1][j] + dp[k][k]){
                        dp[i][j] = dp[i][k - 1] * dp[k + 1][j] + dp[k][k];
                        root[i][j] = k;
                    }
                }
            }
        }
        System.out.println(dp[1][n]);
        outPre(1,n,root);
    }

    public static void outPre(int l,int r,int[][] root){
        if(r < l) return;
        System.out.print(root[l][r] + " ");
        if(r == l) return;
        outPre(l, root[l][r] - 1,root);
        outPre(root[l][r] + 1,r,root);
    }
}
