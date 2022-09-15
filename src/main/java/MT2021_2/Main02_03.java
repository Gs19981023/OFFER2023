package MT2021_2;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main02_03
 * @Description 旅游次数，根据起始位置，计算首位串起来后总共的旅行次数，其实就是找有几个环
 * 找环数目题
 * 题目地址是按照时间顺序给出的，所以直接正常遍历即可。
 * 如果是找环就DFS
 * @Author GuoSheng
 * @Date 2022/8/23  23:27
 * @Version 1.0
 **/
public class Main02_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        String[] pos;
        String start = "";
        for(int i = 0; i < n; i++){
            pos = br.readLine().split(" ");
            String start1 = pos[0];
            String target = pos[1];
            if(start.equals("")){
                start = start1;
            }
            if(start.equals(target)){
                count++;
                start = "";
            }
        }
        System.out.println(count);
    }
}
