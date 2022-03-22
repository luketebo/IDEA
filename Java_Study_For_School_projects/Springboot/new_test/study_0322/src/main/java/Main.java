public class Main {
    public static void main(String[] args) {
        Product q  = new Product();
        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }
}
