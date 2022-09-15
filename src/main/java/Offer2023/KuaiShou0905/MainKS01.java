package Offer2023.KuaiShou0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName MainKS01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/5  16:49
 * @Version 1.0
 **/
public class MainKS01 {
    public static void main(String[] args){
        boolean op = isPalindrome(new String("P"));
        System.out.println(op);
//        Character.isDigit()

    }
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(Character c : chars){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int left = 0, right = sb.length() - 1;
        while(left < right){
            if(sb.charAt(left++) != sb.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
class Test{
    List<List<Character>> list = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();
    public int countSubstrings(String s) {
        int res = s.length();
        int n = s.length();
        boolean[] used = new boolean[n];
        DFS(s,list,path,used,0);
        int ans = 0;
        for(List<Character> listOne : list){
            if(isvalid(listOne)) ans++;
        }
        return ans;
    }

    public static void DFS(String s, List<List<Character>> list, LinkedList<Character> path, boolean[] used, int idx){
        list.add(new ArrayList<>(path));
        if(idx >= s.length()) return;
        for(int i = idx; i < s.length(); i++){
//            if(i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) continue;
            path.add(s.charAt(i));
            used[i] = true;
            DFS(s,list,path,used,i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
    public static boolean isvalid(List<Character> list){
        int n = list.size();
        if(n == 0) return false;
        if(n == 1) return true;
        int left = 0, right = list.size() - 1;
        while(left < right){
            if(list.get(left) != list.get(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Test t = new Test();
        int aaa = t.countSubstrings("aaa");
        System.out.println(aaa);
    }
}

class HuiSu{
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        HuiSu h = new HuiSu();
        System.out.println(h.subsets(new int[]{1, 1, 1}));
    }
}
