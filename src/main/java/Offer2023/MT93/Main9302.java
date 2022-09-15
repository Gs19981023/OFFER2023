package Offer2023.MT93;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName Main9302
 * @Description MEX，求子集里的最小不存在集合的数
 *
 * @Author GuoSheng
 * @Date 2022/9/3  10:20
 * @Version 1.0
 **/
public class Main9302 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list.add(Integer.valueOf(s[i]));
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            Integer integer = list.removeFirst();
            ans[i] = getMin(list);
            list.add(integer);
        }
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
    public static int getMin(List<Integer> list){
        int min = 0;
        Set<Integer> set = new HashSet<>();
        for (Integer integer : list) {
            set.add(integer);
        }
        while(set.contains(min)){
            min++;
        }
        return min;
    }
}
