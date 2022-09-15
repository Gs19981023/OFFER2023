package Offer2023.MT;

/**
 * @ClassName Main2
 * @Description 长城数组:分别找出奇数位置和偶数位置的最大值，然后将所有的奇数位和偶数位对齐到这两个值即可
 * 注意奇数偶数位最大值相同的情况
 * @Author GuoSheng
 * @Date 2022/8/21  23:10
 * @Version 1.0
 **/
// 长城数组
public class Main2 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,1,3,5,6,7,2,1};
        int oddMax = 0;
        int newMAX = 0;
        int n = nums.length;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            // 奇数最大值
            if((i & 1) == 0){
                oddMax = Math.max(oddMax, nums[i]);
            }else{
                newMAX = Math.max(newMAX, nums[i]);
            }
        }
        for(int i = 0;i < n; i++){
            if((i & 1) == 0){
                res += oddMax - nums[i];
            }else{
                res += newMAX - nums[i];
            }
        }
        if(oddMax == newMAX){
            res += n / 2;
        }
        System.out.println(res);

    }
}
