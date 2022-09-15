package Offer2023.YongYou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName MainYY01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/9  18:59
 * @Version 1.0
 **/
public class MainYY01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String next = "";
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        while(scanner.hasNext()){
            next = scanner.nextLine();
            path = new ArrayList<>();
            String[] params = next.split(",");
            for (String param : params) {
                path.add(Integer.parseInt(param));
            }
            list.add(path);
        }
        int[][] nums = new int[list.size()][list.get(0).size()];
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(0).size(); j++){
                nums[i][j] = list.get(i).get(j);
            }
        }
        System.out.println(getMax(nums));

    }

    public static int getMax(int[][] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i != nums.length; i++){
            for(int j = 0; j != nums[0].length; j++){
                max = Math.max(max,DFS(nums,i, j));
            }
        }
        return max;
    }

    public static int DFS(int[][] nums, int x, int y){
        if(x < 0 || y < 0 || x == nums.length || y == nums[0].length || nums[x][y] != 1) return 0;
        nums[x][y] = 0;
        int res = 1;
        int[] numX = {0, 0 ,1, -1};
        int[] numY = {1, -1, 0 , 0};
        for(int i = 0; i != 4; i++){
            int next_x = x + numX[i], next_y = y + numY[i];
            res += DFS(nums, next_x, next_y);
        }
        return res;
    }
}
