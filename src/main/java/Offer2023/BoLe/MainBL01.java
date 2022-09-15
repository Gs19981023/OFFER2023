package Offer2023.BoLe;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainBL01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/14  15:10
 * @Version 1.0
 **/
public class MainBL01 {
    public static void main(String[] args) {
        String[] words = new String[]{"Data","from","Qunar","showed","longhaul","trips","faced","some","challenges","in","early","August"};
        int max = 20;
        ArrayList<String> compose = compose(words, 20);
        for (String s : compose) {
            System.out.println(s);
        }

    }

    public static ArrayList<String> compose (String[] words, int maxWidth) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        sb.append(words[0]);
        tempList.add(words[idx]);
        idx = 1;
        while(idx < words.length){
            if(sb.length() + words[idx].length() < 18){
                sb.append(words[idx]);
                tempList.add(words[idx]);
            }else{
                int nullNum = 20 - sb.length();
                boolean flag = false;
                int k = 0;
                if(tempList.size() > 1){
                    if(nullNum % (tempList.size() - 1) == 1){
                        flag = true;

                    }
                    k = (nullNum / (tempList.size() - 1)) + 1;
                }
                if(tempList.size() == 1){
                    flag = true;
                    k = 1;
                }
                StringBuilder sbTemp = new StringBuilder();
                sbTemp.append(tempList.get(0));
                if(flag){
                    for(int i = 0; i <= k; i++){
                        sbTemp.append(" ");
                    }
                }else{
                    for(int i = 0; i < k; i++){
                        sbTemp.append(" ");
                    }
                }
                if(tempList.size() > 1){
                    for(int i = 1; i < tempList.size() - 1; i++){
                        sbTemp.append(tempList.get(i));
                        for(int j = 0; j < k; j++){
                            sbTemp.append(" ");
                        }
                    }
                }
                res.add(sbTemp.toString());
                sb = new StringBuilder();
                sb.append(words[idx]);
                tempList = new ArrayList<>();
                tempList.add(words[idx]);
            }
            idx++;
        }
        int length = sb.length();
        while(sb.length() < 20){
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;

    }
}
