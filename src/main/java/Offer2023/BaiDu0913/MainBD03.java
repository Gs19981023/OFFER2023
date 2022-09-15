package Offer2023.BaiDu0913;

import java.util.*;

/**
 * @ClassName MainBD01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/13  18:55
 * @Version 1.0
 **/
public class MainBD03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++){
            sc.nextLine();
        }

        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        set.add("for");
        set.add("if");
        set.add("{");
        set.add("}");
        List<String> paramList = new ArrayList<>();
        while(sc.hasNextLine()){
            paramList.add(sc.nextLine());
        }
        for(int i = 1; i < paramList.size() - 2; i++){
            String temp = paramList.get(i);
            String[] tempStringEvery = temp.split(" ");
            for(String s : tempStringEvery){
                if("for".equals(s)){
                    count++;
                }
                if(stack.isEmpty()){
                    if(set.contains(s)){
                        stack.push(s);
                    }
                }else{
                    while(!stack.isEmpty()){
                        if("{".equals(stack.peek()) && "}".equals(s)){
                            String lastOne = stack.pop();
                            String secondLastOne =stack.pop();
                            Iterator<String> iterator = stack.iterator();

                        }else{
                            stack.push(s);
                            break;
                        }
                    }
                }

            }

        }
        System.out.println(count / 2);

    }
}
class Main2{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
    }
}
