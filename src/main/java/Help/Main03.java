package Help;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Main03
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/23  19:21
 * @Version 1.0
 **/
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> params = new ArrayList<>();
        for(int i = 0; i < n; i++){
            params.add(sc.nextLine());
        }
        for (String param : params) {
            finalString = "";
            DFS(param, 0, new boolean[param.length()]);
            System.out.println(finalString.equals("") ? "No":finalString);
        }
    }

    static String  finalString = "";
    public static void DFS(String str,int idx,boolean[] used){
        finalString = "";
        if(idx >= str.length()){
            if(isOK(str)  && !finalString.equals("")){
                finalString = str;
            }
            return;
        }
        if(str.charAt(idx) != '?'){
            DFS(str,idx+1,used);
        }else{
            StringBuilder tempS = new StringBuilder(str);
            tempS.setCharAt(idx,'r');
            str = tempS.toString();
            DFS(str,idx + 1,used);
            str = tempS.toString();
            tempS.setCharAt(idx,'e');
            DFS(str,idx + 1,used);
            tempS.setCharAt(idx,'d');
            str = tempS.toString();
            DFS(str,idx + 1,used);
        }
    }


    public static boolean isOK(String str){

        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length() - 3; i++){
            set = new HashSet<>();
            for(int j = i; j <= i + 2; j++){
                if(set.contains(str.charAt(j))) return false;
                set.add(str.charAt(j));
            }
        }
        return true;
    }

    @Test
    public void test(){
        boolean b = isOK("rrdredred");
        System.out.println(b);
    }

}
