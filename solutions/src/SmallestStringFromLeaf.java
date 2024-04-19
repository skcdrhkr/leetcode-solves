import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestStringFromLeaf {

    public static void main(String[] args) {
        // Case 1
        TreeNode root1 = TreeNode.createTree(new Integer[]{0, 1, 2, 3, 4, 3, 4});
        System.out.println(SmallestStringFromLeaf.smallestFromLeaf(root1));

        // Case 2
        root1 = TreeNode.createTree(new Integer[]{2,2,1,null,1,0,null,null,null,0,null});
        System.out.println(SmallestStringFromLeaf.smallestFromLeaf(root1));
    }

    public static String smallestFromLeaf(TreeNode root) {
        List<StringBuilder> sbs = getAllLeafs(root);
        Collections.sort(sbs, (a, b) -> (a.toString().compareTo(b.toString())));
        return sbs.get(0).toString();
    }

    private static List<StringBuilder> getAllLeafs(TreeNode root) {
        List<StringBuilder> cur = new ArrayList<>();
        List<StringBuilder> left = new ArrayList<>();
        List<StringBuilder> right = new ArrayList<>();
        if (root.left != null)
            left = getAllLeafs(root.left);
        if (root.right != null)
            right = getAllLeafs(root.right);
        for (StringBuilder sb : left) {
            sb.append((char) (root.val + 'a'));
        }
        for (StringBuilder sb : right) {
            sb.append((char) (root.val + 'a'));
        }
        cur.addAll(left);
        cur.addAll(right);
        if (cur.isEmpty()) {
            cur.add(new StringBuilder().append((char)(root.val+'a')));
        }
        return cur;
    }
}
