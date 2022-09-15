import javax.xml.soap.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//2
//5
//1 2 4 0 8
//7
//1 2 4 8 0 256 0

/**
 * @ClassName MainZJ02
 * @Description 获取数组连续最大乘积
 * @Author GuoSheng
 * @Date 2022/8/28  09:59
 * @Version 1.0
 **/
public class MainZJ02 {
    public static void main(String[] args) throws IOException {
        List<int []> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int templetNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < templetNum; i++){
            int n = Integer.parseInt(br.readLine());
            String[] param = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int j = 0; j < n; j++){
                nums[j] = Integer.parseInt(param[j]);
            }
            list.add(nums);
        }

        for (int[] ints : list) {
            int max = getIndex(ints);
            List<NodeZj> list1 = new ArrayList<>();
            for (NodeZj nodeZj : nodeList) {
                if(nodeZj.value == max){
                    list1.add(nodeZj);
                }
            }
            // x最小排序
            list1.sort(new Comparator<NodeZj>() {
                @Override
                public int compare(NodeZj o1, NodeZj o2) {
                    return o1.startIndex - o2.startIndex;
                }
            });
            int minx = 0, miny = 0;
            int sum = 1;
            minx = list1.get(0).startIndex;
            // 如果有多个相同的x，排序y最小
            for (NodeZj nodeZj : list1) {
                if(minx == nodeZj.startIndex){
                    sum++;
                }
                if(sum > 1){
                    list1.sort(new Comparator<NodeZj>() {
                        @Override
                        public int compare(NodeZj o1, NodeZj o2) {
                            return o1.endIndex - o2.endIndex;
                        }
                    });
                    break;
                }
            }

            System.out.println(list1.get(0).startIndex + 1 + " " +(list1.get(0).endIndex + 1));

        }
    }
    static List<NodeZj> nodeList = new ArrayList<>();
    public static int getIndex(int[] nums){
        nodeList = new ArrayList<>();
        NodeZj maxNode = new NodeZj(0,0,0);
        int max = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                continue;
            }
            maxNode = new NodeZj(i,i,nums[i]);
            nodeList.add(maxNode);
            max = 1;
            max *= nums[i];
            for(int j = i + 1;j < nums.length; j++){
                if(nums[j] == 0){
                    break;
                }else{
                    max *= nums[j];
                    res = Math.max(max,res);
                    if(res == max){
                        maxNode = new NodeZj(i,j,max);
                        nodeList.add(maxNode);
                    }
                }
            }
        }
        return max;
    }
}
class NodeZj{
    int startIndex;
    int endIndex;
    int value;
    public NodeZj(int startIndex,int endIndex,int value){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.value = value;
    }
}
