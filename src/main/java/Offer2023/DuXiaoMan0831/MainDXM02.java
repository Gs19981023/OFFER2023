package Offer2023.DuXiaoMan0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName MainDXM02
 * @Description 路径
// 现在有一个n行m列的网格图。每个格子上有一个数字，为 +k 或者 -k。
// 初始你在位于左上方的第一行第一列，你的目标是走到位于右下方的第n行第m列。
// 现在限制你每一步只能向下或者向右走。显然，你有很多种实现目标的方法。
// 现在，我们定义路径的权值和为你选定的路径上所有格子上的数字的加和。
就是为最后到达终点的时候，是否有权值为x的情况，如果有就返回yes否则为no
 * @Author GuoSheng
 * @Date 2022/8/31  19:22
 * @Version 1.0
 **/
public class MainDXM02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String[] params = br.readLine().split(" ");
            int n = Integer.parseInt(params[0]);    // n行
            int m = Integer.parseInt(params[1]); // m列
            int k = Integer.parseInt(params[2]);
            int x = Integer.parseInt(params[3]);
            int[][] nums = new int[n][m];
            for(int l = 0; l < n; l++){
                String[] tempParam = br.readLine().split(" ");
                for (int c = 0; c < tempParam.length; c++) {
                    nums[l][c] = Integer.parseInt(tempParam[c]);
                }
            }
            boolean temp = helper(nums, x, 0, 0);
            System.out.println(temp ? "yes" :"no");

        }
    }

    private static boolean helper(int[][] nums, long target, int x, int y) {
        // 如果当前到了最末尾 的元素，且target 等于最后一个值了，返回true;
        if(x == nums.length - 1 && y == nums[0].length - 1 && target == nums[x][y]){
            return true;
        }
        target -= nums[x][y];
        // 当前步向右走一步
        if(x + 1 < nums.length && helper(nums,target, x + 1, y)){
            return true;
        }

        // 当前步向左走一步
        if(y + 1 < nums[0].length && helper(nums, target, x ,y + 1)){
            return true;
        }
        return false;
    }


}
