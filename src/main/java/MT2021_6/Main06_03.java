package MT2021_6;
import java.util.*;
/**
 * @ClassName Main06_01
 * @Description 照镜子
 * 寻找可能为上下对称的最小数组结果
 * @Author GuoSheng
 * @Date 2022/8/30  00:26
 * @Version 1.0
 **/
public class Main06_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // N行
        int M = scanner.nextInt(); // M列
        scanner.nextLine();
        int[][] matrix = new int[N][M];
        for(int i=0;i<N;i++){
            String line = scanner.nextLine();
            String[] chars = line.split(" ");
            for(int j=0;j<M;j++){
                matrix[i][j] = Integer.parseInt(chars[j]);
            }
        }
        if(N % 2 == 1){
            outPut(matrix, matrix.length);
        }else{
            int len = matrix.length;
            while(isFold(matrix,len/2)){
                len /= 2;
            }
            outPut(matrix,len);
        }
    }
    public static boolean isFold(int[][] matrix, int len){
        // upIndex从上往下遍历，downIndex从下往上遍历，第一行和最后一行进行逐一比较，如果相同就向中间靠近
        //
        int upIndex = 0, downIndex = len * 2 - 1;
        while(upIndex < len){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[upIndex][j] == matrix[downIndex][j]){
                    upIndex++;
                    downIndex--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void outPut(int[][] nums,int endIndex){
        for(int i = 0; i < endIndex; i++){
            for(int j = 0; j < nums[0].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

}
