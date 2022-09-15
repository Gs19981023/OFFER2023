package Offer2023.ZhongXing0829;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName MainZX01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/29  18:58
 * @Version 1.0
 **/
public class MainZX01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] params = sc.nextLine().split(" ");
        String start = params[0];
        String end = params[1];
        char c = start.charAt(0);
        int c1 = Integer.parseInt(String.valueOf(start.charAt(1)));

        char e = end.charAt(0);
        int e2 = Integer.parseInt(String.valueOf(end.charAt(1)));
        int line = (e - c) + 1;
        int colum = (e2 - c1) + 1;
        String[][] res = new String[line + 3][colum + 3];
        for(int i = 0; i < line; i++){
            for(int j = 0; j < colum; j++){
                res[i][j] = String.valueOf(Character.toChars(c + i)) + String.valueOf(c1 + j);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0; i < line; i++){
            for(int j = 0; j < colum; j++){
                sb.append(res[i][j] + ", ");
            }
        }
        String sub = sb.substring(0, sb.length() - 2);
        sub += "]";
        System.out.println(sub);
    }
    @Test
    public void test(){
        char c = 'A';

        System.out.println(c+1);
    }
}
