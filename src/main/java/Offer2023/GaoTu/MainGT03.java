package Offer2023.GaoTu;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName MainGT01
 * @Description 判断有效括号
 * 考虑用栈来做
 * @Author GuoSheng
 * @Date 2022/9/16  19:07
 * @Version 1.0
 **/
public class MainGT03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        boolean res = true;
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(map.containsKey(s.charAt(i))){
                    if(stack.peek() == map.get(s.charAt(i))){
                        stack.pop();
                    }else{
                        res = false;
                        break;
                    }
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        System.out.println(res && stack.isEmpty());

    }
}
