package MT2021_3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/24  13:11
 * @Version 1.0
 **/
public class Main03_1 {
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> leftList;
        // 货物数量
        int nums = Integer.parseInt(br.readLine());
        // w_i重量
        String[] w_i = br.readLine().split(" ");
        // 顺序编号
        String[] shunxu = br.readLine().split(" ");

    }


    @Test
    public void test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> integers = list.subList(0, 2);
        List<Integer> integers2 = list.subList(2, 4);
        System.out.println(integers.toString());
        System.out.println(integers2.toString());
    }
}
