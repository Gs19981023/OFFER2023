package Offer2023.T360;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main360_2
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/27  15:37
 * @Version 1.0
 **/
public class Main360_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] params = br.readLine().split(" ");
        int numsOfSplit = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(params[i]);
        }
        int[] splitNum = new int[numsOfSplit];
        for(int j = 0; j < numsOfSplit; j++){
            splitNum[j] = Integer.parseInt(splits[j]);
        }
        sort(nums,0,nums.length - 1);
        for(int o = 0; o < nums.length - 1; o++){
            System.out.print(o + " ");
        }
        System.out.print(nums[nums.length - 1]);


    }
    public static void sort(int[] nums,int low,int high){
        int i,j,temp,t;
        if(low > high){
            return;
        }
        i = low;
        j = high;
        temp = nums[low];
        while(i < j){
            while(temp <= nums[i] && i < j){
                j--;
            }
            while(temp >= nums[i] && i < j){
                i++;
            }
            if(i < j){
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        sort(nums, low, j - 1);
        sort(nums, j + 1, high);
    }
}
