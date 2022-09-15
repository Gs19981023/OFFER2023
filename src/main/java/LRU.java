import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRU
 * @Description LRU算法实现，
 * @Author GuoSheng
 * @Date 2022/8/31  00:55
 * @Version 1.0
 **/
public class LRU {
}


class Solution {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int used;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public Solution(int capacity) {
        // write code here
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.used = 0;
    }

    public int get(int key) {
        // write code here
        if (!map.containsKey(key)) {
            return -1;
        }

        makeRecently(key);

        return map.get(key).value;
    }

    public void set(int key, int value) {
        // 如果 key 已存在，直接修改值，再移到链表头部
        if (map.containsKey(key)) {
            map.get(key).value = value;
            makeRecently(key);
            return;
        }

        // 如果达到容量上限，就要移除尾部节点，注意 HashMap 要 remove！！！
        if (used == capacity) {
            map.remove(tail.key);
            tail = tail.prev;
            tail.next = null;
            used--;
        }
        // 头节点为空，单独处理
        if (head == null) {
            head = new Node(key, value, null, null);
            tail = head;
        }
        else {
            Node t = new Node(key, value, null, head);
            head.prev = t;
            head = t;
        }
        map.put(key, head);

        used++;
    }

    // 把 key 对应的节点移到链表头部
    private void makeRecently(int key) {
        Node t = map.get(key);
        if (t != head) {
            if (t == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                t.prev.next = t.next;
                t.next.prev = t.prev;
            }

            t.prev = null;
            t.next = head;
            head.prev = t;
            head = t;
        }
    }
}
class Solution1{
    private int capacity;
    private Map<Integer,LRUCache> map;
    private LRUCache head;
    private LRUCache tail;
    private int used;
    class LRUCache{
        int key;
        int value;
        LRUCache pre;
        LRUCache next;
        LRUCache(int key,int value,LRUCache pre,LRUCache next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        // 让当前的key为活跃key
        makeRecently(key);
        return map.get(key).value;
    }
    public void set(int key, int value){
        if(map.containsKey(key)){
            map.get(key).value = value;
            makeRecently(key);
            return;
        }
        // 使用到达容量
        if(used == capacity){
            // 删除最后一个
            map.remove(tail.key);
            tail = tail.pre;
            tail.next = null;
            used--;
        }
        if(head == null){
            head = new LRUCache(key,value,null,null);
            tail = head;
        }else{
            // 添加到最前面的head前面。
            LRUCache temp = new LRUCache(key,value,null,head);
            head.pre = temp;
            head = temp;
        }
        map.put(key,head);
        used++;
    }
    // 将key值移动到链表的最前面
    private void makeRecently(int key){
        LRUCache temp = map.get(key);
        if(temp != head){
            if(temp == tail){
                tail = tail.pre;
                tail.next = null;
            }
            else{
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            }
            temp.pre = null;
            temp.next = head;
            head.pre = temp;
            head = temp;
        }
    }

}

