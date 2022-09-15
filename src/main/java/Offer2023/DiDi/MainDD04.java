package Offer2023.DiDi;

import java.util.Scanner;

/**
 * @ClassName MianDD04
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/4  20:30
 * @Version 1.0
 **/
public class MainDD04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[3][N];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < N; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < N; i++){
            System.out.print(get(nums[0][i],nums[1][i],nums[2][i]));
            if(i == N - 1){
                continue;
            }
            System.out.print(" ");
        }
    }
    public static int get(int left,int right,int k){
        int sum = 0;
        for(int i = left; i <= right; i++){
            if(getR(i,k)){
                sum++;
            }
        }
        return sum;
    }

    private static boolean getR(int num, int k) {
        String s = num + "";
        int sum = Integer.valueOf(s.charAt(0) + "");
        for(int i = 1; i < s.length();i++){
            sum ^= Integer.valueOf(s.charAt(i) + "");
        }
        if(sum == k) return true;
        return false;
    }
}
