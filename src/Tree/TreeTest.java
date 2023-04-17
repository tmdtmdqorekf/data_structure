package Tree;

public class TreeTest {
    public static void main(String[] args){
        System.out.println("Test your trees here!");
        BinNode<String> node9 = new LeafNode<>("I");
        BinNode<String> node8 = new LeafNode<>("H");
        BinNode<String> node7 = new LeafNode<>("G");
        BinNode<String> node6 = new InternalNode<>("F", node8, node9);
        BinNode<String> node5 = new InternalNode<>("E", null, node7);
        BinNode<String> node4 = new LeafNode<>("D");
        BinNode<String> node3 = new InternalNode<>("C", null, node6);
        BinNode<String> node2 = new InternalNode<>("B", node4, node5);
        BinNode<String> node1 = new InternalNode<>("A", node2, node3);

        InternalNode<String> tree = new InternalNode(node1.element(), node1.left(), node1.right());

        System.out.println("Preorder:");
        TreeTest.preorder(node1);

        System.out.println("\nInorder:");
        TreeTest.inorder(node1);

        System.out.println("\nPostorder:");
        TreeTest.postorder(node1);
    }

    /* Implements your preorder, inorder and, postorder traversal functions here! */

    // preorder
    public static <E> void preorder(BinNode<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.element() + " ");
        preorder(node.left());
        preorder(node.right());
    }
    // inorder
    public static <E> void inorder(BinNode<E> node) {
        if (node == null) {
            return;
        }
        inorder(node.left());
        System.out.print(node.element() + " ");
        inorder(node.right());
    }
    // postorder
    public static <E> void postorder(BinNode<E> node) {
        if (node == null) {
            return;
        }
        postorder(node.left());
        postorder(node.right());
        System.out.print(node.element() + " ");
    }
}
