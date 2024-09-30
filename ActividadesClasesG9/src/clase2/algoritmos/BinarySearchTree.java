package clase2.algoritmos;

public class BinarySearchTree {

    // Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        if (root == null || root.value == x) {
            return root;
        }

        if (x < root.value) {
            return searchBST(root.left, x);
        }

        return searchBST(root.right, x);
    }
}

