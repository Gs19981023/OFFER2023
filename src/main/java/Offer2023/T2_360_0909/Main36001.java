package Offer2023.T2_360_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Main36001
 * @Description
 * 给定一个长度为N的序列A1到AN，现在要对序列进行M次操作，
 * 每次操作对序列的前若干项进行升序或降序排列，
 * 求经过这M次操作后得到的序列。
 *
 * 输入描述：
 * 第一行包含两个整数N和M，1≤N，M≤105。
 *
 * 第二行包含N个空格隔开的整数A1到AN，1≤Ai≤109。
 *
 * 接下来M行，每行包含两个整数t和x，0≤t≤1，1≤x≤N。若t=0，则表示对A1到Ax进行升序排列；若t=1，则表示对A1到Ax进行降序排列。操作执行顺序与输入顺序一致。
 * @Author GuoSheng
 * @Date 2022/9/9  14:59
 * @Version 1.0
 **/
public class Main36001 {

    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        N = Integer.parseInt(one[0]);
        M = Integer.parseInt(one[1]);
        int[] nums = new int[N];
        List<Integer> list = new ArrayList<>();
        String[] params = br.readLine().split(" ");
        for (int i = 0; i < params.length; i++) {
            nums[i] = Integer.parseInt(params[i]);
            list.add(nums[i]);
        }
        Node[] nodes = new Node[M];
        for(int i = 0; i < M; i++){
            String[] temp = br.readLine().split(" ");
            nodes[i] = new Node(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
        }
        for (Node node : nodes) {
            list = sort(node.end, node.opr, list);
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    private static List<Integer> sort(int end, int opr, List<Integer> list){
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < end; i++){
            temp.add(list.get(i));
        }
        if(opr == 0){
            temp.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }else{
            temp.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
        res.addAll(temp);
        for(int i = end; i < N; i++){
            res.add(list.get(i));
        }

        return res;
    }
}
class Node{
    int opr;
    int end;
    public Node(int opr, int end){
        this.opr = opr;
        this.end = end;
    }
}
