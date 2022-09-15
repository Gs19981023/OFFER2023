package MT2021_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main04_2
 * @Description MT序列，寻找被加密的字符串S
 *  双指针法双向夹逼即可
 *  先找到左边的第一个M和右边的第一个T然后进行双向移动找到左边的第一个T和右边的第一个M即可
 * @Author GuoSheng
 * @Date 2022/8/26  14:29
 * @Version 1.0
 **/
public class Main04_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        // 先保证头部有一个M开头
        for(left = 0; left < n;left++){
            if(chars[left] == 'M'){
                left ++;
                break;
            }
        }
        for(right = chars.length - 1;right >=0;right--){
            if(chars[right] == 'T'){
                right--;
                break;
            }
        }
        while(!((chars[left] == 'T') && (chars[right] == 'M'))){
            if(chars[left] != 'T'){
                left++;
            }
            if(chars[right] != 'M'){
                right--;
            }
        }
        System.out.println(left+" "+right);
        String res = s.substring(left+1,right);
        System.out.println(res);

    }
}
