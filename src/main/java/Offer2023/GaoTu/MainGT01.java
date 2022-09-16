package Offer2023.GaoTu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName MainGT01
 * 高途第一次笔试
 * @Description 正则匹配题目
 * @Author GuoSheng
 * @Date 2022/9/16  19:07
 * @Version 1.0
 **/
public class MainGT01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        int n = str.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 0; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(pattern.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if(isOk(str,pattern,i,j)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }else{
                        if(isOk(str,pattern,i,j)){
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    private static boolean isOk(String s, String p, int i,int j) {
        if(i == 0) return false;
        if(p.charAt(j - 1) == '.') return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
