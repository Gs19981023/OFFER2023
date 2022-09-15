package JDTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName Main090303
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/3  19:29
 * @Version 1.0
 **/
public class Main090303 {
    static List<List<Character>> list;
    static LinkedList<Character> path;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String params = br.readLine();
        char[] chars = params.toCharArray();
        used = new boolean[chars.length];
        list = new ArrayList<>();
        path = new LinkedList<>();
        DFS(chars,0);
        int ans = 0;
        for (List<Character> characters : list) {
            int temp = Get(characters);
            System.out.println(temp);
            ans += temp;
        }
        System.out.println(ans);

    }


    //所有子集的情况
    public static void DFS(char[] chars,int startIdx){
        list.add(new ArrayList<>(path));
        if(startIdx >= chars.length) return;
        for (int i = startIdx; i < chars.length; i++){
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(chars[i]);
            used[i] = true;
            DFS(chars, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
    // 获得权值
    // 左括号和有括号的最小值乘以2
    public static int Get(List<Character> list){
        int weight = 0;
//        if(list.size() % 2 == 1 || list.size() == 0) return 0;
        if(list.size() == 0) return 0;
        for(int i = 0; i + 1 < list.size(); i++){
            if(list.get(i) == '(' && list.get(i + 1) == ')'){
                weight += 2;
            }
        }
        return weight;
    }
}

class QuanZhi{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Deque<Integer> stack = new LinkedList<>();
        long ans = 0;
        long temp = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') stack.push(i);
            if(c==')'&&!stack.isEmpty()){
                temp+= 2*(stack.pop()+1);
                ans += temp;
            }
            else{
                ans += temp;
            }
        }
        System.out.println(ans);
    }
}
