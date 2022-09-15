package Help.ZX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.concurrent.Callable;

/**
 * @ClassName Main01ZX
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/1  19:28
 * @Version 1.0
 **/
public class Main01ZX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String s1 = s[0];
        String s2 = s[1];
        LinkedList<Character> list = new LinkedList<>();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (Character c : chars2) {
            list.add(c);
        }
        for (Character c : chars1) {
            list.remove(c);
        }
        System.out.println(list.getLast().toString());
    }
}
class MyThread2 implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}
class MyThread3 implements Runnable{
    @Override
    public void run() {

    }
}


class Test{
    public static void main(String[] args) throws Exception {
        MyThread2 t2 = new MyThread2();
        Object call = t2.call();

    }
}
