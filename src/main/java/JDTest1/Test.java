package JDTest1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Test
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/2  16:18
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        String ab = "aaabb";
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = ab.toCharArray();
        for (char aChar : chars) {
            if(map.containsKey(aChar)){
                map.put(aChar,map.get(aChar) + 1);
            }else{
                map.put(aChar,1);
            }
        }
        Set<Character> characters = map.keySet();
        for (Character character : characters) {
            System.out.println(character+ " : "+map.get(character));
        }
    }

    @org.junit.Test
    public void  test(){
        int n = 10;

                int[] dp = new int[n + 1];
                int[] weight = {1,2};
                dp[0] = 1;

                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j < weight.length; j++) {
                        if (i >= weight[j]) dp[i] += dp[i - weight[j]];
                    }
                }
        System.out.println(dp[n]);

        }
    
}
