package Offer2023.Souhu93;

/**
 * @ClassName MainSH01
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/3  19:59
 * @Version 1.0
 **/
public class MainSH02 {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
    }
}
class MyRunnable implements Runnable{


    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("hello" + i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
