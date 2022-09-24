package JUC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @ClassName SingleTon
 * @Description 单例模式
 * 五种写法：（本篇使用了双重校验锁）
 * 1.懒汉式
 * 2.懒汉+线程安全synchronized锁方法
 * 3.双重校验锁+禁止指令重排序
 * 4.枚举实现
 * 5.静态内部类+static final方法
 * @Author GuoSheng
 * @Date 2022/8/30  22:02
 * @Version 1.0
 **/
public class SingleTon {
    private volatile static SingleTon singleTon;   //防止指令重排序导致线程安全问题
    public SingleTon(){};
    public static SingleTon getSingleTon(){
        if(singleTon == null){
            synchronized (SingleTon.class){
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

}

/***
 *@author GuoSheng
 *@Description 静态内部类
 *@Date 01:06   2022/9/23
**/

class Singleton1 {
    private static class SingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }
    private Singleton1 (){}
    public static final Singleton1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/***
 *@author GuoSheng
 *@Description 枚举实现
 *@Date 01:07   2022/9/23
**/
enum EasySingleton{
    INSTANCE;
}

/***
 *@author GuoSheng
 *@Description 验证单例模式和破坏单例模式
 *@Date 01:23   2022/9/23
**/
class Test{
    public static void main(String[] args) throws Exception {
        SingleTon s1 = SingleTon.getSingleTon();
        SingleTon s12 = SingleTon.getSingleTon();
        System.out.println(s1 == s12);  // true
        poHuai1();
    }


    // 通过反射破坏单例模式
    public static void poHuai1() throws Exception{
        SingleTon instance = SingleTon.getSingleTon();
        //通过反射获取构造参数
        Constructor<SingleTon> constructor = SingleTon.class.getDeclaredConstructor();
        //将构造函数设置成可访问的类型
        constructor.setAccessible(true);
        //调用构造函数创建一个对象
        SingleTon instance1 = constructor.newInstance();
        System.out.println(instance == instance1); //false
    }

    // 通过序列化与反序列化破坏单例模式
    public static void poHuai2() throws Exception {
        //将对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(SingleTon.getSingleTon());

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tempFile"));
        SingleTon singletonLH = (SingleTon) ois.readObject();
        System.out.println(singletonLH == SingleTon.getSingleTon()); //false
    }

}
