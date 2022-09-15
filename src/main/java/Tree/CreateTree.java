package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName CreateTree
 * @Description 根据数组构建二叉树
 * @Author GuoSheng
 * @Date 2022/9/15  16:02
 * @Version 1.0
 **/
public class CreateTree {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,null};
        TreeNode tree = createTree2(arr);

        System.out.println(tree);
    }

    public static TreeNode createTree(Integer[] arr){
        if(arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        // 根节点
        deque.offer(root);

        boolean isLeft = true;
        // 遍历每一个结点
        for(int i = 1; i < arr.length; i++){
            TreeNode peek = deque.getFirst();
            // 当前要给队头结点添加左孩子
            if(isLeft){
                if(arr[i] != null){
                    peek.left = new TreeNode(arr[i]);
                    deque.offer(peek.left);
                }
                // 下一回添加右孩子
                isLeft = false;
            }else{
                // 添加右孩子并入队
                if(arr[i] != null){
                    peek.right = new TreeNode(arr[i]);
                    deque.offer(peek.right);
                }
                // 由于添加了右孩子，当前队首结点不能再添加孩子了，队首元素出队。
                deque.pollFirst();
                isLeft = true;
            }
        }
        return root;
    }






    public static TreeNode createTree2(Integer[] arr){
        if(arr.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        boolean isLeft = true;
        queue.offer(root);
        for(int i = 1; i < arr.length; i++){
            TreeNode peek = queue.peek();

            if(isLeft){
                if(arr[i] != null){
                    peek.left = new TreeNode(arr[i]);
                    queue.offer(peek.left);
                }
                isLeft = false;
            }else{
                if(arr[i] != null){
                    peek.right = new TreeNode(arr[i]);
                    queue.offer(peek.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    TreeNode(){}
    TreeNode(int val){ this.val = val;}



}
