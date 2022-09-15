package Offer2023.MT93;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName Mian9304
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/3  11:09
 * @Version 1.0
 **/
public class Mian9304 {
    static List<MTNode> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] params = br.readLine().split(" ");
        int[] nums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = Integer.parseInt(params[i]);
        }
        String nodes = br.readLine();
        MTNode root = creatTree(nums,nodes);
        list = new ArrayList<>();
        deep(root);
        list.sort(new Comparator<MTNode>() {
            @Override
            public int compare(MTNode o1, MTNode o2) {
                return o1.idx - o2.idx;
            }
        });
        for (MTNode mtNode : list) {
            System.out.print(mtNode.type + " ");
        }
    }
    public static Set<Character> deep(MTNode root){
        if(root == null) return new HashSet<>();
        Set<Character> setLeft = deep(root.left);
        Set<Character> setRight = deep(root.right);
        setLeft.addAll(setRight);
        setLeft.add(root.value);
        root.type = setLeft.size();
        list.add(root);
        return setLeft;
    }
    public static MTNode creatTree(int[] nums,String nodes){
        Map<Integer,MTNode> map = new HashMap<>();
        MTNode root = new MTNode(1,nodes.charAt(0));
        map.put(1,root);
        for(int i = 0; i < nums.length; i++){
            MTNode parent = map.get(nums[i]);
            MTNode child = new MTNode(i + 2,nodes.charAt(i + 1));
            map.put(i + 2, child);
            if(parent.left == null){
                parent.left = child;
                continue;
            }
            parent.right = child;
        }
        return root;
    }
}

class MTNode{
    int idx;
    int type;
    char value;
    MTNode left;
    MTNode right;
    public MTNode(int idx,char value){
        this.idx = idx;
        this.value = value;
    }
}
