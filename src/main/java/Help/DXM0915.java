package Help;

import DiDi0916.MainKD03;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName DXM0915 度小满
 * @Description 分数最大的字符串
 *  哈希表记录每个字符出现的次数即可。
 * @Author GuoSheng
 * @Date 2022/9/15  19:07
 * @Version 1.0
 **/
public class DXM0915 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = new String[n];
        for(int i = 0; i < n ; i++){
            s[i] = sc.nextLine();
        }
        int res = 0;
        for(String s1 : s){
            int getRes = Get(s1);
            res = Math.max(res,getRes);
        }
        System.out.println(res);
    }
    public static int Get(String s){
        int max = 0;
        int min = 1000;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue() > max){
                max = entry.getValue();
            }
            if(entry.getValue() < min){
                min = entry.getValue();
            }
        }
        return max - min;
    }
    @Test
    public void test(){
        char c1 = '1';
        char c2 = '2';
        int i = c1 + c2;
        System.out.println(i);
    }
}
