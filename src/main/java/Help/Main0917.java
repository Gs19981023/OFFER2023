package Help;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main0917
 * @Description 情报
 * @Author GuoSheng
 * @Date 2022/9/17  15:40
 * @Version 1.0
 **/
public class Main0917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 1; i <= n / 2; i++){
            if(i * isOk(i) == n){
                count++;
                list.add(i);
            }
        }
        System.out.println(count);
        for(int t : list){
            System.out.print(t + " ");
        }
    }
    public static int isOk2(int num){
        int count = 0;
        while(num > 0){
            if(((num >> 1) & 1) == 1) count++;
            num = num / 2;
        }
        return count;
    }

    public static int isOk(int num){
        int count = 0;
        while(num > 0){
            if(num % 2 == 1){
                count++;
            }
            num /= 2;
        }
        return count;
    }
}
