package MT2021_4;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Main04_3
 * @Description n个人，n条意向，n个能力排名，根据意向和能力排名进行意向和员工的分配。
 * @Author GuoSheng
 * @Date 2022/8/26  15:03
 * @Version 1.0
 **/
public class Main04_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] params;
        boolean[] choosed = new boolean[n + 1];
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            params = br.readLine().split(" ");
            for (int j = 0; j < params.length; j++) {
                if(!choosed[Integer.parseInt(params[j])]){
                    choosed[Integer.parseInt(params[j])] = true;
                    list.add(params[j]);
                    break;
                }
            }
        }
        for (String s : list) {
            System.out.println(s + " ");
        }
    }
}
