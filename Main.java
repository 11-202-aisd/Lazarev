public class Main {
    static int min;
    public static boolean minLeaf(Node r, int n){
        if(r!=null){
            r.value = r.value + n;
            n = r.value;
            if (r.isLeaf()){
                min = Math.min(min, r.value);
            }
            minLeaf(r.left, n);
            minLeaf(r.right, n);
        }
        return true;
    }

    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        binTree.addElem(23);
        binTree.addElem(24);
        binTree.addElem(5);
        binTree.addElem(37);
        binTree.addElem(374);
        System.out.println(Main.minLeaf(binTree.root, 0));
        System.out.println(min);
    }
}
