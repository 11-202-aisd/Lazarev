public class Node<T extends Comparable<T>> {
    protected T value;
    protected Node<T> left;
    protected Node<T> right;
    public Node(T x){
        value = x;
        left = null;
        right = null;
    }
    public boolean isLeaf(){
        return (left == null && right == null);
    }
}
