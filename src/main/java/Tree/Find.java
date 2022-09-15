package Tree;

import java.util.Arrays;

/**
 * @ClassName Find
 * @Description 二分查找插入位置
 * @Author GuoSheng
 * @Date 2022/9/15  18:07
 * @Version 1.0
 **/
public class Find {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,8,96,3,12,4,56};
        Arrays.sort(nums);
        int i = searchInsert(nums, 100);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(target <= nums[mid]){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
