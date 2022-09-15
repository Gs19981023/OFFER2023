package MT2021_2;

import jdk.nashorn.api.scripting.ScriptUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @ClassName Main
 * @Description 不一样的逆序数,寻找在这个数字下面的所有的逆序数为当前的4倍数。
 * 枝剪方法：不要遍历从0到n，直接从2178遍历到n/4即可，可以大大降低时间复杂度
 * @Author GuoSheng
 * @Date 2022/8/23  22:24
 * @Version 1.0
 **/
public class Main02_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        if(n < 2178){
            System.out.println(0);
        }else{
            int num = 2178;
            int count = 0;
            ArrayList<String> res = new ArrayList<String>();

            while(num <= n / 4){ // 注意这里是n/4
                int reverNum = reverse(num);
                if(num * 4 == reverNum){
                    res.add(num + " " + reverNum);
                    count++;
                }
                num++;
            }
            System.out.println(res.size());
            for(int i = 0; i < res.size(); i++){
                System.out.println(res.get(i));
            }
        }
    }
    // 逆序
    public static int reverse(int num){
        int res = 0;
        while(num > 0){
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

}
