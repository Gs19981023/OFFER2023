import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Main_Test_01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/27  16:33
 * @Version 1.0
 **/
public class Main_Test_01 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        int n = Integer.parseInt(one[0]);
        int m = Integer.parseInt(one[1]);
        String str = br.readLine();
        String cont = br.readLine();
        getRes(str, cont);
        System.out.println(count);

    }

    public static int getRes(String str,String cont){
        int startOfStr = 0;
        int expireEnd = 0;
        while(startOfStr <= str.length() - cont.length()){
            expireEnd = startOfStr + cont.length();
            for(int i = 0; i < cont.length(); i++){
                if(str.charAt(startOfStr) == cont.charAt(i) || cont.charAt(i) == '*'){
                    startOfStr++;
                }else{
                    break;
                }
            }
            if(expireEnd == startOfStr){
                count++;
            }
        }
        return count;
    }

}
