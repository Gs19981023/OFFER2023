package Help;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @ClassName Main010
 * @Description 反转带符号的数字
 * @Author GuoSheng
 * @Date 2022/9/23  16:17
 * @Version 1.0
 **/
public class Main010 {
    public static void main(String[] args) {
        int main = main(9876543212L);
        System.out.println(main);
    }

    public static int main(long n) {
        String s = n + "";
        boolean flag = true;
        // 判断第一个字符是否是数字，如果是数字就是正数，正常反转
        // 如果不是数字就抛弃第一位后反转，最终进行符号附加。
        if(!Character.isDigit(s.charAt(0))) flag = false;
        StringBuilder temp = null;
        if(!flag){
            temp = new StringBuilder(s.substring(1,s.length()));
            System.out.println(temp.toString());
        }else{
            temp = new StringBuilder(s);
        }
        StringBuilder reverse = temp.reverse();
        if(reverse.length() > 32) return 0;
        int res = 0;
        res = Integer.parseInt(reverse.toString());
        return flag ? res : -res;
    }

    public int reverse (int x) {
        int ans = 0;
        while (x != 0) {
            // 判断溢出条件，如果当前只大于
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

}
