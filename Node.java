public class Node {
    protected int value;
    protected Node left;
    protected Node right;
    public Node(int value){
        left = null;
        right = null;
        this.value = value;
    }
    public boolean isLeaf(){
        return (left==null && right==null);
    }
}
