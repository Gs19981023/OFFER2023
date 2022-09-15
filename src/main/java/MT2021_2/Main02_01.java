package MT2021_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MT2021.Main1
 * @Description 小团的配送团队
 * 将同小区的内容进行合并，难点：小区和订单号的关联状态用map维持，同一小区的订单用一个合并对象进行合并操作。
 * 合并完订单后，怎么找到小区和订单编号的关系
 * @Author GuoSheng
 * @Date 2022/8/23  16:18
 * @Version 1.0
 **/
public class Main02_01 {
    public static void main(String[] args) throws IOException {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);



    }




}
class UnionFind{
    public int[] parent;
    public int count;
    public UnionFind(int n){
        count = n;
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }
    // 查找小区
    public int find(int x){
        if(parent[x] != x){
            x = find(parent[parent[x]]);
        }
        return x;
    }
    public void union(int x,int y){
        if(x == y) return;  // 如果两个相等，直接返回
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;

        if(rootX < rootY){
            for(int i = 0; i< parent.length; i++){
                if(parent[i] == rootY){
                    parent[i] = rootX;
                }
            }
        }else{
            for(int i = 0; i< parent.length; i++){
                if(parent[i] == rootX){
                    parent[i] = rootY;
                }
            }
        }
        count--;
    }
}
