public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(18);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(22);

        System.out.print("In Order Traversal: ");
        tree.inOrder();
        System.out.println();
        System.out.print("Pre Order Traversal: ");
        tree.preOrder();
        System.out.println();

        System.out.println("Smallest value: " + tree.findMin());
        System.out.println("Largest value: " + tree.findMax());
        tree.delete(20);
        System.out.print("In Order Traversal: ");
        tree.inOrder();
    }
}