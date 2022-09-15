package Offer2023.XiaoMi;

/**
 * @ClassName MainXM01
 * @Description 反转固定范围内的链表
 * @Author GuoSheng
 * @Date 2022/9/14  19:22
 * @Version 1.0
 **/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode<T> {
    public T data;
    public ListNode<T> next;
}

class Solution {

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> dum = new ListNode<>();
        dum.data = -1;
        dum.next = head;
        ListNode<Integer> pre = dum;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        ListNode<Integer> rightNode = pre;
        for(int i = 0; i < right - left + 1; i++){
            rightNode = rightNode.next;
        }
        Vector v = new Vector();
        ListNode<Integer> leftNode = pre.next;
        ListNode<Integer> cur = rightNode.next;

        rightNode.next = null;
        pre.next = null;

        reverse(leftNode);

        pre.next = rightNode;

        leftNode.next = cur;

        return dum.next;
    }
    private static void reverse(ListNode<Integer> head){
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        while(cur != null){
            ListNode<Integer> next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}

public class MainXM01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for(int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        res = new Solution().reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}
