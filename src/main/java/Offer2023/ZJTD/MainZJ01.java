import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName MainZJ01
 * @Description 松鼠藏果干
 *
 * @Author GuoSheng
 * @Date 2022/8/28  09:59
 * @Version 1.0
 **/
public class MainZJ01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[params.length];
        for(int i = 0; i < params.length; i++){
            nums[i] = Integer.parseInt(params[i]);
        }
        boolean boResult = isValid(nums,n);
        int ans = getLastValue(nums,n);
        System.out.println(boResult);
        System.out.println(ans);

    }

    // 校验输入是否合法
    public static boolean isValid(int[] nums, int n){
        if(n < 0) return false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 5 || nums[i] < -1){
                return false;
            }
            if(nums[i] == -1){
                int j = i + 1;
                int left = 2 * j - 1;
                int right = left + 1;
                if((left < nums.length && nums[left] != -1)
                || (right < nums.length && nums[right] != -1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static int getLastValue(int[] nums,int n){
        int number = 0;
        int max = 5;
        int last = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == -1) continue;
            number += (max - nums[i]);
        }
        last = max - number;
        if(last > 0) return last;
        return 0;
    }
}
