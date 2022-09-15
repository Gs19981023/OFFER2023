package MT2021_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Main05_3
 * @Description 争夺地盘，A国希望得到N块土地中的P块，B希望得到Q块土地。
 * 计算出：哪些是仅A国要，哪些是仅B国要，哪些是交集。
 * @Author GuoSheng
 * @Date 2022/8/29  17:00
 * @Version 1.0
 **/
public class Main05_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);
        int q = Integer.parseInt(s[2]);
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        int allA = A.length,justA = 0;
        int allB = B.length,justB = 0;
        int common = 0;

        Set<String> set = new HashSet<>();
        for (String s1 : A) {
            set.add(s1);
        }
        for(String s2 : B){
            if(set.contains(s2)){
                common++;
            }
        }
        System.out.println(allA - common + " " + (allB - common) + " "+ common);
    }
}
