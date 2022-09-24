package Help;

import java.util.*;

/**
 * @ClassName MainSD01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/23  18:56
 * @Version 1.0
 **/
public class MainSD01 {
    public static void main(String[] args) {
        int[] ints = get(new int[]{1, 2, 2,3,3,4,4,501});
        for (int i : ints) {
            System.out.println(i);
        }

    }

    public static int[] get(int[] nums){
        int[] res = null;
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            if(i <= 0 || i > 500) {
                res = new int[0];
                return res;
            }
            if(!list.contains(i)){
                list.add(i);
            }
        }
        res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}
