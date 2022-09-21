package Offer2023.BOSS;

import java.util.Scanner;

/**
 * @ClassName MainBS01
 * @Description 求最小公倍数
 * @Author GuoSheng
 * @Date 2022/9/21  14:27
 * @Version 1.0
 **/
public class MainBS01 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x1 = sc.nextInt();
//        int x2 = sc.nextInt();
//        int res = x1 * x2;
//        for(int i = 1; i < x1 * x2; i++){
//            if(i % x1 == 0 && i % x2 == 0){
//                res = i;
//                break;
//            }
//        }
//        System.out.println(res);
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int r;
        while((r = x1 % x2) != 0){
            x1 = x2;
            x2 = r;
        }
        System.out.println(r);
    }
}
