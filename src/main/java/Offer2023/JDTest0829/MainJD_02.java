package Offer2023.JDTest0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName MainJD02
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/27  18:58
 * @Version 1.0
 **/
public class MainJD_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 长城数组的大小
        String[] params = br.readLine().split(" ");
        int[] paramsNum = new int[n];
        for(int i = 0; i < n; i++){
            paramsNum[i] = Integer.parseInt(params[i]);
        }
        int ans = minOprCount(paramsNum);
        System.out.println(ans);

    }

    public static int minOprCount(int[] params){
        if(params.length == 1) return 0;
        int n = params.length;
        int oddIndex = 0, newIndex = 0;
        int temp = 0;
        Set<Integer> oddset = new HashSet<>();
        Map<Integer,Integer> oddMap = new HashMap<>();
        for(int i = 0; i < n; i += 2){
            oddIndex++;
            oddset.add(params[i]);
            oddMap.putIfAbsent(params[i],0);
            int temp1 = oddMap.get(params[i]) + 1;
            // 更新Map操作
            oddMap.put(params[i], temp1);
        }
        Set<Integer> newSet = new HashSet<>();
        Map<Integer,Integer> newMap = new HashMap<>();
        for(int j = 1; j < n; j += 2){
            newIndex++;
            newSet.add(params[j]);
            newMap.putIfAbsent(params[j], 0);
            int temp2 = newMap.get(params[j]) + 1;
            newMap.put(params[j],temp2);
        }
        List<NodeJd> nodeOddList = new ArrayList<>();
        Iterator<Integer> oddItr = oddset.iterator();
        while(oddItr.hasNext()){
            Integer nextOdd = oddItr.next();
            nodeOddList.add(new NodeJd(nextOdd,oddMap.get(nextOdd)));
        }
        nodeOddList.sort(new Comparator<NodeJd>() {
            @Override
            public int compare(NodeJd o1, NodeJd o2) {
                return o2.count - o1.count;
            }
        });

        List<NodeJd> nodeNewList = new ArrayList<>();
        Iterator<Integer> newItr = newSet.iterator();
        while(newItr.hasNext()){
            Integer nextNew = newItr.next();
            nodeNewList.add(new NodeJd(nextNew,newMap.get(nextNew)));
        }
        nodeNewList.sort(new Comparator<NodeJd>() {
            @Override
            public int compare(NodeJd o1, NodeJd o2) {
                return o2.count - o1.count;
            }
        });

        if(nodeOddList.get(0).number == nodeNewList.get(0).number){
            if(oddset.size() == newSet.size() && oddset.size() == 1){
                return Math.min(oddIndex,newIndex);
            }
            if(oddset.size() == 2 && newSet.size() == 1){
                return nodeOddList.get(0).count;
            }
            if(oddset.size() == 1 && newSet.size() == 2){
                return nodeNewList.get(0).count;
            }
            return Math.min(oddIndex - nodeOddList.get(1).count,oddIndex - nodeNewList.get(1).count + newIndex - nodeOddList.get(0).count);
        }else{
            return oddIndex - nodeOddList.get(0).count + newIndex - nodeNewList.get(0).count;
        }

    }

}
class NodeJd{
    int number;
    int count;

    public NodeJd(int number,int count){
        this.number = number;
        this.count = count;
    }
}

