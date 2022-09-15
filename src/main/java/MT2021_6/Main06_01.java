package MT2021_6;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @ClassName Main06_01
 * @Description 小美的装饰物
 * 寻找连续的大于k的最多购买方案
 * 思路：寻找子串个数，
 *
 * 学习点：小根堆 + 滑动窗口 + 滑动窗口边界问题
 * 滑动窗口求解，如果堆顶元素大于等于k，方案数就+1；每次滑动窗口时将原来的左边界元素弹出，新的右边界压入
 * @Author GuoSheng
 * @Date 2022/8/30  00:26
 * @Version 1.0
 **/
public class Main06_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        String[] param = br.readLine().split(" ");
        int[] pretty = new int[n];
        for (int i = 0; i < param.length; i++) {
            pretty[i] = Integer.parseInt(param[i]);
        }
        int count = 0;
        PriorityQueue<Integer> window = new PriorityQueue<>();

        for(int left = 0; left <= n - m; left++){
            if(left == 0){
                for(int i = left; i < left + m - 1; i++){
                    window.offer(pretty[i]);
                }
            }else{
                window.remove(pretty[left - 1]);
                window.offer(pretty[left + m - 1]);
            }
            if(window.peek() >= k) count++;
        }
        System.out.println(count);

    }
    @Test
    public void test(){
        PriorityQueue<Integer> window = new PriorityQueue<>();
        window.offer(5);
        window.offer(8);
        window.offer(7);
        window.offer(3);

        window.offer(1);

        while(!window.isEmpty()){
            System.out.println(window.poll());
        }
    }

}
