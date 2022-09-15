package MT2021_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName Main04_4
 * @Description 根据规则寻找符合要求的字符串组合个数，二元组合哦
 * 小团从某不知名论坛上突然得到了一个测试默契度的游戏，想和小美玩一次来检验两人的默契程度。游戏规则十分简单，首先有给出一个长度为n的序列，最大值不超过m。
 *
 * 小团和小美各自选择一个[1,m]之间的整数，设小美选择的是l，小团选择的是r，我们认为两个人是默契的需要满足以下条件:
 *
 * 1.    l小于等于r。
 *
 * 2.    对于序列中的元素x，如果0<x<l,或r<x<m+1,则x按其顺序保留下来，要求保留下来的子序列单调不下降。
 *
 * 小团为了表现出与小美最大的默契，因此事先做了功课，他想知道能够使得两人默契的二元组<l,r>一共有多少种。
 *
 * 我们称一个序列A为单调不下降的，当且仅当对于任意的i>j,满足A_i>=A_j。
 * @Author GuoSheng
 * @Date 2022/8/26  15:44
 * @Version 1.0
 **/

public class Main04_4 {
    // 1<=x<l || r<x<=m的数都要保留下来，构成一个非递减序列
    // 意思是上述两个条件任一范围内保留下来的数不能构成非递减序列，则这个数对肯定不能满足条件
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int m = Integer.parseInt(one[0]);
        int n = Integer.parseInt(one[1]);
        String[] params = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(params[i]);
        }
        // 从m开始逆序枚举出r的位置，对于每个r，首先判断>r的数能否构成非递减序列，如果不能直接break；
        // 如果r满足，则寻找满足条件的最大l值，字啊[1,r]内进行二分查找，如果找到，最终增加l个
        int res = 0;
        for(int r = m;  r >=1 ; r--){
            if(!isKeepUp(nums,r)){
                break;
            }
            res += findL(nums,r);
        }
        System.out.println(res);
    }

    // 二分法查找l的最大值
    private static int findL(int[] nums, int r) {
        int low = 1;
        int high = r;
        int maxL = 0;
        while(low <= high){
            int l = low + (high - low) / 2;
            // 如果
            if(notDecreaseWithL(nums,l,r)){
                maxL = l;
                low = l + 1;
            }else{
                high = l - 1;
            }
        }
        return maxL;
    }

    //满足1<=x<l || r<x<=m留下来的序列能够构成非递减
    private static boolean notDecreaseWithL(int[] nums, int l, int r) {
        int pre = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > r || nums[i] < l){
                if(nums[i] < pre) return false;
            }
        }
        return true;
    }

    // 判断在r的范围内，是否是大于等于的顺序
    public static boolean isKeepUp(int[] nums, int r){
        int pre = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > r){
                if(nums[i] < pre){
                    return false;
                }
                pre = nums[i];
            }
        }
        return true;
    }

}
