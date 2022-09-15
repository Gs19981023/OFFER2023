import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Mian082304
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/8/24  22:14
 * @Version 1.0
 **/
public class Mian082304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        String[] two = br.readLine().split(" ");
        String res = "";
        NodeMerge head = new NodeMerge(-1);
        NodeMerge cur;
        cur = new NodeMerge(Integer.parseInt(one[0]));
        head.next = cur;
        for(int i = 1; i < one.length; i++){
            cur.next = new NodeMerge(Integer.parseInt(one[i]));
        }
    }
}

class NodeMerge{
    public int value;
    public NodeMerge next;

    public NodeMerge(int value){
        this.value = value;
    }
}
