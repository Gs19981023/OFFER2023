package Offer2023.DiDi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName MainDD03
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/4  20:10
 * @Version 1.0
 **/
public class MainDD03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] one = br.readLine().split(" ");
        String[] two = br.readLine().split(" ");
        String[] three = br.readLine().split(" ");
        int[] L = new int[one.length];
        int[] R = new int[two.length];
        int[] T = new int[three.length];
        for (int i = 0; i < one.length; i++) {
            L[i] = Integer.parseInt(one[i]);
        }
        for (int i = 0; i < two.length; i++) {
            R[i] = Integer.parseInt(two[i]);
        }
        for (int i = 0; i < three.length; i++) {
            T[i] = Integer.parseInt(three[i]);
        }
        for(int i = 0; i < n; i++){
            int ans = 0;
            for(int start = L[i]; start <= R[i]; start++){
                int t = getBeaute(start);
                if(t == T[i]) ans++;
            }
            System.out.print(ans + " ");
        }
    }
    // 计算魅力值
    public static int getBeaute(int i){
        int temp = i % 10;
        i /= 10;
        while(i > 0){
            temp ^= i % 10;
            i /= 10;
        }
        return temp;
    }
}
