package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: godder
 * @date: 2019/2/24
 */
public class BinTreeUtilsTest {

    @Test
    public void treeToList() {
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(8);
        List<Integer> list = BinTreeUtils.TreeToList(root, 0);
        System.out.println(list);
    }

    @Test
    public void listToTree() {
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(8);
        List<Integer> list = BinTreeUtils.TreeToList(root, 0);
        TreeNode<Integer> newRoot = BinTreeUtils.listToTree(list, 0);
        Assert.assertEquals(newRoot.val, new Integer(10));
        Assert.assertEquals(newRoot.left.val, new Integer(5));
        Assert.assertEquals(newRoot.left.right.val, new Integer(8));
        Assert.assertEquals(newRoot.right.val, new Integer(15));
    }
}