package Offer2023.JDTest0829;

import java.util.Scanner;

/**
 * @ClassName MainJD_3
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/27  19:55
 * @Version 1.0
 **/
public class MainJD_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println();

    }
    public static int getRes(int n){
        if(n < 6) return 0;
        if(n == 6) return 1;
        int ans = 1;
        int index = 3;
        for(int i = 7; i <= n; i++){
            ans = ans + index * 26;
            ans = ans % 1000000007;
        }
        return ans;
    }
}
