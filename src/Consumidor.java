public class Consumidor extends Thread {
    private final Buffer buffer;
    private final int totalNumeros;

    public Consumidor(Buffer buffer, int totalNumeros) {
        this.buffer = buffer;
        this.totalNumeros = totalNumeros;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalNumeros; i++) {
                int value = buffer.get();
                System.out.println(Thread.currentThread().getName() + " consumió: " + value);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}