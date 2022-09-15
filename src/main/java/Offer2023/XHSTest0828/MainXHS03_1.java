package Offer2023.XHSTest0828;

import java.util.*;

/**
 * @ClassName MainXHS03
 * @Description
 *
 * @Author GuoSheng
 * @Date 2022/8/28  15:53
 * @Version 1.0
 **/
public class MainXHS03_1 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] peoples = new int[n - 1];
        int[] arr = new int[n - 1];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n - 1; i++){
            peoples[i] = sc.nextInt();
            arr[i] = i + 2;
        }
        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            if(!set.contains(peoples[i]) && !set.contains(arr[i])){
                set.add(peoples[i]);
                set.add(arr[i]);
                ans++;
            }
        }
        System.out.println(ans);
    }
}

