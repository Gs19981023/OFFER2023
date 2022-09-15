package MT2021_1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @ClassName Main03
 * @Description 相邻相同的数组进行合并后+1，并放回原位继续操作，两两相加获取操作次数的最大值。
 * 用左右栈的方式进行即可，入栈弹栈的方式进行消除后+1操作。
 * @Author GuoSheng
 * @Date 2022/8/22  22:19
 * @Version 1.0
 **/
public class Main03 {
    public static void main(String[] args) throws IOException {
        int nums = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        nums = Integer.parseInt(bf.readLine().trim());
        String[] arrStr = bf.readLine().trim().split(" ");
        Stack<Integer> stackLeft = new Stack<Integer>();
        Stack<Integer> stackRight = new Stack<Integer>();
        int oprNums = 0;
        int leftPeek,rightPeek;
        for(String s : arrStr){
            stackLeft.push(Integer.parseInt(s));
        }
        while(!stackLeft.isEmpty()){
            if(stackRight.isEmpty()){
                stackRight.push(stackLeft.pop());
            }else{
                leftPeek = stackLeft.peek();
                rightPeek = stackRight.peek();

                if(leftPeek == rightPeek){
                    leftPeek++;
                    rightPeek++;
                    stackRight.pop();
                    stackLeft.pop();
                    stackLeft.push(leftPeek);
                    stackRight.push(rightPeek);
                    oprNums++;
                }else{
                    stackRight.pop();
                    stackRight.push(stackLeft.pop());
                }
            }
        }
        System.out.println(oprNums);

    }


    /**
     *@author GuoSheng
     *@Description 正确答案，上面的答案70%
     *@Date 22:51   2022/8/22
    **/
    @Test
    public void zhengjie() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(bf.readLine().trim());
        String[] arrStr = bf.readLine().trim().split(" ");
        Stack<Integer> stackLeft = new Stack<Integer>();
        Stack<Integer> stackRight = new Stack<Integer>();
        int oprNums = 0;
        int leftPeek,rightPeek;
        for(String s : arrStr){
            stackLeft.push(Integer.parseInt(s));
        }
        while(!stackLeft.isEmpty()){
            while(stackLeft.peek() == stackRight.peek()){
                int x = stackLeft.pop() + 1;
                stackRight.pop();
                oprNums++;
                if(!stackRight.isEmpty()){
                    while(!stackRight.isEmpty() && stackRight.peek() == x){
                        stackRight.pop();
                        oprNums++;
                        x++;
                    }
                    stackRight.push(x);
                }else{
                    stackRight.push(x);
                }
            }
            stackRight.push(stackLeft.pop());
        }
        System.out.println(oprNums);
    }


}
