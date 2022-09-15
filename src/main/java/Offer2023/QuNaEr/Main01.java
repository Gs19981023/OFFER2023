package Offer2023.QuNaEr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/7  17:04
 * @Version 1.0
 **/
public class Main01 {
    @Test
    public void test(){
        String s = "A12";
        String substring = s.substring(1, s.length());
        System.out.println(substring);
    }
}
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.showDown("SA SK SQ SJ S10 H10 C9");
        System.out.println(s1);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 翻牌
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    public String showDown (String inHand) {
        // write code here
        String ans = "GaoPai";
        List<List<Character>> lists = toList(inHand);
        if(isDuiZi(lists) == 1){
            ans = "YiDui";
        }
        int count = 2;
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i).size() >= 2) count--;
            if(count == 0)
            {
                ans = "LiangDui";
                break;
            }
        }
        if(isSantiao(lists)) ans = "SanTiao";
        if(!"".equals(isShunZi(lists))) ans = "ShunZi";
        if(isTonghua(lists)) ans = "TongHua";
        if(isDuiZi(lists) == 1 && isSantiao(lists)) ans = "HuLu";
        for(List<Character> tempList : lists){
            if(tempList.size() >= 4){
                ans = "SiTiao";
                break;
            }
        }
        if(isShunZi(lists).equals("shunzi") && isTonghua(lists)){
            ans = "TongHuaShun";
        }
        if(isShunZi(lists).equals("HuangJia") && isTonghua(lists)){
            ans = "HuangJiaTongHuaShun";
        }
        return ans;
    }

    public static List<List<Character>> toList(String inHand){
        List<List<Character>> list = new ArrayList<>();
        for(int i = 0; i < 13; i++){
            list.add(new ArrayList<>());
        }
        String[] str = inHand.split(" ");
        int idx = 0;
        for(String s : str){
            String substring = s.substring(1, s.length());
            if(substring.length() > 1){
                int shi = substring.charAt(0) - '0';
                int ge = substring.charAt(1) - '0';
                list.get(shi*10 + ge - 1).add(s.charAt(0));
            }else{
                char ch = substring.charAt(0);
                switch(ch){
                    case 'A' : idx = 0; break;
                    case 'K' : idx = 12; break;
                    case 'Q' : idx = 11; break;
                    case 'J' : idx = 10; break;
                    default : idx = ch - '0' - 1;
                }
                list.get(idx).add(s.charAt(0));
            }
        }
        return list;
    }
    // 判断其是否为同花
    private boolean isTonghua(List<List<Character>> lists){
        int[] nums = new int[4];
        for(List<Character> tempList : lists){
            for(char c : tempList){
                if(c == 'S'){
                    nums[0]++;
                }else if(c == 'H'){
                    nums[1] ++;
                }else if(c == 'C'){
                    nums[2]++;
                }else{
                    nums[3]++;
                }
            }
        }
        for(int n : nums){
            if(n >= 5) return true;
        }
        return false;
    }
    // 判断其是否为对子
    private int isDuiZi(List<List<Character>> lists){
        int duiZiNum = 0;
        // 判断对子的个数
        for(List<Character> tempList : lists){
            if(tempList.size() / 2 > 0) duiZiNum += tempList.size() / 2;
        }
        return duiZiNum;
    }
    // 三条
    private boolean isSantiao(List<List<Character>> lists){
        int threeNum = 0;
        int oneNum = 0;
        for(List<Character> tempList : lists){
            if(tempList.size() == 3){
                threeNum++;
            }else if(tempList.size() == 1){
                oneNum++;
            }
        }
        return threeNum == 1 && oneNum == lists.size() - 1;
    }
    private String isShunZi(List<List<Character>> lists){
        String shunZiNum = "";
        for(int i = 0; i <= 8; i++){
            if(lists.get(i).size() >= 1 && lists.get(i + 1).size() >= 1
                    && lists.get(i + 2).size() >= 1 && lists.get(i + 3).size() >= 1
                    && lists.get(i + 4).size() >= 1){
                shunZiNum = "shunzi";
                break;
            }
            if(lists.get(9).size() >= 1 && lists.get(i + 1).size() >= 1
                    && lists.get(i + 2).size() >= 1 && lists.get(i + 3).size() >= 1
                    && lists.get(i + 4).size() >= 1){
                shunZiNum = "HuangJia";
                break;

            }
        }
        return shunZiNum;
    }

}

