package Offer2023.ZhongXing0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName MainZX01
 * @Description CEO关注的文件进行排序
 * AK
 * @Author GuoSheng
 * @Date 2022/8/29  18:58
 * @Version 1.0
 **/
public class MainZX02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int p = Integer.parseInt(s[0]);     // 报告总数
        int q = Integer.parseInt(s[1]);     // 重点关注的文件数
        int[] pNums = new int[p];       // 所有文件数组
        List<Integer> pList = new ArrayList<>();
        int[] qNums = new int[q];   // 关注的数组
        String[] param1 = br.readLine().split(" ");     // 所有的
        String[] param2 = br.readLine().split(" ");         // 关注的
        Map<Integer,Integer> map = new HashMap();
        int k = 1;
        for (String s1 : param2) {
            map.put(Integer.valueOf(s1), k++);
        }
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < p; i++){
            pList.add(Integer.valueOf(param1[i]));
        }
        pList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.containsKey(o1) && !map.containsKey(o2)){
                    return -1;
                }else if(!map.containsKey(o1) && map.containsKey(o2)){
                    return 1;
                }else if(map.containsKey(o1) && map.containsKey(o2)){
                    return map.get(o1) - map.get(o2);
                }
                // 升序排序id
                else{
                    return o1 - o2;
                }
            }
        });
        for(int i = 0; i < p - 1; i++){
            System.out.print(pList.get(i) + " ");
        }
        System.out.println(pList.get(p - 1));


    }
}
