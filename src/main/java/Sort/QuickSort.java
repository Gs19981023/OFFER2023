package Sort;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 快速排序
 * 解题思路
 * @Author GuoSheng
 * @Date 2022/9/12  12:19
 * @Version 1.0
 **/
public class QuickSort {
    public static void main(String[] args) throws IOException {
        //int a[]={50,1,12,2};
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        QuickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }


    public static void QuickSort(int[] nums,int low, int high) {
        int i,j;
        if(low > high) return;
        i = low;
        j = high;
        int temp = nums[low];
        while(i < j){
            while(nums[j] >= temp &&  i < j){
                j--;
            }
            while(nums[i] <= temp && i < j){
                i++;
            }
            if(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;

        QuickSort(nums,low,i - 1);
        QuickSort(nums,i + 1,high);
    }

}
