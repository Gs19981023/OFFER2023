package MT2021_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main05_1
 * @Description 将大写字符和小写字符数目搞一致。
 * @Author GuoSheng
 * @Date 2022/8/26  21:42
 * @Version 1.0
 **/
public class Main05_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int lastNum = length / 2;
        int numsOfA = 0, numsOfa = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c > 'Z'){
                numsOfA++;
            }else{
                numsOfa++;
            }
        }

        System.out.println(Math.abs(numsOfA - numsOfa) / 2);
    }
}
