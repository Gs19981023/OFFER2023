package Offer2023.MeiDi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName MainMD01
 * @Description 字符串全新排序
 * @Author GuoSheng
 * @Date 2022/9/21  20:49
 * @Version 1.0
 **/
public class MainMD02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] params = sc.nextLine().split(",");
        Integer n = params.length;
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(params[i].trim());
        }
        Arrays.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                long l1 = Long.parseLong(s1);
                long l2 = Long.parseLong(s2);
                if(l1 < l2) return -1;
                else return 1;
            }
        });
        for (String s : params) {
            System.out.print(s);
        }
    }

    public static void QuickSort(Integer[] nums,int left,int right){
        int i,j;
        if(left > right) return;
        i = left;
        j = right;
        int temp = nums[left];
        while(i < j){
            while(i < j && nums[j] >= temp){
                j--;
            }
            while(i < j && nums[i] <= temp){
                i++;
            }
            if(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        QuickSort(nums,left,i - 1);
        QuickSort(nums,i + 1,right);
    }

    @Test
    public void test(){
        Integer[] i = new Integer[]{3,7,1};
        Arrays.sort(i, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int n : i){
            System.out.println(n);
        }
    }

}
