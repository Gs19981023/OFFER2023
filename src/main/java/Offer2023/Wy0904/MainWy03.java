package Offer2023.Wy0904;

import java.util.*;

/**
 * @ClassName MainWy03
 * @Description
 * 小红拿到了一个数组 a，每次操作小红可以选择数组中的任意一个数减去 x，
 * 小红一共能进行 k 次。小红想在 k 次操作之后，
 * 数组的最大值尽可能小。请你返回这个最大值。
 * @Author GuoSheng
 * @Date 2022/9/4  15:21
 * @Version 1.0
 **/
public class MainWy03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        int mod = (int) (Math.pow(10,9) + 7);
        System.out.println(minMax(list,k,x) % mod);
    }

    public static int minMax (ArrayList<Integer> a, int k, int x) {
        // write code here
        // 初始化数据
        ArrayList<Integer> alist = new ArrayList();
        alist.add(0);
        alist.addAll(a);

        // 建堆
        for (int i=alist.size()/2; i>0; i--) {
            adjust(alist,i,alist.size());
        }

        // k次操作，每次操作完重新建堆
        for (int j=k; j>0; j--) {
            alist.set(1,alist.get(1)-x);
            adjust(alist,1,alist.size());
        }
        return alist.get(1);
    }

    public static void adjust(ArrayList<Integer> arrayList, int k, int len) {

        arrayList.set(0,arrayList.get(k)); // 用arrayList[0]暂存子树的根节点

        for (int i = 2*k; i < len; i*=2) {  // 根顶元素下坠
            if(i+1 < len && arrayList.get(i) < arrayList.get(i+1)) { //左右子元素比较，取最大的子元素
                i++;
            }
            if( arrayList.get(0) >= arrayList.get(i) ) { // 父元素更大，不做处理
                break;
            } else {
                arrayList.set(k,arrayList.get(i));  // 将子元素替换父元素
                k = i;
            }
        }
        arrayList.set(k,arrayList.get(0));  //将被筛选的结点的值放入最终位置
    }

    public static int minMax2(ArrayList<Integer> a, int k, int x) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<a.size();i++){
            q.add(a.get(i));
        }
        for(int i=0;i < k;i++){
            int n=q.poll();
            n -= x;
            q.add(n);
        }
        return q.peek();
    }
}
