package Offer2023.XHSTest0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MainXHS02
 * @Description 法术
 * @Author GuoSheng
 * @Date 2022/8/28  15:53
 * @Version 1.0
 **/
public class MainXHS02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int n = Integer.parseInt(one[0]);
        int k = Integer.parseInt(one[1]);
        String[] params = br.readLine().split(" ");
        int ans = 0;
        int[] nums = new int[params.length];
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int l = 0; l < nums.length; l++){
            nums[l] = Integer.parseInt(params[l]);
            if(!set.contains(nums[l])){
                list.add(nums[l]);
            }
        }
        int listSize = list.size();
        for(int i = 0; i < listSize; i++){
            for(int j = i + 1; j < listSize; j++){
                if(nums[i] * nums[j] >= k){
                    ans++;
                }
            }
        }
        System.out.println(ans * 2);
    }
}
