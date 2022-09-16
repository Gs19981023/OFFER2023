package Offer2023.GaoTu;

import java.util.Scanner;

/**
 * @ClassName MainGT01
 * @Description 判断回文数
 * @Author GuoSheng
 * @Date 2022/9/16  19:07
 * @Version 1.0
 **/
public class MainGT02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = String.valueOf(n);

        System.out.println(isHuiWen(s));
    }

    private static boolean isHuiWen(String s) {
        int left = 0, right = s.length() - 1;
        boolean res = true;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                res = false;
                break;
            }
            left++;
            right--;
        }
        return res;
    }
}
