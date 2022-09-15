package Offer2023.DiDi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ClassName MainDD01
 * 滴滴第一题
 * @Description 桃子装箱
 * @Author GuoSheng
 * @Date 2022/9/4  18:16
 * @Version 1.0
 **/
public class MainDD01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int n = Integer.parseInt(one[0]);
        int k = Integer.parseInt(one[1]);
        String[] taoZi = br.readLine().split(" ");
        int[] taoZiArr = new int[n];
        int allSum = 0;
        for (int i = 0; i < taoZi.length; i++) {
            taoZiArr[i] = Integer.parseInt(taoZi[i]);
            allSum += taoZiArr[i];
        }
        double allAvg = allSum * 1.0 / n;
        Arrays.sort(taoZiArr);
        int max = taoZiArr[n - 1];

        int ans = n;
        for(int i = n - 1; i > 0; i--){
            double tempAvg = allSum * 1.0 / (i + 1);
            if(taoZiArr[i] > tempAvg * k){
                allSum -= taoZiArr[i];
                ans--;
                continue;
            }
        }
        System.out.println(ans);


    }
}
