package Help;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

/**
 * @ClassName Main0301
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/23  20:30
 * @Version 1.0
 **/
public class Main0301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        for(int i = 0; i < n; i++){
            System.out.println(getR(s[i]));
        }
    }

    public static String getR(String s) {
        char[] c = getC(s);
        // System.out.println(Arrays.toString(c));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                sb.append(c[i % 3]);
                continue;
            }
            if (s.charAt(i) != c[i % 3]) {
                return "No";
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static char[] getC(String s) {
        Set<Character> set = new HashSet<Character>();
        char[] c = new char[3];
        Arrays.fill(c, ' ');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                continue;
            }
            if (c[i % 3] == ' ') {
                c[i % 3] = s.charAt(i);
                set.add(c[i % 3]);
            }
        }
        // System.out.println(Arrays.toString(c));
        for(int i = 0; i < 3; i++){
            if(c[i] == ' '){
                if(set.add('r')){
                    c[i] = 'r';
                    continue;
                }
                if(set.add('e')){
                    c[i] = 'e';
                    continue;
                }
                if(set.add('d')){
                    c[i] = 'd';
                    continue;
                }
            }
        }
        return c;
    }

}
