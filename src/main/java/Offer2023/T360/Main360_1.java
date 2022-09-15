package Offer2023.T360;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName Main360_1
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/27  14:48
 * @Version 1.0
 **/
public class Main360_1 {
    static Set<Character> set = new HashSet<>();
    static String YES = "YSE";
    static String NO = "NO";
    public static void main(String[] args) {
        set.add('A');
        set.add('O');
        set.add('H');
        set.add('I');
        set.add('M');
        set.add('T');
        set.add('U');
        set.add('V');
        set.add('W');
        set.add('X');
        set.add('Y');

        Scanner sc = new Scanner(System.in);
        String str = "";
        List<String> params = new ArrayList<>();
        while(!(str = sc.nextLine()).isEmpty()){
            params.add(str);
        }
        for (String param : params) {
            System.out.println(isOk(param));
        }

    }

    private static String isOk(String str){
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        for(char c : chars){
            if(!set.contains(c)) return NO;
        }
        while(left <= right){
            if(set.contains(chars[left]) && set.contains(chars[right])){
                if(chars[left] == chars[right]){
                    left++;
                    right--;
                }else{
                    return NO;

                }
            }else{
                return NO;
            }
        }
        return YES;
    }
    @Test
    public void test(){

    }
}
