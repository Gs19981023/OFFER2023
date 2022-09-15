package MT2021_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main05_4
 * @Description 树状分析，DFS深度搜索看看，这个好像BFS也行？
 * 1.结点要么没左右子树，要么左右都有
 * 2.第i个人的下属包括自己，刚好有Ai个人，包括左右孩子的孩子。
 * 3.感觉像是建立二叉树的问题。
 * @Author GuoSheng
 * @Date 2022/8/29  17:21
 * @Version 1.0
 **/
public class Main05_4 {
    final static String YES = "YES";
    final static String NO = "NO";
    static boolean[] used;
    static boolean flag;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            arr = new int[n];
            used = new boolean[n];
            flag = true;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                // 每一个不能存在小于1和等于2的情况，因为如果为2的话，那就代表自身+孩子的= 2不符合要求了
                if(arr[i] < 1 || arr[i] == 2){
                    flag = false;
                }
            }
            // 从小到大排序，希望最后一个是根节点
            Arrays.sort(arr);
            // 如果这时已经有不符合的数据，或者最大的要求节点数不等于n，返回NO
            if(!flag || arr[n - 1] != n){
                System.out.println(NO);
                continue;
            }
            int idx = 0;
            // 找到第一个不为1的下标，说明当前idx不是叶子结点
            while(idx < n && arr[idx] == 1){
                idx++;
            }
            // 如果最后一个非叶子结点的下标 >= n / 2，代表叶子结点分配不完。
            if(idx < n / 2){
                System.out.println(NO);
                continue;
            }
            // 从第一个非叶子结点开始，从前面的结点中寻找是否存在它的子节点的组合。(子节点的数量cnt>=2)
            flag = false;
            DFS(idx);
            System.out.println(flag ? YES : NO);
        }
    }
    public static void DFS(int idx){
        // 终止条件
        if(idx >= n){
            flag = true;
            return;
        }
        findSum(0, idx, 0, arr[idx] - 1); // arr[idx] - 1是因为减去本身，要去查找孩子的个数，因此-1

    }
    // 查找是否有目标和
    // 从[start,end)开始遍历，在未使用的结点中寻找是否有和为target的且cnt>=2的数
    public static void findSum(int start, int end, int cnt, int target){
        // 如果目标已经为0，说明已经找到符合arr[i]个数的关系了，如果cnt<2,直接返回。
        // 如果cnt >= 2，从end+1开始继续深度搜索。
        if(target == 0){
            if(cnt >= 2){
                DFS(end + 1);
            }
            return;
        }
        for(int i = start; i < end && arr[i] <= target; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;
            // 回溯
            used[i] = true;
            findSum(i + 1,end, cnt + 1, target - arr[i]);
            used[i] = false;
        }
    }
}
