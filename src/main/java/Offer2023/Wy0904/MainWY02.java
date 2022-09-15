package Offer2023.Wy0904;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName MainWY02
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/4  16:15
 * @Version 1.0
 **/
public class MainWY02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] wight = br.readLine().split(" ");  // 权值
        int[] wightArr = new int[n];
        for (int i = 0; i < wight.length; i++) {
            wightArr[i] = Integer.parseInt(wight[i]);
        }
        Map<Integer,TreeWy> map = new HashMap<>();
        Map<Integer,List<Integer>> map2 = new HashMap<>();
        List<TreeWy> list = new ArrayList<>();
//        for(int i = 0; i < n - 1; i++){
//            String[] path = br.readLine().split(" ");
//            int i1 = Integer.parseInt(path[0]);
//            int i2 = Integer.parseInt(path[0]);
//            TreeWy root = new TreeWy(i1);
//            TreeWy child = new TreeWy(i2);
//            if(map.containsKey(i1)){
//                map.get(i1).child.add(child);
//            }else{
//                root.child.add(child);
//                map.put(i1,root);
//            }
//        }
//        Set<Integer> set = map.keySet();
//        for (Integer integer : set) {
//            TreeWy treeWy = map.get(integer);
//            if(treeWy)
//        }

        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            String[] path = br.readLine().split(" ");
            int i1 = Integer.parseInt(path[0]);
            int i2 = Integer.parseInt(path[0]);
            if(map.containsKey(i1)){
                List<Integer> tempList = map2.get(i1);
                tempList.add(i2);
                map2.put(i1,tempList);
            }else{
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i2);
                map2.put(i1,tempList);
            }
        }
        Set<Integer> set = map2.keySet();
        for (Integer integer : set) {
            int temp = integer;

            List<Integer> integers = map2.get(integer);
            for (Integer integer1 : integers) {
                temp *= integer1;
            }
            ans += getYinZi(temp);
        }
        System.out.println(ans);

    }
    // 获取因子
    public static int getYinZi(int n){
        int res = 0;
        for(int i = n; i > 0; i--){
            if(n % i == 0){
                res++;
            }
        }
        return res;
    }
}

class TreeWy{
    int val;
    List<TreeWy> child;
    public TreeWy(int val){
        this.val = val;
        this.child = new ArrayList<>();
    }
}
