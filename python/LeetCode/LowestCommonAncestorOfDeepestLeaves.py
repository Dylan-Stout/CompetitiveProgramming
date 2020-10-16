# https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
#
# Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
# Recall that:
# The node of a binary tree is a leaf if and only if it has no children
# The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
# The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is
# in the subtree with root A.
# Note: This question is the same as 865: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
#
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def lcaDeepestLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root.left == None and root.right == None:
            return root

        parent, depth = self.get_lca(root, None, 0)
        return parent

    # recurse through tree until maximum depth attained
    def get_lca(self, cur_node, par_node, depth):
        # reached a child node
        if cur_node.left is None and cur_node.right is None:
            # return the parent and the depth achieved
            return par_node, depth

        # recurse through left and right subtrees and find their deepest parents and depth
        left_parent, left_depth, right_parent, right_depth = None
        if cur_node.left is not None:
            left_parent, left_depth = self.get_lca(cur_node.left, cur_node, depth + 1)
        if cur_node.right is not None:
            right_parent, right_depth = self.get_lca(cur_node.right, cur_node, depth + 1)

        # compare the left and right subtrees and return the deepest of the two
        # there was no left subtree return right
        if cur_node.left is None and cur_node.right is not None:
            return right_parent, right_depth
        # there was no right subtree return left
        if cur_node.right is None and cur_node.left is not None:
            return left_parent, left_depth
        # both subtrees have trees
        # compare the depths of two subtree's lca and return the max depth's parent and depth
        if left_depth >= right_depth:
            # the left subtree was larger
            return left_parent, left_depth
        else:
            # the right subtree was larger
            return right_parent, right_depth