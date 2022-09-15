package Offer2023.keep0830;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 快速排序，二分法，进行两两对换O(nlogn)
 * @Author GuoSheng
 * 1.选定mid中心轴
 * 2.将大于mid的数字放在mid的右边
 * 3.将小于mid的数字放在mid左边
 * 4.分别递归左右区域进行操纵
 * @Date 2022/8/30  22:11
 * @Version 1.0
 **/
public class QuickSort {
    public static void main(String[] args) {//int a[]={50,1,12,2};
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        QuickSort2(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }
    public static void QuickSort1(int[] nums, int left, int right){
        int l = left;
        int r = right;
        if(l > r) return;
        // 每次选择最左面的为mid中心轴
        int temp = nums[l];
        while(l < r){
            while(temp <= nums[r] && l < r){
                r--;
            }
            while(temp >= nums[l] && l < r){
                l++;
            }
            // 此时的nums[r] < temp，nums[l] > temp,所以将这俩数据互换即可。
            // l，r下标数据元素互换
            if(l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        // 遍历完之后，将mid中心轴移动到他应该在的位置上，然后将整个数组继续分割为两个部分。
        nums[left] = nums[l];
        nums[l] = temp;
        // 左半部分递归
        QuickSort1(nums,left,l - 1);
        // 右半部分递归
        QuickSort1(nums,l + 1,right);
    }


    public static void QuickSort2(int[] nums, int left, int right){
        if(left > right) return;
        int l = left, r = right;
        int mid = nums[l];
        //先从右边开始往左递减，找到比temp小的值才停止
        // 一定是先从右往左，再从左往右哦！！！！！！
        while(l < r){
            while(nums[r] >= mid && l < r){
                r--;
            }
            while(nums[l] <= mid && l < r){
                l++;
            }

            if(l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        nums[left] = nums[l];
        nums[l] = mid;
        QuickSort2(nums, left, l - 1);
        QuickSort2(nums, l + 1, right);
    }
}
