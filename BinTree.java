public class BinTree {
    protected Node root;
    public BinTree(){
        root = null;
    }

    private Node addElemR(Node r, int value){
        if (r == null){
            r = new Node(value);
            return r;
        }
        if (r.value < value){
            r.left = addElemR(r.left, value);
        }else {
            r.right = addElemR(r.right, value);
        }
        return r;
    }
    public void addElem(int n){
        addElemR(root, n);
    }

    public static void main(String[] args) {
        BinTree b = new BinTree();
        b.addElem(2);
        System.out.println(b.root.value);
    }
}
