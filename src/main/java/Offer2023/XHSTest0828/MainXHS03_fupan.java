package Offer2023.XHSTest0828;

import java.util.*;

/**
 * @ClassName MainXHS03
 * 图搜索，深度搜索 遍历图的每一种情况。
 * @Description 一对一匹配，最多可以匹配多少对？
 *  map用于记忆，避免重复赔
 *  DFS深度搜索仿照树进行深搜，pre用于记录当前结点的父节点，canuse表示当前结点是否可以使用 1可使用，-1不可使用
 *
 *  如果当前结点不可以用，则其子节点均可用
 *  如果当前结点均可用，则（1）其子节点均可用（2）当前结点和其中一个子节点已经建立了连接，该子节点不可用
 *  其余结点可用
 *  从头开始遍历的时候，其子节点有用和不用两种情况
 * @Author GuoSheng
 * @Date 2022/8/28  15:53
 * @Version 1.0
 **/
public class MainXHS03_fupan {
    static Map<Integer,Integer> map;
    // 边缘
    static ArrayList<Integer>[] edges;
    static int n;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new HashMap<>();
        // 为什么是n+3呢
        edges = new ArrayList[n + 3];
        for(int i = 0; i < n + 3; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int temp = sc.nextInt();
            edges[temp].add(i + 2);
            edges[i + 2].add(temp);
        }
        System.out.println(DFS(1,1,-1));
        System.out.println("111");
    }
    public static int DFS(int canuse,int index, int pre){
        int arr = index * canuse;
        // 终止条件，如果当前结点在map中已经存储过了，那么他就不能继续存了
        if(map.containsKey(arr)){
            return map.get(arr);
        }
        int cnt = 0;
        // 遍历当前结点可以匹配的队友，如果存在之前的pre结点，
        for (int next : edges[index]) {
            if(next != pre){
                cnt += DFS(1, next, index);
            }
        }
        int ret = cnt;
        // 如果当前结点没被使用
        if(canuse == 1){
            for(int next : edges[index]){
                if(next != pre){
                    // 不用当前结点，最大配对数
                    int f = DFS(-1,next,index);
                    // 用当前结点的最大配对数
                    int t = DFS(1, next,index);
                    ret = Math.max(ret, cnt - t + f + 1);
                }
            }
        }
        map.put(arr,ret);
        return ret;
    }
}
