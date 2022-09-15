package Help.ZX;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName Main02ZX
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/1  19:37
 * @Version 1.0
 **/
public class Main02ZX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[6];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxProfit(nums));

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];     // 创建二维数组存储状态
        // 第一列用于存储当前手头没有货物的情况
        // 第二列用于存储，当前手头有货的情况
        dp[0][0] = 0;                   // 初始状态
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 第 i 天，手头没货
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 第 i 天，手头有货
        }
        return dp[n - 1][0];    // 最后到达容量后手头肯定没货了
    }
    @Test
    public void test(){
        String s1 = "123";
        String s2 = "123";  // 在常量池中
        String s3 = new String("123");   // 新建一个对象在java JMM的堆内存中
        String s4 = new String("123");   // 新建一个对象在java JMM的堆内存中
        System.out.println(s1 == s2);   // true  两个在常量池
        System.out.println(s1 == s3);   // false 一个在常量池，一个在堆中
        System.out.println(s3 == s4);   // false 在堆内有两个地址
    }
    @Test
    public void test1(){
        Random r = new Random();
        int randomInt = r.nextInt(200) + 1;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("输入");
            int s = sc.nextInt();
            if(s < randomInt){
                System.out.println("小了");
            }else if(s > randomInt){
                System.out.println("大了");
            }else {
                System.out.println("对了");
                break;
                }
            }
        }

}
