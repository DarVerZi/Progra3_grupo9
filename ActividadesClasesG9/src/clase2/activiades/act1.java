package clase2.activiades;
import clase2.algoritmos.BinarySearchTree;
import clase2.algoritmos.TreeNode;

public class act1 {
    private static int altura(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(root.left),
                    altura(root.right));
        }
    }
    public static void main(String[] args) {
        // Crear un árbol binario de búsqueda de ejemplo
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        // Calcular y mostrar la altura del árbol
        System.out.println("La altura del árbol es: " + altura(root));
    }
}
