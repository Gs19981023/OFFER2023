package Offer2023.MeiDi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName MainMD01
 * @Description 采用队列的数据结构
 * @Author GuoSheng
 * @Date 2022/9/21  20:49
 * @Version 1.0
 **/
public class MainMD023 {
    public static void main(String[] args) {
        String[] sttr = new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        dirReduc(sttr);
    }

    public static String[] dirReduc (String[] arr) {
        // write code here
        StringBuilder temp = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                if(arr[i].equals("NORTH") && stack.getLast().equals("SOUTH") ||
                        arr[i].equals("SOUTH") && stack.getLast().equals("NORTH")||
                        arr[i].equals("EAST") && stack.getLast().equals("WEST") ||
                        arr[i].equals("WEST") && stack.getLast().equals("EAST")){
                    stack.removeLast();
                }else{
                    stack.push(arr[i]);
                }
            }
        }
        while(!stack.isEmpty()){
            temp.append(stack.pollFirst() + " ");
        }
        return temp.toString().split(" ");

    }
}
