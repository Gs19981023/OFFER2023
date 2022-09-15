package Offer2023.MT93;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main9303
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/3  10:45
 * @Version 1.0
 **/
public class Main9303 {
    static int[] cities;
    static int[] notChangeMoney;
    static int[] changeMoney;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        n = Integer.parseInt(one[0]);   // 城市数
        int m = Integer.parseInt(one[1]);   // 总天数
        int k = Integer.parseInt(one[2]);   // 初始 所在城市
        cities = new int[m];
        notChangeMoney = new int[m];
        changeMoney = new int[m];
        String[] cityStr = br.readLine().split(" ");
        String[] notChangeStr = br.readLine().split(" ");
        String[] changeStr = br.readLine().split(" ");
        for (int i = 0; i < cityStr.length; i++) {
            cities[i] = Integer.parseInt(cityStr[i]);
        }
        for (int i = 0; i < notChangeStr.length; i++) {
            notChangeMoney[i] = Integer.parseInt(notChangeStr[i]);
        }
        for (int i = 0; i < changeStr.length; i++) {
            changeMoney[i] = Integer.parseInt(changeStr[i]);
        }

        int[][] dp = new int[n][2];
        int nowPoint = k;
        // 最后一个维度为0代表，当天选择放弃这个任务
        // 最后一个维度为1代表， 当天完成这个任务
        dp[0][0] = 0;
        dp[0][1] = Math.max(notChangeMoney[0],changeMoney[0]);
//        dp[0][1]
        get(dp,nowPoint,0,1);
        System.out.println(Math.max(dp[n - 1][0],dp[n - 1][1]));

    }
    public static void get(int[][] dp, int nowPoint,int idx,int dayIdx){
        if(dayIdx == n) return;
        if(nowPoint == cities[idx]){
            dp[dayIdx][0] = Math.max(dp[dayIdx - 1][0],dp[dayIdx][0]);
            dp[dayIdx][1] = Math.max(dp[dayIdx - 1][0],dp[dayIdx - 1][1]) + notChangeMoney[idx];
            get(dp,nowPoint,idx,dayIdx+1);
        }else{
            dp[dayIdx][0] = Math.max(dp[dayIdx - 1][0],dp[dayIdx][0]);
            dp[dayIdx][1] = Math.max(dp[dayIdx - 1][0],dp[dayIdx - 1][1]) + changeMoney[idx];
            get(dp,cities[idx],idx + 1,dayIdx+1);
        }
    }
}
