package com.dorjear.training.fundamental.hackerrank;

import java.util.List;
import java.util.stream.Stream;

public class TreeNodePlayer {
    public static Stream<TreeNode> convertToStream(TreeNode treeNode) {
        if (treeNode.getChildren() == null) return Stream.of(treeNode);
        return Stream.concat(Stream.of(treeNode), treeNode.getChildren().stream().flatMap(TreeNodePlayer::convertToStream));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode("node1");
        TreeNode node2 = new TreeNode("node2");
        TreeNode node3 = new TreeNode("node3");
        TreeNode node4 = new TreeNode("node4");
        TreeNode node5 = new TreeNode("node5");
        TreeNode node6 = new TreeNode("node6");
        TreeNode node7 = new TreeNode("node7");
        TreeNode node8 = new TreeNode("node9");
        TreeNode node9 = new TreeNode("node9");
        TreeNode node10 = new TreeNode("node10");

        node1.setChildren(List.of(node2,node3,node4));
        node2.setChildren(List.of(node5,node6,node7));
        node3.setChildren(List.of(node8,node9));
        node4.setChildren(List.of(node10));

        TreeNode.convertToNodeStream(node1).forEach(each -> System.out.println(each.getValue()));
    }
}
