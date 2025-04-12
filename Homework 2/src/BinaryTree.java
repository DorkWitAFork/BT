class BinaryNode {
    int data;
    BinaryNode left;
    BinaryNode right;


    public BinaryNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Boolean hasLeft() { return this.left != null; }
    public Boolean hasRight() { return this.right != null; }
    public Boolean isLeaf() { return (this.left == null) && (this.right == null); }

}

public class BinaryTree {
    BinaryNode root;


    public BinaryTree() {
        this.root = null;
    }

    public int findMin() {
        if (root == null) return -1;

        BinaryNode current = root;
        while (current.left != null)
            current = current.left;
        return current.data;
    }

    private BinaryNode findMinNode(BinaryNode root) {
        if (root == null) return null;

        BinaryNode current = root;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public int findMax() {
        if (root == null) return -1;

        BinaryNode current = root;
        while (current.right != null)
            current = current.right;

        return current.data;
    }

    private BinaryNode findMaxNode(BinaryNode root) {
        if (root == null) return null;

        BinaryNode current = root;
        while (current.right != null)
            current = current.right;
        return current;
    }



    public void insert(int data) {
        // BinaryNode newNode = new BinaryNode(data);
        root = insertRec(root, data);

    }

    private BinaryNode insertRec (BinaryNode root, int data) {
        if (root == null)
            root = new BinaryNode(data);
        else if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public void delete(int data) {
        root = deleteNode(root, data);
    }

    private BinaryNode deleteNode(BinaryNode root, int data) {
        BinaryNode current = root;
        if (current == null)
            return null;
        if (data < current.data)
            current.left = deleteNode(current.left, data);
        else if (data > current.data)
            current.right = deleteNode(current.right,data);
        else
            if (current.isLeaf())
                return null;
            else if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;
            else {
                BinaryNode successor = findMinNode(current.right);
                current.data = successor.data;
                current.right = deleteNode(current.right, successor.data);
            }

        return current;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(BinaryNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(BinaryNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void delete() {
        return;
    }

//    public BinaryNode search() {
//        return null;
//    }

}
