

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public boolean contains(T x) {
        Node<T> cur = root;
        int state = cur.value.compareTo(x);
        while (cur != null) {
            if (state == 0) {
                return true;
            } else if (state > 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
            state = cur.value.compareTo(x);
        }
        return false;
    }

    public void add(T x) {
        boolean f = false;
        if (root == null) {
            root = new Node<T>(x);
            f = true;
        }
        Node<T> cur = root;
        int state = cur.value.compareTo(x);
        while (!f) {
            if (state >= 0) {
                if (cur.left == null){
                    cur.left = new Node<>(x);
                    f = true;
                    continue;
                }
                cur = cur.left;
            }else {
                if (cur.right == null){
                    cur.right = new Node<>(x);
                    f = true;
                    continue;
                }
                cur = cur.right;
            }
            state = cur.value.compareTo(x);
        }
    }
    public static void printTree(Node<?> r, int d){
        if (r != null){
            printTree(r.right, d+1);
            for (int i =1; i<=d; i++){
                System.out.print("  ");
            }
            System.out.println(r.value);
            printTree(r.left, d+1);
        }
    }
    public boolean remove(T x) {
        Node<T> cur = root;
        Node<T> par = root;
        boolean isLeft = true;
        int state = cur.value.compareTo(x);
        while (state != 0) {
            par = cur;
            if (state > 0) {
                cur = cur.left;
                isLeft = true;
            } else {
                cur = cur.right;
                isLeft = false;
            }
            if (cur == null) {
                return false;
            }
            state = cur.value.compareTo(x);
        }
        if (cur.isLeaf()) {
            if (cur == root) {
                root = null;
            } else if (isLeft) {
                par.left = null;
            } else {
                par.right = null;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (isLeft) {
                par.left = cur.left;
            } else {
                par.right = cur.left;
            }
        } else if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (isLeft) {
                par.left = cur.right;
            } else {
                par.right = cur.right;
            }
        } else {
            Node<T> sw = cur;
            par = cur;
            cur = cur.right;
            while (!cur.isLeaf()){
                if (cur.left != null){
                    par = cur;
                    cur = cur.left;
                    isLeft = true;
                }else {
                    par = cur;
                    cur = cur.right;
                    isLeft = false;
                }
            }
            sw.value = cur.value;
            if (isLeft){
                par.left = null;
            }else {
                par.right = null;
            }
        }
        return true;
    }
    public static boolean remove2(T x, Node<T> r){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.root = r;
        return binarySearchTree.remove(x);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bts = new BinarySearchTree<>();
        bts.add(25);
        bts.add(26);
        bts.add(5);
        bts.add(2);
        bts.add(2);
        bts.add(3);
        System.out.println(bts.contains(26));
        bts.remove(3);
        printTree(bts.root, 0);
    }
}
