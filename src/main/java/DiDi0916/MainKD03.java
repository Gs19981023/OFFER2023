package DiDi0916;

import java.util.*;

/**
 * @ClassName MainKD03
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/17  20:27
 * @Version 1.0
 **/
public class MainKD03 {
    int k;
    public int get(){
        return this.k;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextLine().split(" "));
        }
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int res = -1;
        for(int i = 0; i < n - 1; i++){
            String[] str1 = list.get(i);
            int length = str1.length;
            int sum = Integer.parseInt(str1[length - 1]);
            for(int j = 0; j < str1.length - 1; j+=2){
                if(str1.equals("iflytek")){
                    map1.put(str1[j], Integer.valueOf(str1[j + 1]));
                }else{
                    map2.put(str1[j], Integer.valueOf(str1[j + 1]));
                }
            }
            String[] str2 = list.get(i + 1);
//            for(int j = 0; j < str2.length - 1; j+=2){
//                if(map2.c)
//            }
        }
    }
}
