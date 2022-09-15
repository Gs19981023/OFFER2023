package Offer2023.XHSTest0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MainXHS03
 * @Description
 *
 * @Author GuoSheng
 * @Date 2022/8/28  15:53
 * @Version 1.0
 **/
public class MainXHS03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // n个员工
        String[] params = br.readLine().split(" ");
        int[] peoples = new int[n - 1];
        Set<Integer> set = new HashSet<>();

        List<NodeXHSFriend> nodeList = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            peoples[i] = Integer.parseInt(params[i]);
            nodeList.add(new NodeXHSFriend(i + 2,peoples[i]));
        }
        int ans = 0;
        for (NodeXHSFriend node : nodeList) {
            int temp = ans;
            if(!set.contains(node.id) || !set.contains(node.friend)){
                set.add(node.id);
                set.add(node.friend);
                temp++;
            }else{

            }
            ans = Math.max(ans,temp);

        }
    }
}

class NodeXHSFriend{
    int id;
    int friend;
    public NodeXHSFriend(int id, int friend){
        this.id = id;
        this.friend = friend;
    }
}
