package Offer2023.BaiDu0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MainBD01
 * @Description baidu字符串
 * @Author GuoSheng
 * @Date 2022/9/13  18:55
 * @Version 1.0
 **/
public class MainBD01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String params = br.readLine();
        Set<Character> set = new HashSet<>();
        List<Character> temp = new ArrayList<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        for(int i = 0; i < params.length() - 5; i++){
            temp = new ArrayList<>();
            for(int j = i; j <= i + 4; j++){
                char c = params.charAt(j);
                if(!temp.contains(c)){
                    temp.add(c);
                }else{
                    break;
                }
            }
            if(temp.size() == 5){
                char c1 = temp.get(0);
                char c2 = temp.get(1);
                char c3 = temp.get(2);
                char c4 = temp.get(3);
                char c5 = temp.get(4);
                if(!set.contains(c1) && set.contains(c2) && set.contains(c3) && !set.contains(c4) && set.contains(c5)){
                    ans++;
                }
            }

        }
        System.out.println(ans);


    }
}
