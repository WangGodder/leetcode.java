package util;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: godder
 * @date: 2019/2/24
 */
public class BinTreeUtils {

    public static <T> List<T> TreeToList(TreeNode<T> root, T nullRespect) {
        if (root == null) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>();
        subTreeToList(root, list, nullRespect);
        for (int i = list.size() - 1; i > 0; i--) {
            if (!list.get(i).equals(nullRespect)) {
                break;
            }
            list.remove(i);
        }
        return list;
    }


    private static <T> void subTreeToList(@NotNull TreeNode<T> root, List<T> list, T nullRespect) {
        ArrayList<TreeNode<T>> nodes = new ArrayList<TreeNode<T>>();
        list.add(root.val);
        nodes.add(root);
        int nodeIncreaseNum = 1, notNullNodeIncreaseNum = 1;
        for (int i = 1; nodeIncreaseNum != 0; i += nodeIncreaseNum) {
            int addNum = 0, notNullAddNum = 0;
            for (int j = i - nodeIncreaseNum; j < i && notNullAddNum < notNullNodeIncreaseNum; j++) {
                TreeNode<T> node = nodes.get(j);
                if (node != null) {
                    nodes.add(node.left);
                    nodes.add(node.right);
                    if (nodeAddList(node.left, list, nullRespect)) {
                        notNullAddNum++;
                    }
                    if (nodeAddList(node.right, list, nullRespect)) {
                        notNullAddNum++;
                    }
                    addNum += 2;
                }
            }
            nodeIncreaseNum = addNum;
            notNullNodeIncreaseNum = notNullAddNum;
        }
    }

    private static <T> boolean nodeAddList(@NotNull TreeNode<T> node, List<T> list, T nullRespect) {
        if (node == null) {
            list.add(nullRespect);
            return false;
        } else {
            list.add(node.val);
            return true;
        }
    }


    public static <T> TreeNode<T> listToTree(List<T> list, T nullRespect) {
        if (list.isEmpty()) {
            throw new RuntimeException("list can not be null");
        }
        List<TreeNode<T>> nodes = new ArrayList<TreeNode<T>>(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(nullRespect)) {
                nodes.add(null);
                continue;
            }
            nodes.add(new TreeNode<T>(list.get(i)));
        }
        System.out.println(nodes);
        TreeNode<T> root = nodes.get(0);
        int lastReadNum = 1;
        for (int i = 1; i < nodes.size(); i += lastReadNum) {
            int readNum = 0;
            for (int j = i - lastReadNum; j < i && i + readNum < nodes.size(); j++) {
                if (nodes.get(j) == null) {
                    continue;
                }
                nodes.get(j).left = nodes.get(i + readNum++);
                if (i + readNum>= nodes.size()) {
                    break;
                }
                nodes.get(j).right = nodes.get(i + readNum++);
            }
            lastReadNum = readNum;
        }
        return root;
    }
}
