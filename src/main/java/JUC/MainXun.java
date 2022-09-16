package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MainXun
 * @Description java多线程 多个线程交叉打印1到100的数字
 * 使用Condition进行等待和线程通知
 * @Author GuoSheng
 * @Date 2022/9/16  11:18
 * @Version 1.0
 **/
public class MainXun {

}
class Test77 {
    int num;
    static ReentrantLock lock= new ReentrantLock();
    static Condition c1 = lock.newCondition();
    static Condition c2 = lock.newCondition();
    static Condition c3 = lock.newCondition();

    private void printABC(int targetNum,Condition currentThread,Condition nextThread){
        while (true) {
            lock.lock();
            try {
                while (num % 3 != targetNum) {
                    currentThread.await();
                }
                if (num >= 100){
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName()+ "->" + num);
                nextThread.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }

    public static void main(String[] args) {
        Test77 test77 = new Test77();
        new Thread(()->{
            test77.printABC(0,c1,c2);
        },"A").start();

        new Thread(()->{
            test77.printABC(1,c2,c3);
        },"B").start();

        new Thread(()->{
            test77.printABC(2,c3,c1);
        },"C").start();
    }

}

