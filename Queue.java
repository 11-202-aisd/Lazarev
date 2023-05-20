public class Queue {

    int n = 1000;
    Stack in = new Stack(n);
    Stack out = new Stack(n);

    public Queue(int n){
        this.n = n;
        in = new Stack(n);
        out = new Stack(n);
    }
    public Queue(){
    }
    public void add(int x){
        in.put(x);
    }
    public int get(){
        if (in.isEmpty()){
            throw new RuntimeException("No elements");
        }
        if (out.isEmpty()){
            while (!in.isEmpty()){
                int y = in.take();
                out.put(y);
            }
        }
        return out.take();
    }
}
