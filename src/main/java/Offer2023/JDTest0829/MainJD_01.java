package Offer2023.JDTest0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName MainJD_01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/27  18:57
 * @Version 1.0
 **/
public class MainJD_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int up = Integer.parseInt(s[1]);
        String params = br.readLine();
        char[] chars = params.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < up; i++){
            sb.append(Character.toUpperCase(chars[i]));
        }
        for(int j = up; j < chars.length; j++){
            sb.append(Character.toLowerCase(chars[j]));
        }
        System.out.println(sb.toString());
    }
}
