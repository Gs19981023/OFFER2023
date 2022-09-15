package MT2021_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @ClassName Main04
 * @Description 送花路线DFS深度优先遍历，先从根节点遍历到
 * @Author GuoSheng
 * @Date 2022/8/22  22:54
 * @Version 1.0
 * 题目描述：小美是美团的一名鲜花快递员，鲜花是一种保质期非常短的商品，所以需要尽快送到客户手中，公司对于骑手的一个要求就是要规划送花的线路，使得骑手送完所有订单走的路程尽可能少。(骑手开始派送时带走了所有需要派送的花，不必每单后返回花店，路程结算是从花店出发，到送完最后一名客户为止，不计算从最后一名客户家回到花店的时间)
 *
 *        公司对于骑手的绩效评价是取决于两个指标，一是从花店到所有客户地址的距离之和，另一个是骑手实际走的路程。
 *
 *       设花店始终位于1号位置，客户共有n-1个，其编号为2~n。令dis(i,j)表示i号位置到j号位置的距离，即分别计算, 和骑手实际所走的最短路程。
 *
 *       为了简化问题，我们约束这n个位置构成的是一棵树，即只有n-1条边在其中互相连接，且保证n个点彼此连通。
 **/
public class Main04DFS {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        Node[] nodes = new Node[n + 1];
        int sum = 0;
        for(int i = 0; i < n - 1; i++){
            String[] s = bf.readLine().trim().split(" ");
            int now = Integer.parseInt(s[0]);
            int target = Integer.parseInt(s[1]);
            int dis = Integer.parseInt(s[2]);
            if(nodes[now] == null){
                nodes[now] = new Node();
            }
            if(nodes[target] == null){
                nodes[target] = new Node();
            }
            nodes[now].neibor.put(nodes[target],dis);
            nodes[target].neibor.put(nodes[now],dis);
            sum += 2 * dis;
        }
    }

    public static void DFS(){

    }



    public static class Node{
        int dis;
        boolean visited;
        HashMap<Node,Integer> neibor;
        public Node(){
            dis = 0;
            neibor = new HashMap<Node, Integer>();
        }
    }
}
