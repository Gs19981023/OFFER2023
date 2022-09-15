package Offer2023.BaiDu0913;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName Main04
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/13  20:53
 * @Version 1.0
 **/
public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int ans = 0, count = 0;
        while(sc.hasNextLine()){
            int temp = get(sc.nextLine());
            if(temp == -1) continue;
            if(temp == 3){
                if(!stack.isEmpty()) {
                    Integer pop = stack.pop();

                    if (pop == 1) {
                        count--;
                    }
                }
            }
            if(temp == 1 || temp == 0){
                stack.push(temp);
                if(temp == 1){
                    count++;
                    ans = Math.max(ans,count);
                }
            }

        }
        System.out.println(ans);


    }
    private static int get(String param){
        if(param.indexOf("}") != -1) return 3;
        int idx = param.indexOf("{");
        if(idx == -1) return -1;
        int b = param.indexOf("for");
        if(b != -1) return 1;
        return 0;
    }
}
