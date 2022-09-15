package JUC;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName TicketRunnableImpl
 * @Description 卖票场景，多线程
 * @Author GuoSheng
 * @Date 2022/9/11  01:31
 * @Version 1.0
 **/
public class TicketRunnableImpl implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while(true){
            if(ticket>0)
                //使用sleep 模拟一下出票时间
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            // 当前线程对应的名字
            String name=Thread.currentThread().getName();
            System.out.println(name+"正在卖:"+ticket--);
        }
    }
}
/**
 * 三个窗口买票：共售100张票
 * 存在线程安全的问题
 * @author wds
 * @date 2021-11-15-20:30
 */
class ThreadTest04 {
    public static void main(String[] args) {
        Thread04 thread04 = new Thread04();
        Thread thread = new Thread(thread04, "窗口1");
        Thread thread1 = new Thread(thread04, "窗口2");
        Thread thread2 = new Thread(thread04, "窗口3");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
class Thread04 extends Thread{
    private static int ticket = 100;        //静态数据共享
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);          //模拟售票需要的时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在售票,票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
    @Test
    public void test1(){
        int[] num = new int[]{1,2,2};
        Arrays.asList(num);
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> all = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>();
        for(int i = 0; i < nums1.length; i++){
            path = new LinkedList<>();
            path.add(nums1[i]);
            for(int j = 0; j < nums2.length; j++){
                path.add(nums2[j]);
                all.add(new ArrayList<>(path));
                path.removeLast();
            }
        }
        for(List<Integer> list : all){
            queue.offer(new int[]{list.get(0), list.get(1)});
        }

        all = new ArrayList<>();
        for(int i = 0; i < k; i++){
            int[] temp = queue.poll();
            path = new LinkedList<>();
            path.add(temp[0],temp[1]);
            all.add(new ArrayList<>(path));
        }
        return all;

    }
    public void test(){
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(sb.length() - 1);
    }

}
class Solution {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        String an = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String s = replaceWords(dictionary, an);
        System.out.println(s);
        Map<Integer,Integer> map = new HashMap<>();
        int[] n = new int[2];


    }
    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] params = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(String s : params){
            if(dictionary.contains(s)){
                res.append(s);
                res.append(" ");
            }else{
                for(int i = 0; i < s.length(); i++){
                    if(dictionary.contains(s.substring(0,i + 1))){
                        res.append(s.substring(0,i + 1));
                        break;
                    }
                    if(i == s.length() - 1){
                        res.append(s);
                    }
                }
                res.append(" ");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr2.length; i++){
            map.put(arr2[i],i);
        }
        Arrays.stream(arr1).boxed().sorted((o1,o2)->{
            if(!map.containsKey(o1) && !map.containsKey(o2)){
                return o1 - o2;
            }else if(map.containsKey(o1) && map.containsKey(o2)){
                return map.get(o1) - map.get(o2);
            }else{
                return map.containsKey(o1) ? -1 : 1;
            }
        }).mapToInt(Integer::valueOf).toArray();
        return arr1;
    }
}



