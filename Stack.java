public class Stack {
   private int n = 0;
   private int [] arr;

    public Stack(int cap){
        this.arr = new int[cap];
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public int look(){
        return arr[n-1];
    }
    public int take(){
        n--;
        return arr[n];
    }
    public void put(int x){
        arr[n] = x;
        n++;
    }
}
