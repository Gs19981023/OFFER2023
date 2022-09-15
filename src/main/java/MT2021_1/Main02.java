package MT2021_1;

import java.util.Scanner;

/**
 * @ClassName Main02
 * @Description 用代金券最多的价值和最少的消耗，分别计算最大金额和需要花费的钱即可。
 * @Author GuoSheng
 * @Date 2022/8/22  21:32
 * @Version 1.0
 **/
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x,y;
        int nums = sc.nextInt();
        int value = 0;
        int cost = 0;
        for(int i = 0; i < nums; i++){
            String[] str = sc.nextLine().trim().split(" ");
            x = sc.nextInt();
            y = sc.nextInt();
            if(x >= y){
                value += x;
                cost += x - y;
            }else{
                value += y;
            }
        }
        System.out.println(value + " " + cost);
    }
}
