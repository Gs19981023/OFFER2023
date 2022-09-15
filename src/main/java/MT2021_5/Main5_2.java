package MT2021_5;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * @ClassName Main5_2
 * @Description 异或元素求和
 * i，j的余数进行异或的规律
 * 在遍历出i%j的余数规律后发现，对角线上全部为1，对于第i列，在主对角线上的元素有i个元素，所以这个模式能重复n/i次，
 * 如果重复的次数是偶数次，那么循环异或(0~i - 1)完就为0了，剩下的n % i个数再异或就得到这一列的异或结果；
 * 如果重复的次数是奇数，那么循环偶数次异或(0~i - 1)完就为0了，还余下一次0~i-1的异或 和 1~n%i的异或
 * 再进行异或操作即可
 * （1）如果n / i 为偶数，异或的结果1 ^ 2 ^ ... ^ (n % i);
 * （2）如果n / i 为奇数，异或的结果为 1 ^ 2 ^ ... ^ (n % i) ^ (0 ^ 1 ^ 2 ^ .. ^ i - 1)
 * @Author GuoSheng
 * @Date 2022/8/26  22:03
 * @Version 1.0
 **/
public class Main5_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        int[] multi = new int[n + 1]; // multi[i]表示 0 ^ 1 ^ 2 ^ ... ^ i;
        int res = 0;
        String[] param = br.readLine().split(" ");
        for (int i = 1; i <= param.length; i++) {
            nums[i] = Integer.parseInt(param[i]);
            res ^= nums[i];     // nums数组进行异或
            multi[i] = multi[i - 1] ^ i;
        }
        for(int i = 1; i <= n; i++){
            if((n / i) % 2 == 0){
                res ^= multi[n % i];
            }else{
                res ^= multi[n % i] ^ multi[i - 1];
            }
        }

    }


    @Test
    public void test(){
        String s1 = "ABCD";
        String s2 = "DBCA";
//        System.out.println(s1 > s2);
    }
}
