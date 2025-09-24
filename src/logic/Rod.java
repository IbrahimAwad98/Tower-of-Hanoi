package logic;

public class Rod {
    private final Disk[] diskArray;
    private int n;

    public Rod(int initialCapacity){
        if(initialCapacity < 1){
            throw new IllegalArgumentException("Capacity must be at least 1: " + initialCapacity);
        }
        this.diskArray = new Disk[initialCapacity];
        this.n = 0;
    }

    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n == 0;
    }

    public Disk peek(){
        if(isEmpty()){
            throw new IllegalStateException("Rod is empty.");
        }
        return diskArray[n - 1];
    }

    public boolean canPush(Disk d){
       if(d == null){
           return false;
       }
       if(n >= diskArray.length){
           return false;
       }
       if(n == 0){
           return true;
       }
       return d.diameter() < diskArray[n - 1].diameter();
    }

    public void push(Disk d){
        if(!canPush(d)){
            throw new IllegalArgumentException("Not allowed push: " + d + " on " + this);
        }
        diskArray[n] = d;
        n++;
    }

    public Disk pop(){
        if(isEmpty()){
            throw new IllegalStateException("Rod is empty.");
        }
        Disk top = diskArray[n - 1];
        diskArray[n - 1] = null;
        n--;
        return top;
    }

    public Disk[] copyDiskArr(){
        Disk[] copy = new Disk[n];
        System.arraycopy(diskArray, 0, copy, 0, n);
        return copy;
    }

    public void clear(){
        for(int i = 0;i < n; i++){
            diskArray[i] = null;
        }
        n = 0;
    }

    public String toString(){
        if(n == 0){
            return "[]";
        }
       StringBuilder sb = new StringBuilder("[");
        for(int i = 0;i < n; i++){
            sb.append(diskArray[i]);
            if(i < n -1 ){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}