package Offer2023.ShunFeng0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainSF_02
 * @Description 圣诞树
 * 查找子图后，将素有的结点都变为0的最少次数
 * @Author GuoSheng
 * @Date 2022/8/31  17:23
 * @Version 1.0
 **/
public class MainSF_02 {
    public static void main(String[] args) throws IOException {
        List<NodeSF> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parents = br.readLine().split(" ");
        String[] params = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < params.length; i++) {
            nums[i] = Integer.parseInt(params[i]);
            if(i > 1){
                list.add(new NodeSF(nums[i],new NodeSF(Integer.parseInt(parents[i - 1]),null)));
            }
        }
        int ans = 0;

        int pre = nums[0];
        ans += pre;
        for (int i = 1; i < nums.length; i++) {
            if(pre == nums[i]){
                continue;
            }
            pre = nums[i];
            ans += pre;
        }
        System.out.println(ans);


    }
}
class NodeSF{
    int val;
    NodeSF parent;
    NodeSF child;
    public NodeSF(int val, NodeSF parent){
        this.val = val;
        this.parent = parent;
    }
    public NodeSF(int val, NodeSF child,NodeSF parent){
        this.val = val;
        this.child = child;
        this.parent = parent;
    }
}
