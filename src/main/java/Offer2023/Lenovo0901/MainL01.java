package Offer2023.Lenovo0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName MainL01
 * @Description 能换则换
 * AC
 * 题目描述：
 给出一个长度为n的仅由A和B构成的字符串，你可以对这个字符串进行m次操作，每一次操作可以任选下面一种：

 1. 交换字符串中两个字符。

 2. 将字符串中的任意一个字符换成另一个字符。

 请问在经过m次操作后，所能得到的字典序最小的字符串是什么。

输入：
5 2
ABBAB
输出
AAAAB
 *
 * @Author GuoSheng
 * @Date 2022/9/1  13:38
 * @Version 1.0
 **/
public class MainL01 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String s = br.readLine();
        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int aNum = 0,bNum = 0;
        for (char aChar : chars) {
            if(aChar == 'A'){
                aNum++;
            }
            else bNum++;
        }
        for (char aChar : chars) {
            if(aChar == 'B' && m > 0){
                list.add('A');
                bNum--;
                aNum++;
                m--;
            }else{
                list.add(aChar);
            }
        }

        if(m > 0 && bNum == 0){
            if(m % 2 != 0){
                list.removeLast();
                list.add('B');
            }
            for (Character character : list) {
                sb.append(character);
            }
            System.out.println(sb.toString());
        }else{
            for (Character character : list) {
                sb.append(character);
            }
            System.out.println(sb.toString());
        }

    }
}
