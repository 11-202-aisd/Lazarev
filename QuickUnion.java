public class QuickUnion {

    int n = 1000;
    int[] id = new int[n];

    public void idFiller(){
        for (int i = 0; i<id.length; i++){
            id[i] = i;
        }
    }
    public QuickUnion(int n){
        id = new int[n];
        idFiller();
    }

    private int root(int x) {
        while (x != id[x]){
            x = id[x];
        }
        return x;
    }

        public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

        public void createConnection(int p, int q) {
        id[root(p)] = root(q);
    }
}
