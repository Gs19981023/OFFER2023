package Offer2023.GLD0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainGLD02
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/31  22:09
 * @Version 1.0
 **/
public class MainGLD02 {
    static int lastAns = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int n = Integer.parseInt(one[0]);
        int m = Integer.parseInt(one[1]);
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int[] temp = new int[3];
            String[] params = br.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                temp[i] = Integer.parseInt(params[i]);
            }
            list.add(temp);
        }
        boolean[] used = new boolean[n + 1];
        DFS(list,used,1);
        System.out.println(lastAns);
    }
    public static void DFS(List<int[]> list,boolean[] used, int idx){
        if(idx == used.length){
            boolean temp = isUsed(list,used);
            if(temp){
                int target = 0;
                for (boolean u : used) {
                    if(u) target++;
                }
                lastAns = Math.max(target,lastAns);
            }
            return;
        }
        used[idx] = true;
        DFS(list,used,idx + 1);
        used[idx] = false;
        DFS(list,used,idx + 1);

    }

    private static boolean isUsed(List<int[]> list,boolean[] used) {
        boolean tb = true;
        for (int[] tempArr : list) {
            int ans = 0;
            for(int i = tempArr[0]; i <= tempArr[1]; i++){
                if(used[i]) ans++;
            }
            if(ans <= tempArr[2]){
                tb = true;
            }else{
                return false;
            }
        }
        return tb;
    }

}
