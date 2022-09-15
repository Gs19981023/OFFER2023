package MT2021_3; /**
 * @ClassName Main03_4
 * @Description 区域会议
 * 美团的业务区域划分可以用一棵树来表示，树上有n个结点，每个结点代表小美的一个业务区域
 * 每一个区域有一个负责人，这个负责人的级别为A_i
 * 要求；1.负责人所在区域要构成一个个非空的连通图，即选取树上的一个连通子图
 *      2.这些负责人，级别最高和最低的不差K
 * 问：有多少种召集方式，即集合不同为不同的方式
 *
 *
 * DFS DFS DFS DFS DFS 深度优先遍历。
 * @Author GuoSheng
 * @Date 2022/8/24  16:30
 * @Version 1.0
 **/
import java.util.*;
import java.io.*;
public class Main03_4 {
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        String[] param;
        int a,b;
        int n = Integer.parseInt(one[0]);
        int k = Integer.parseInt(one[1]);
        long res = 0;
        // 区域位置的集合，无重复，找到所有的区域
        HashSet<Integer>[] treeSet = new HashSet[n];
        for(int i = 0; i< n; i++){
            treeSet[i] = new HashSet<>();
        }
        for(int i = 0; i < n - 1;i++){
            param = br.readLine().split(" ");
            a = Integer.parseInt(param[0]) - 1;
            b = Integer.parseInt(param[1]) - 1;
            treeSet[a].add(b);
            treeSet[b].add(a);
        }
        int[] r = new int[n];
        String[] last = br.readLine().split(" ");
        // 负责人级别数组
        for(int i = 0; i < last.length; i++){
            r[i] = Integer.parseInt(last[i]);
        }
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            long w = DFS(treeSet,visited,i,r,k,r[i],i);
            res += w % 1000000007;
        }

    }

    public static long DFS(HashSet<Integer>[] treeSet,boolean[] visited, int i, int[] r, int k, int k0,int i0){
        visited[i] = true;
        long a = 1;
        HashSet<Integer> set = treeSet[i];
        for (int cur : set) {
            // 如果当前结点没有访问过并且，当前的责任人级别大于起始的责任人的k0值
            // 并且当前责任人的级别
            if(!visited[cur] && r[cur] >= k0 && r[cur]-k0<=k && (r[cur] > k0 || cur < i0)){
                a = (a * (1 + DFS(treeSet,visited,cur,r,k,k0,i0))) / mod;
            }
        }
        return a;
    }
}
