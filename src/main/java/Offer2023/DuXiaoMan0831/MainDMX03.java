package Offer2023.DuXiaoMan0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName MainDMX03
 * @Description 有效DNA复制
 *
 * @Author GuoSheng
 * @Date 2022/8/31  20:08
 * @Version 1.0
 **/
public class MainDMX03 {
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp = 2 * n - 3;
        long T1 = (long)Math.pow(9, n);
        long T2 = (long)(Math.pow(9, n - 2) * temp - n + 1);
        int ans = (int)(T1 - T2) % mod;
        System.out.println(ans);

    }


//    public static int result(int n){
//        int ans = 0;
//        if(n == 1){
//            ans = 9;
//        }else if(n == 2){
//            ans = 80;
//        }else{
//            long[] dp0 = new long[n + 1];
//            long[] dp1 = new long[n + 1];
//            dp0[1] = 9;
//            dp0[2] = 72;
//            dp1[1] = 1;
//            dp1[2] = 8;
//            for(int i = 0; i <= n; i++){
//                dp0[i] = 8 * (dp0[i - 1] + dp1[i - 1]);
//            }
//
//        }
//    }

}
