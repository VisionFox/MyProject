package com.offer;

import java.util.Arrays;

public class No_4 {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 11, 11)));

    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //前序遍历：根左右   中序遍历：左根右   后序遍历：左右根
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }


        TreeNode root = new TreeNode(pre[0]);

//[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
        for (int i = 0; i < in.length; i++) {

            if (in[i] == pre[0]) {
                int leftLen = i;
                int rightLen = in.length - (i + 1);

                if (leftLen == 0) {
                    root.left = null;

                } else {
                    root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1+leftLen),
                            Arrays.copyOfRange(in, 0, i));
                }

                if (rightLen == 0 ) {
                    root.right = null;

                } else {
                    root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                            Arrays.copyOfRange(in, i + 1, in.length));
                }


            }

        }

        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
