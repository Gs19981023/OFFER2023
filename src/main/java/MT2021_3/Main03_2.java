package MT2021_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName Main03_2
 * @Description 小美跑腿，背包问题
 * @Author GuoSheng
 * 小根堆题：为什么一定要用小跟堆？
 * @Date 2022/8/24  14:38
 * @Version 1.0
 **/
public class Main03_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        String[] param;
        int n = Integer.parseInt(one[0]); // 订单信息数量
        int m = Integer.parseInt(one[1]);// 可接订单数量
        Map<Integer,Integer> map = new HashMap<>();
        Integer[] nums = new Integer[n];
        Node1[] node1s = new Node1[n];
        for(int i = 0; i < n; i++){
            param = br.readLine().split(" ");
            nums[i] = Integer.parseInt(param[0]) + Integer.parseInt(param[1]) * 2;
            node1s[i] = new Node1(i + 1,nums[i]);
        }

        // 降序排序每一个node结点，根据node的收入进行降序排序
        // 降序思路:如果前面的 - 后面的 > 0不操作，返回-1
        // 如果前面的小于后面，就要进行颠倒，操作1
        //升序 o1 - o2;
        // 降序o2 - o1;

        Arrays.sort(node1s, new Comparator<Node1>() {
            @Override
            public int compare(Node1 o1, Node1 o2) {
                if(o1.income > o2.income){
                    return -1;
                }else if(o1.income < o2.income){
                    return 1;
                }else{
                    return o1.id - o2.id;
                }
            }
        });
        // 优先队列，优先把小的放在头部
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++)
            pq.offer(node1s[i].id);
        for(int i = 0; i < m; i++)
            System.out.print(pq.poll() + " ");

    }
}
class Node1{
    public int income;
    public int id;
    public Node1(int id, int income){
        this.id = id;
        this.income = income;
    }
}
