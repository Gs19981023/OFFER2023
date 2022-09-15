package Help.THS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MainT01
 * @Description 开启四个线程，倒序输出每个线程ID
 * @Author GuoSheng
 * @Date 2022/9/5  10:53
 * @Version 1.0
 **/
public class MainT01 {

    public static void main(String[] args) {
        final AlternateDemo ad = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopA();
                }
            }
        }, "1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopB();
                }
            }
        }, "2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopC();
                }
            }
        }, "3").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopD();
                }
            }
        }, "4").start();
    }

}

class AlternateDemo {

    private int number = 4; //当前正在执行线程的标记

    // 加锁的目的是使其线程安全
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Condition condition4 = lock.newCondition();

    public void loopA() {
        lock.lock();
        try {
            //1. 判断
            if (number != 1) {
                condition1.await();
            }
            //2. 打印
            System.out.print(Thread.currentThread().getName());
            //3. 唤醒
            number = 4;
            condition4.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();
        try {
            //1. 判断
            if (number != 2) {
                condition2.await();
            }
            //2. 打印
            System.out.print(Thread.currentThread().getName());
            //3. 唤醒
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            //1. 判断
            if (number != 3) {
                condition3.await();
            }
            //2. 打印
            System.out.print(Thread.currentThread().getName());
            //3. 唤醒
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void loopD() {
        lock.lock();
        try {
            //1. 判断
            if (number != 4) {
                condition4.await();
            }
            //2. 打印
            System.out.print(Thread.currentThread().getName());
            //3. 唤醒
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
