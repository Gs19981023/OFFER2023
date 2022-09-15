package Offer2023.YongYou;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/9  20:26
 * @Version 1.0
 **/
public class Main2 {
    public int[] findBuilding (int[] heights) {
        int[] R = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            R[i] = getLeft(heights, i) + getRight(heights, i) + 1;
        }
        return null;
    }

    private int getRight(int[] heights, int i) {
        int sum = 0;
        int max = 0;
        for(int j = i + 1; j < heights.length; j++){
            if(heights[j] > max){
                sum++;
                max = heights[j];
            }
        }
        return sum;
    }

    private int getLeft(int[] heights, int i) {
        int sum = 0;
        int max = 0;
        for(int j = i - 1; j >= 0; j--){
            if(heights[j] > max){
                sum++;
                max = heights[j];
            }
        }
        return sum;
    }

//    public static int[] get{
//        S
//    }

}
