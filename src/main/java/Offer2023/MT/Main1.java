
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName MT2021.Main1
 * @Description 字符串A和字符串B移除元素后，A为B的倍数或B为A的倍数
 * @Author GuoSheng
 * @Date 2022/8/21  22:54
 * @Version 1.0
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numA = sc.nextInt();
        int numB = sc.nextInt();
        String s1 = new StringBuilder(Long.toString(numA)).toString();
        String s2 = new StringBuilder(Long.toString(numB)).toString();
        int res = Integer.MAX_VALUE;

        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        // val是当前移完元素后的剩余值
        // p当前起始坐标
        // count为操作的次数
        DFS(s1, 0, 0, map1, 0);
        DFS(s2, 0, 0 ,map2, 0);
        for(Integer key1 : map1.keySet()){
            for(Integer key2 : map2.keySet()){
                if(key1 % key2 == 0 || key2 % key1 == 0){
                    res = Math.min((map1.get(key1) + map2.get(key2)),res);
                }
            }
        }
    }


        private static void DFS (String str,int p, int val, Map<Integer, Integer > map,int count){
            if (str.length() == p) {
                if (val != 0) {
                    map.put(val, str.length() - count);
                }
            }
            // 不要当前元素
            DFS(str, p + 1, val, map, count);
            // 要当前元素
            val += (str.charAt(p) - '0') * (int) Math.pow(10, count);
            DFS(str, p + 1, val, map, count + 1);

        }

    @Test
    public void test(){
        int i = 3;
        int j = 4;
        System.out.println(1 << i);
        System.out.println(1 << j);
        System.out.println(Math.pow(10,3));

    }
}
