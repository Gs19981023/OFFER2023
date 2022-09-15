package Offer2023.DiDi;

import org.junit.Test;

import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName MainDD01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/4  18:16
 * @Version 1.0
 **/
public class MainDD02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int n = Integer.parseInt(one[0]);
        int k = Integer.parseInt(one[1]);
        String[] taoZi = br.readLine().split(" ");
        int[] taoZiArr = new int[n];
        for (int i = 0; i < taoZi.length; i++) {
            taoZiArr[i] = Integer.parseInt(taoZi[i]);
        }
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[n];
        DFS(used,taoZiArr,list,path,0);
        System.out.println(getMaxNum(list,k));

    }
    public static void DFS(boolean[] used,int[] taoZiArr,List<List<Integer>> list, LinkedList<Integer> path, int idx){
        list.add(new ArrayList<>(path));
        if(idx >= taoZiArr.length) return;
        for(int i = idx;i < taoZiArr.length; i++){
            if(i > 0 && taoZiArr[i] == taoZiArr[i - 1] && !used[i]) continue;
            path.add(taoZiArr[i]);
            used[i] = true;
            DFS(used,taoZiArr,list,path,i + 1);
            used[i] = false;
            path.removeLast();
        }
    }

    public static int getMaxNum(List<List<Integer>> list,int k){
        int ans = 0;
        for (List<Integer> integers : list) {
            if(integers.size() == 0) continue;
            int size = integers.size();
            int maxTaoZi = 0;
            int sum = 0;
            for (Integer integer : integers) {
                sum += integer;
                maxTaoZi = Math.max(integer,maxTaoZi);
            }
            double avg = sum * 1.0 / size;
            if(maxTaoZi <= avg * k){
                ans = Math.max(size,ans);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int n = 24;
        double m = n * 1.0 / 5;
        System.out.println(m);
    }
}
