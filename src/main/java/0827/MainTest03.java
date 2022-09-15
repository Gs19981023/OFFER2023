import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName MainTest03
 * @Description
 * @Author GuoSheng
 * @Date 2022/8/27  17:09
 * @Version 1.0
 **/
public class MainTest03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] s2 = s1.split(" ");
        int n = Integer.valueOf(s2[0]);
        int m = Integer.valueOf(s2[1]);
        // 布料
        String s = sc.nextLine();
        String x = sc.nextLine();
        // 裁剪成的小布料
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(sc.next());
        }
        DFS(s, 0, list);
        System.out.println(sum);
    }

    static int sum = 0;

    // index为本次寻找的起始位置。
    public static void DFS(String s, int index, List<String> list){
        // 遍历完1次并且需要裁减的长度为0，说明本次裁减成功
        if(index == s.length() && list.size() == 0){
            sum++;
        }
        if(index >= s.length()){
            return;
        }
        for(int i = index + 1; i < s.length() + 1; i++){
            // 不断的分割字符串
            String substring = s.substring(index, i);
            if(list.contains(substring)){
                List<String> list_jump = new ArrayList<>(list);
                // 把已经匹配的删掉，继续匹配剩下的
                list_jump.remove(substring);
                DFS(s, i, list_jump);
            }
        }
    }

}
