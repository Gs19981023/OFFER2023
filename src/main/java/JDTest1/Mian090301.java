package JDTest1;

import org.w3c.dom.NodeList;

import java.util.*;

/**
 * @ClassName Mian090301
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/3  17:56
 * @Version 1.0
 **/
public class Mian090301 {
    static List<List<Node9>> list = new ArrayList<>();
    static LinkedList<Node9> path = new LinkedList<>();
    static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node9> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(new Node9(sc.nextInt(), sc.nextInt()));
        }
        used = new boolean[n];
        DFS(nodeList);
        int ans = Integer.MAX_VALUE;
        for (List<Node9> node9s : list) {
            int temp = 0;
            for (int i = 0; i < node9s.size(); i++) {
                if(i == 0){
                    temp += Math.abs(node9s.get(i).start - 1);
                    temp += Math.abs(node9s.get(i).end - node9s.get(i).start);
                }else{
                    temp += Math.abs(node9s.get(i - 1).end - node9s.get(i).start);
                    temp += Math.abs(node9s.get(i).end - node9s.get(i).start);
                }
            }
            temp += node9s.get(node9s.size() - 1).end - 1;
            ans = Math.min(ans,temp);
        }
        System.out.println(ans);

    }
    public static void DFS(List<Node9> nodeList){
        if(path.size() == nodeList.size()){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nodeList.size(); i++){
            if(used[i] == true) continue;
            used[i] = true;
            path.add(nodeList.get(i));
            DFS(nodeList);
            path.removeLast();
            used[i] = false;
        }
    }
}
class Node9{
    int start;
    int end;
    public Node9(int start, int end){
        this.start = start;
        this.end = end;
    }
}
