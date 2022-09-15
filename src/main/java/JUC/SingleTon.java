package JUC;

/**
 * @ClassName SingleTon
 * @Description 单例模式
 * @Author GuoSheng
 * @Date 2022/8/30  22:02
 * @Version 1.0
 **/
public class SingleTon {
    private volatile SingleTon singleTon;
    public SingleTon(){};
    public SingleTon getSingleTon(){
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
