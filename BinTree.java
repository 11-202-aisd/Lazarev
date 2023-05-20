import java.util.LinkedList;
import java.util.Queue;

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
    public void addElem(int n){ root = addElemR(root, n);
    }
    public boolean contains(int n){
        Node p = root;
        while (p!=null){
            if (p.value == n){
                return true;
            }
            if (p.value < n){
                p = p.left;
                continue;
            }
            if (p.value > n){
                p = p.right;
            }
        }
        return false;
    }
    public void print(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.poll();
            System.out.println(cur.value);
            if (cur.left != null){
                q.add(cur.left);
            }
            if (cur.right != null){
                q.add(cur.right);
            }
        }
    }
    private void traverse(Node r){ //алгоритм в глубину
        if (r!= null){
            System.out.println(r.value);
            traverse(r.left);
            traverse(r.right);
        }
    }
    public void traverse(){
        traverse(root);
    }

    public static void main(String[] args) {
        BinTree b = new BinTree();
        b.addElem(2);
        b.addElem(3);
        b.addElem(4);
        b.print();
        System.out.println(b.contains(5));
    }
}
