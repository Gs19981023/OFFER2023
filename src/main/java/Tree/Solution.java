package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description
 * @Author GuoSheng
 * @Date 2022/9/15  17:58
 * @Version 1.0
 **/

// 二叉树的最近公共祖先
    // 哈希表存储父子结点之间的关系
public class Solution {
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root);
        while(p != null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while(q != null){
            if(!visited.contains(q.val)){
                q = parent.get(q.val);
            }else{
                return q;
            }
        }
        return null;
    }

    public void DFS(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            parent.put(root.left.val, root);
            DFS(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val, root);
            DFS(root.right);
        }
    }
}
