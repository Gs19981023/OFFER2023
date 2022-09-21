
package DiDi0916;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName MainDiDi02
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/17  16:00
 * @Version 1.0
 **/
public class MainDiDi02 {
    public static void main(String[] args) {
        MainKD03 mKD03 = new MainKD03();
        int f = mKD03.k;
        Scanner sc = new Scanner(System.in);
        String params = sc.nextLine();
        Map<Integer,Character> map = new HashMap<>();
        int num = 0;
        for(int i = 0; i < params.length(); i++){
            if(params.charAt(i) == '?'){
                if(i == 0){
                    num = 1;
                }else{
                    num = num * 10;
                }
            }else{
                num = num * 10 + Integer.parseInt(String.valueOf(params.charAt(i)));
            }
        }
        String s = num + "";
        int res = isNotEqual(s);
        while(res % 3 != 0 || isNotEqualBoolean(res + "")){
            res++;
        }
        System.out.println(res);


    }
    // 初始填充和判断伸缩
    public static int isNotEqual(String s){
        StringBuilder temps = new StringBuilder();
        boolean flag = false;
        int t = 0;
        for(int i = s.length() - 1; i >= 1; i--){
            if(s.charAt(i) == s.charAt(i - 1)){
                t = Integer.parseInt(String.valueOf(s.charAt(i)));
                if(!flag){
                    t = t + 1;
                    if(t == 10){
                        t = 0;
                        flag = true;
                    }else{
                        flag = false;
                    }
                }else{
                    t = t + 1 + 1;
                    if(t == 10){
                        t = 0;
                        flag = true;
                    }else{
                        flag = false;
                    }
                }
            }
            temps.append(t);
        }
        if(flag){
            temps.append(1);
        }
        return Integer.parseInt(temps.reverse().toString());
    }
    public static boolean isNotEqualBoolean(String s){
        boolean flag = false;
        for(int i = s.length() - 1; i >= 1; i--){
            if(s.charAt(i) == s.charAt(i - 1)){
                flag = true;
                break;
            }
        }
        return flag;

    }
}
