package MT2021_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName mAIN
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/23  20:32
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(isPalindrome2(s));

    }
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            System.out.println(c);
            if(c >= 'a' && c <='Z'){
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        String tempS = sb.toString();
        int left = 0, right = tempS.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(tempS.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(tempS.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(tempS.charAt(left)) != Character.toLowerCase(tempS.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
