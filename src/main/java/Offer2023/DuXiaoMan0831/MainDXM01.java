package Offer2023.DuXiaoMan0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName MainDXM01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/31  19:06
 * @Version 1.0
 **/
public class MainDXM01 {
    static List<List<Integer>> resList;
    static LinkedList<Integer> path;
    static boolean[] used;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int n = Integer.parseInt(one[0]);
        int k = Integer.parseInt(one[1]);
        int[] nums = new int[n];
        String[] params = br.readLine().split(" ");
        for (int i = 0; i < params.length; i++) {
            nums[i] = Integer.parseInt(params[i]);
        }
        isOk(nums,k);
        System.out.println(ans);

    }

    public static void isOk(int[] nums, int k){
        for(int i = 0; i < nums.length; i++){
            int maxWei = nums[i];
            int minWei = nums[i];
            for(int j = i; j < nums.length; j++){
                minWei = Math.min(minWei, nums[j]);
                maxWei = Math.max(maxWei,nums[j]);
                if(maxWei / k == minWei) ans++;
            }

        }
    }

    public static void DFS(int[] nums, int startIdx){
        resList.add(new ArrayList<>(path));
        if(startIdx > nums.length) return;
        for(int i = startIdx; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            DFS(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
