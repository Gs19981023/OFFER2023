package Offer2023.KuaiShou0905;

import javax.swing.tree.TreeNode;

/**
 * @ClassName MainCreatTree
 * @Description TODO
 * @Author GuoSheng
 * @Date 2022/9/7  15:12
 * @Version 1.0
 **/
public class MainCreatTree {
    public static void main(String[] args) {

    }
    public static TreeNodeKS getTree(int[] arr){
        if(arr.length == 0) return null;
        TreeNodeKS root = new TreeNodeKS();
        return root;
    }
}

class TreeNodeKS{
    int val;
    TreeNodeKS left;
    TreeNodeKS right;
}
