package Offer2023.Lenovo0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Main02
 * @Description 流量峰值
题目描述：
 在一款放置类游戏中，游戏的地图是一个m*n的网格，玩家可以在任意的网格位置建立自己的城堡，而城堡有一个护甲值，
 当同一时刻进攻玩家的npc不超过护甲值时，玩家的城堡就不会被攻破。而除去玩家所选择的位置以外，
 地图上每一个位置都有一个npc，在收到进攻命令前，npc是静止的，收到进攻命令后每过一个单位时间，
 npc就会向四个方向之一移动一格，机智的npc走的路径一定是到达城堡的最短路径。

 输入
 输入第一行包含一个四个正整数m,n,x,y，表示网格的大小是m*n，玩家选择的城堡位置是(x,y)。(1<=m,n<=10^5,1<=x<=m,1<=y<=n)
 输出
 输出仅包含一个整数，即城堡至少需要的护甲值。
 样例：
 输入
 5 7 3 3
 输出
 9

 请问在npc发起进攻前，城堡至少需要多少护甲才能不被攻破。
 * m*n的网格，随机一个点，求其余点到这个点分别的最短路径。
 * 四个方向都可移动
 * @Author GuoSheng
 * @Date 2022/9/1  14:07
 * @Version 1.0
 **/
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int m = Integer.parseInt(params[0]);
        int n = Integer.parseInt(params[1]);
        int x = Integer.parseInt(params[2]);
        int y = Integer.parseInt(params[3]);
        int[][] dp = new int[n][m];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i <= m; i++){
            if(i == x) continue;
            for(int j = 1; j <= n; j++){
                if(j == y) continue;
                int temp = Math.abs(i - x) + Math.abs(j - y);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        int maxAns = Integer.MIN_VALUE;
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            maxAns = Math.max(maxAns, map.get(integer));
        }
        System.out.println(maxAns);
    }
}
