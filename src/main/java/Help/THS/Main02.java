package Help.THS;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main02
 * @Description 组合问题
 *
 * @Author GuoSheng
 * @Date 2022/9/13  16:30
 * @Version 1.0
 **/
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int param = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while(param > 0){
            list.add(param % 10);
            param /= 10;
        }
        int ans = 0;
        Integer[] arr = list.toArray(new Integer[list.size()]);
        List<List<Integer>> allList = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTracking(allList,path,arr,arr.length);
        for (List<Integer> integers : allList) {
            int sum = 0;
            for (Integer integer : integers) {
                sum = sum * 10 + integer;
            }
            if(sum % k == 0 && sum != 0) ans++;
        }
        System.out.println(ans);
    }
    public static void backTracking(List<List<Integer>> list, LinkedList<Integer> path, Integer[] arr, int size){
        if(path.size() == size){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if (path.contains(arr[i])) {
                continue;
            }
            path.add(arr[i]);
            backTracking(list, path, arr, size);
            path.removeLast();
        }
    }


}
