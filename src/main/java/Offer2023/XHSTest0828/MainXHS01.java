package Offer2023.XHSTest0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName MainXHS01
 * @Description 国王排队，id和value进行二维排队
 * @Author GuoSheng
 * @Date 2022/8/28  15:53
 * @Version 1.0
 **/
public class MainXHS01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int id = Integer.parseInt(s1[2]);
        String[] temp;
        List<NodeXHS> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            temp = br.readLine().split(" ");
            int sum = 0;
            for(int j = 0; j < m; j++){
                sum += Integer.parseInt(temp[j]);
            }
            list.add(new NodeXHS(i + 1,sum));
        }

        list.sort(new Comparator<NodeXHS>() {
            @Override
            public int compare(NodeXHS o1, NodeXHS o2) {
                // 权重从大到小
                if(o1.value != o2.value){
                    return o2.value - o1.value;
                }else{
                    // id从小到大
                    return o1.id - o2.id;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).id == id){
                System.out.println(i + 1);
            }
            System.out.println();
        }
    }
}
class NodeXHS{
    int id;
    int value;
    public NodeXHS(int id, int value){
        this.id = id;
        this.value = value;
    }
}
