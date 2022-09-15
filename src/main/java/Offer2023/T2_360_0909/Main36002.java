package Offer2023.T2_360_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main36001
 * @Description 一日，小A走在路上时看到路边摆着一面大镜子。
 * 他对着这面镜子注视了半天，突然发现自己穿越到了另一个世界！
 *
 *    这个世界很奇怪：他所在的地方可视为一个n行m列的矩阵，
 *    每一个位置上都有一个非负整数或者-1。这时，他的耳边响起了一个很空灵的声音：
 *    “如果您想要回到原来的世界，你需要解决下面的问题：你需要在整个矩阵上选择一个正方形区域，
 *    使得该区域不包含任何负数，并且该区域内的数字之和最大。”
 *
 *    然而这个问题对于小A来说还是太难了，所以他请了你来帮忙解决这个问题。
 *    找到二维数组中的最大的正方形之和，且这个正方形中没有负数
 * @Author GuoSheng
 * @Date 2022/9/9  14:59
 * @Version 1.0
 **/
public class Main36002 {
    static int maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int I = Integer.parseInt(br.readLine());
        for(int i = 0; i < I; i++){
            maxValue = 0;
            String[] one = br.readLine().split(" ");
            int n = Integer.parseInt(one[0]), m = Integer.parseInt(one[1]);
            int[][] nums = new int[n][m];
            int no = 0;
            for(int j = 0; j < n; j++){
                String[] params = br.readLine().split(" ");
                for (int i1 = 0; i1 < params.length; i1++) {
                    nums[j][i1] = Integer.parseInt(params[i1]);
                    if(nums[j][i1] == - 1) no++;
                }
            }
            if(no == n * m){
                System.out.println(-1);
                break;
            }
            // 在这调用
            DFS(nums,0,0,1);
            System.out.println(maxValue);
            // 在这输出结果
        }
    }
    public static void DFS(int[][] nums, int x, int y,int bianChang){
        int high = nums.length;
        int width = nums[0].length;
        int sum = 0;
        boolean flag = false;
        if(x >= high || y >= width) return;
        if(x + bianChang >= high || y + bianChang >= width) return;
        for(int i = x; i < x + bianChang; i++){
            for(int j = y; j < y + bianChang; j++){
                if(nums[i][j] < 0){
                    flag = true;
                }
            }
        }
        if(flag){
            DFS(nums, x + 1, y ,bianChang);
            DFS(nums, x , y + 1, bianChang);
        }else{
            for(int i = x; i < x + bianChang; i++){
                for(int j = y; j < y + bianChang; j++){
                    sum += nums[i][j];
                }
            }
            maxValue = Math.max(sum,maxValue);
            DFS(nums, x , y , bianChang + 1);
        }
    }
}
