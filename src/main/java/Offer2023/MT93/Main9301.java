package Offer2023.MT93;

import java.util.Scanner;

/**
 * @ClassName Main9301
 * @Description 乒乓球
 * @Author GuoSheng
 * @Date 2022/9/3  10:02
 * @Version 1.0
 **/
public class Main9301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 0;
        while(a < b + 2){
            a++;
            ans++;
        }
        if(a < 11){
            ans += 11 - a;
        }
        System.out.println(ans);
    }
}
