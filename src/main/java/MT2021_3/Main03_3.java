package MT2021_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName Main03_3
 * @Description 用户名校验
 * 1.    用户名的首字符必须是大写或者小写字母。
 *
 * 2.    用户名只能包含大小写字母，数字。
 *
 * 3.    用户名需要包含至少一个字母和一个数字。
 *
 * 如果用户名合法，请输出“Accept”，反之输出“Wrong”。
 * @Author GuoSheng
 * @Date 2022/8/24  16:17
 * @Version 1.0
 **/
public class Main03_3 {
    final static String accept = "Accept";
    final static String wrong = "Wrong";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String param;
        for(int i = 0; i < n; i++){
            param = br.readLine();
            System.out.println(check(param));
        }
    }
    public static String check(String str){
        char[] chars = str.toCharArray();
        int numsOfLetter = 0;
        int numsOfDigit = 0;
        char head = chars[0];
        if(!Character.isLetter(head)) {
            return wrong;
        }
        for (char c : chars) {
            if(!Character.isLetterOrDigit(c)){
                return wrong;
            }else if(Character.isLetter(c)){
                numsOfLetter++;
            }else if(Character.isDigit(c)){
                numsOfDigit++;
            }
        }
        if(numsOfDigit == 0 || numsOfLetter == 0) return wrong;

        return accept;

    }
}
