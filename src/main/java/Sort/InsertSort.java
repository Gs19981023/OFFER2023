package Sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/15  14:21
 * @Version 1.0
 **/
public class InsertSort {
    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        int temp[]=new int[a.length];
        for(int i = 0; i < a.length; i++){
            int insertValue=a[i];
            int insertIdx = i - 1;
            while(insertIdx >= 0 && insertValue < a[insertIdx]){
                a[insertIdx + 1] = a[insertIdx];
                insertIdx--;
            }
            a[insertIdx + 1] = insertValue;
        }


        System.out.println(Arrays.toString(a));
    }

}
