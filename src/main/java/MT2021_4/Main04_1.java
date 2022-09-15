package MT2021_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
  *@ClassName Main
  *@Description A，B两人所在位置抽象为一棵n个结点的树，
  *@Author GuoSheng
  *@Date 2022/8/24  18:20
  *@Version 1.0
  **/
public class Main04_1 {
    // 全局变量e，二维List，第一个维度存储起点，第二个存储可以到达的所有位置
    private static List<List<Integer>> e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        String[] params;
        int n = Integer.parseInt(one[0]);
        int x = Integer.parseInt(one[1]);
        int y = Integer.parseInt(one[2]);
        e = new ArrayList<>();
        // 初始化二维list
        for(int i = 0; i <= n ;i++){
            e.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n - 1; i++){
            params = br.readLine().split(" ");
            int u = Integer.parseInt(params[0]);
            int v = Integer.parseInt(params[1]);
            e.get(u).add(v);
            e.get(v).add(u);
        }
        int ans = 0;
        // x的距离
        int[] dis_x = new int[n + 1];
        int[] dis_y = new int[n + 1];
        dis_y[0] = dis_x[0] = -1;   // 默认起始点为-1
        DFS(x,0,dis_x);
        DFS(y,0,dis_y);
        System.out.println("e");
        for (List<Integer> integers : e) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println("dis_x");
        for (int disX : dis_x) {
            System.out.print(disX + " ");
        }
        System.out.println("dis_y");
        for (int disY : dis_y) {
            System.out.print(disY + " ");
        }
        // 遍历两个数组，当走到底i点时，如果x的距离比y距离远，就刷新x的最大值即可。
        for(int i = 0; i <= n; i++){
            if(dis_y[i] < dis_x[i]){
                ans = Math.max(ans, dis_x[i]);
            }
        }

        System.out.println(ans);

    }
    // 深度优先搜索，分别以x，y为起点搜索所有其他点的路径长度，如果dx>dy，就取最大的dx
    private static void DFS(int u, int f,int[] dis){
        dis[u] = dis[f] + 1;
        int size = e.get(u).size();
        for(int i = 0; i < size; i++){
            int v = e.get(u).get(i);
            if(v == f) continue;
            DFS(v,u,dis);
        }
    }
}
