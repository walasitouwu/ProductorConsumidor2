public class Buffer {

    private final int[] buffer;
    private int count;
    private int in;
    private int out;

    public Buffer(int size){
        this.buffer = new int[size];
        count = 0;
        in = 0;
        out =0;
    }

    public void put(int value) throws InterruptedException{
        while(count == buffer.length){
            wait();
        }
        buffer[in] = value;
        in = (in + 1) % buffer.length;
        count++;
        System.out.println("productor produjo: " + value);
        notifyAll();
    }
    public synchronized int get() throws InterruptedException{
        while(count == 0){
            wait();
        }
        int value = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        System.out.println("Consumidor consumio: " + value);
        notifyAll();
        return value;
    }
}
