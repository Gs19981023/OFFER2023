package Help.JUC;

/**
 * @ClassName Demo01Ticket
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/11  01:34
 * @Version 1.0
 **/
public class Demo01Ticket {
    public static void main(String[] args) {
        TicketRunnableImpl tck=new TicketRunnableImpl();
        Thread thread1= new Thread(tck,"窗口1");
        Thread thread2 = new Thread(tck,"窗口2");
        Thread thread3 = new Thread(tck,"窗口3");
        // 同时卖票
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
