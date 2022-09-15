package Offer2023.ShunFeng0831;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName MainSF_01
 * @Description 猜排列游戏
 * @Author GuoSheng
 * @Date 2022/8/31  16:34
 * @Version 1.0
 **/
public class MainSF_01 {
    static List<List<Integer>> resList;
    static LinkedList<Integer> path;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        // int start = n - 1;
        // for(int i = 0; i < n; i++){
        //     count += start - i;
        // }
        for(int j = n; j >= 1; j--){
            count += (int)Math.floor(Math.log(j) / Math.log(2)) + 1;
        }
        System.out.println(count);
    }

    public static void DFS(int[] nums){
        if(path.size() == nums.length){
            resList.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            DFS(nums);
            // 回溯
            used[i] = false;
            path.removeLast();
        }
    }
    @Test
    public void test(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int start = n - 1;
//        for(int i = 0; i < n; i++){
//            count += start - i;
//        }
        int i = 0;
        int l = 0, r = n - 1;
        if(n % 2 == 0){
            while(l < r){
                count += r - l;
                l++;
                r--;
            }
        }
        System.out.println(count + 1);
    }
}
