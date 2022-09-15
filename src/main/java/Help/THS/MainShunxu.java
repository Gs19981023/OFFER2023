package Help.THS;

/**
 * @ClassName MainShunxu
 * @Description 确保T1,T2,T3顺序执行
 * @Author GuoSheng
 * @Date 2022/9/5  11:18
 * @Version 1.0
 **/
public class MainShunxu {

    public static void main(String[] args) throws InterruptedException{

        ThreadJoin t1 = new ThreadJoin("t1"); // 累加操作
        ThreadJoin t2 = new ThreadJoin("t2"); // 累减操作
        ThreadJoin t3 = new ThreadJoin("t3");     // 计算盈亏

        t1.start();
        t1.join();

        t2.start();

        t3.start();

    }
}

class ThreadJoin extends Thread{
    public ThreadJoin(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(this.getName()+":"+i);
        }
    }
}


