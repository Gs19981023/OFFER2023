package Offer2023.WanMeiWorld;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName MainWM01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/8  20:22
 * @Version 1.0
 **/
public class MainWM01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[][] nums = new int[][]{{2},{3, 4},{5,6,7},{4,1,8 ,3}};
        DFS(nums,0,0,0);
        System.out.println(max);

    }
    static int max = 0;
    public static void DFS(int[][] nums, int idx, int deep,int sum){
        // 到达最后一层
        if(deep == nums.length){
            max = Math.max(max, sum);
            return;
        }
        // 到达当前层的最右边
        if(idx >= nums[deep].length) return;
        // 往下到最底层
        DFS(nums, idx , deep + 1, sum + nums[deep][idx]);

        // 往右移动一步，再往下走一层
        DFS(nums, idx + 1 , deep + 1, sum + nums[deep][idx]);



    }
}
