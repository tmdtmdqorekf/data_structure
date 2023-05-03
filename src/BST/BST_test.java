package BST;

public class BST_test extends BinarySearchTree{
    public static void main(String[] args) {
        Dictionary<Integer, String> bst = new BinarySearchTree<>();

        //insert
        bst.insert(10, "A");
        bst.insert(5, "B");
        bst.insert(15, "C");
        bst.insert(3, "D");
        bst.insert(8, "E");

        //size
        System.out.println("Size: " + bst.size());

        //print
        System.out.println("Inorder: ");
        bst.inorder();

        //find
        System.out.println("Find key 10: " + bst.find(10));
        System.out.println("Find key 3: " + bst.find(3));
        System.out.println("Find key 100: " + bst.find(100));

        //remove
        System.out.println("Remove key 5: " + bst.remove(5));
        System.out.println("Remove any: " + bst.removeAny());

        //find
        System.out.println("Find key 5: " + bst.find(5));
        System.out.println("Find key 10: " + bst.find(10));
        System.out.println("Find key 15: " + bst.find(15));

        //print
        System.out.println("Inorder: ");
        bst.inorder();
    }
}