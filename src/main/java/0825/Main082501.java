import java.io.*;
import java.util.*;

/**
 * @ClassName Main082501
 * @Description 寻找所有输入点的最大面积。
 * @Author GuoSheng
 * @Date 2022/8/25  19:59
 * @Version 1.0
 **/
public class Main082501 {
    static List<List<Point>> finalList = new ArrayList<>();
    static LinkedList<Point> path = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String substring = s.substring(1, s.length() - 1);
        String[] param = substring.split(",");
        List<Point> list = new LinkedList<>();
        // 存放所有两个可能的
        int n = param.length;
        int[] nums = new int[n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < param.length; i++) {
            list.add(new Point(i, Integer.parseInt(param[i])));
            nums[i] = Integer.parseInt(param[i]);
        }
        DFS(nums,0);
        for (List<Point> points : finalList) {
            Point point1 = points.get(0);
            Point point2 = points.get(1);
            res = Math.max(Math.abs(point1.x - point2.x) * Math.min(point1.y, point2.y),res);
        }
        System.out.println(res);
    }
    private static void DFS(int[] nums, int startIndex){
        if(path.size() == 2){
            finalList.add(new ArrayList<Point>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            path.add(new Point(i,nums[i]));
            DFS(nums, i+ 1);
            // 回溯
            path.removeLast();
        }
    }
}
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + this.x + "y = " +this.y;
    }
}