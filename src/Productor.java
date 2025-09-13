public class Productor extends Thread {
    private final Buffer buffer;
    private final int totalNumeros;

    public Productor(Buffer buffer, int totalNumeros) {
        this.buffer = buffer;
        this.totalNumeros = totalNumeros;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalNumeros; i++) {
                buffer.put(i);
                System.out.println(Thread.currentThread().getName() + " produjo: " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}