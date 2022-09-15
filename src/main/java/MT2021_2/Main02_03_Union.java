package MT2021_2; /**
 * @ClassName Main02_03_Union
 * @Description 查并集法，进行数据校验，这样可以对非顺序行程进行寻找环操作。
 * @Author GuoSheng
 * @Date 2022/8/24  00:08
 * @Version 1.0
 **/
import java.util.*;
import java.io.*;
public class Main02_03_Union {
    // 给城市编号
    static Map<String,Integer> cities;
    // 并查集的root数组
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs = br.readLine().trim();
        int n = Integer.parseInt(inputs);
        cities = new HashMap<>();
        root = new int[n];
        for(int i = 0; i < n; i++){
            root[i] = i;
        }
        // 城市编号
        int num = 0;
        // 旅行次数结果
        int count = 0;

        for(int i = 0; i < n; i++){
            String[] params = br.readLine().split(" ");
            if(!cities.containsKey(params[0])) {
                cities.put(params[0], num++);
            }
            if(!cities.containsKey(params[1])){
                cities.put(params[1], num++);
            }
            // 获取来源和去向的城市编号
            int from = cities.get(params[0]);
            int to = cities.get(params[1]);
            // 如果一条线路上的城市没有联通，就合并为联通分支
            // 如果已经联通，就说明出现了环路，完成了一次旅行
            if(!connected(from,to)){
                union(from,to);
            }else{
                count++;
            }
        }
        System.out.println(count);

    }
    // 寻找当前数组的根节点，溯源头
    public static int find(int x){
        return x == root[x] ? x : find(root[x]);
    }
    // 合并操作
    public static void union(int x,int y){
        int rootX = x;
        int rootY = y;
        if(x != y){
            root[rootX] = rootY;
        }
    }
    // 判断是否已经合并
    public static boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
