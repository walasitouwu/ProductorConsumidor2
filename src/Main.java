//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        for (int i = 1; i <= 2; i++) {
            new Productor(buffer, 100).start();
        }

        for (int i = 1; i <= 3; i++) {
            new Consumidor(buffer, 100).start();
        }
    }
}