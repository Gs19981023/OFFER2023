package Sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description 归并排序
 * @Author GuoSheng
 * @Date 2022/9/15  13:55
 * @Version 1.0
 **/
public class MergeSort {
    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        int temp[]=new int[a.length];
        mergesort(a,0,a.length-1,temp);
        System.out.println(Arrays.toString(a));
    }

    private static void mergesort(int[] nums, int left, int right, int[] temp) {
        if(left < right){
            // 先分解再合并
            int mid = (right + left) / 2;
            //向左递归进行分解
            mergesort(nums, left, mid, temp);
            //向右递归进行分解
            mergesort(nums, mid+1, right, temp);
            //每分解一次便合并一次
            merge(nums,left,right,mid,temp);
        }
    }

    /**
     *
     * @param nums  待排序的数组
     * @param left  左边有序序列的初始索引
     * @param right 右边有序序列的初始索引
     * @param mid	中间索引
     * @param temp	做中转的数组
     */
    private static void merge(int[] nums, int left, int right, int mid, int[] temp) {
        int i=left; //初始i，左边有序序列的初始索引
        int j=mid+1;//初始化j，右边有序序列的初始索引（右边有序序列的初始位置即中间位置的后一位置）
        int t=0;//指向temp数组的当前索引，初始为0
        while(i <= mid && j <= right){
            if (nums[i] <= nums[j]) {
                temp[t] = nums[i];
                t++;//索引向后移
                i++;//i后移
            }else {
                //反之，将右边有序序列的当前元素填充到temp数组中
                temp[t] = nums[j];
                t++;//索引向后移
                j++;//j后移
            }

        }
        while(i <= mid){
            temp[t] = nums[i];
            t++; i++;
        }
        while(j <= right){
            temp[t] = nums[j];
            j++; t++;
        }
        //将temp数组的元素复制到原数组
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            nums[tempLeft] = temp[t];
            t++; tempLeft++;
        }
    }

}
