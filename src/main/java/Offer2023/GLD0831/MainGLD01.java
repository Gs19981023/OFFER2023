package Offer2023.GLD0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName MainGLD01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/31  21:25
 * @Version 1.0
 **/
public class MainGLD01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int[] fire = new int[n];
        int[] arrived = new int[n];
        String[] params1 = br.readLine().split(" ");
        String[] params2 = br.readLine().split(" ");
        for(int i = 0; i < params1.length; i++){
            fire[i] = Integer.parseInt(params1[i]);
        }
        for(int i = 0; i < params2.length; i++){
            arrived[i] = Integer.parseInt(params2[i]);
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(fire[i],i);
        }
        // 双指针进行比较，如果后面的排列顺序小于前面的排列顺序，就说明是有互换的。
        // 找到从i开始第一个比i排序小的数据后就跳出本次循环。
        // 如果不跳出循环会导致重复计算。
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(map.get(arrived[j]) <  map.get(arrived[i])){
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);


    }
}

