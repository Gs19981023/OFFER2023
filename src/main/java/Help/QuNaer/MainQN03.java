package Help.QuNaer;

import java.util.Scanner;

/**
 * @ClassName MainQN03
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/21  17:07
 * @Version 1.0
 **/
public class MainQN03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = new int[s.length()];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
    }
}
