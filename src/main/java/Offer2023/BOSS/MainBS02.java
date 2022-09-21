package Offer2023.BOSS;

import java.util.Scanner;

/**
 * @ClassName MainBS02
 * @Description 变换次数，注意是count的数字，最后要变为一个个位数。
 * @Author GuoSheng
 * @Date 2022/9/21  14:55
 * @Version 1.0
 **/
public class MainBS02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count = 0;
        long temp = 0;
        long tmp = 1;
        while(n > 9){
            temp = n;
            while(temp > 0){
                tmp *= temp % 10;
                temp /= 10;
            }
            count++;
            n = tmp;
            tmp = 1;
        }
        System.out.println(count);
    }
}
