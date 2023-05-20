public class QuickFind {

    int n = 1000;
    int [] id = new int[n];

    public void idFiller(){
        for (int i = 0; i<id.length; i++){
            id[i] = i;
        }
    }
    public QuickFind(int n){
        id = new int[n];
        idFiller();
    }
    public void createConnection(int p, int q){
        for (int i = 0; i<id.length; i++){
            if (id[i]== p){
                id[i] = id[q];
            }
        }
    }
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }
}
