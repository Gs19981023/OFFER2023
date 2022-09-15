package MT2021_1;

import java.awt.*;
import java.util.Scanner;

/**
 * @ClassName Main01
 * @Description 平均评分，只获取到小数点后1位
 * @Author GuoSheng
 * @Date 2022/8/22  18:53
 * @Version 1.0
 **/
public class Main01 {
    public static void main(String[] args) {
        int[] pingfen = new int[5];
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        for(int i = 0; i < 5; i++){
            pingfen[i] = Integer.parseInt(s[i]);
        }
        int sum = 0;
        int ci = 0;
        for(int i = 1; i <= 5; i++){
            sum += pingfen[i - 1] * i;
            ci += pingfen[i - 1];
        }
        double f = sum * 1.0 / ci;
        System.out.println(f);
        String s1 = String.valueOf(f);
        String res = sum * 1.0 / ci + "";
        System.out.println(res.substring(0,res.indexOf('.') + 2));
    }
}
