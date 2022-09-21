import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeadOverflow
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/18  20:04
 * @Version 1.0
 **/
public class HeadOverflow {
    private int i;
    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(new Byte[1024 * 1024]);//每次1M
                i++;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("次数: " + i);
        }
    }
    }