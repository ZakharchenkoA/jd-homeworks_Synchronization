public class Main {

    private static final int CUSTOMERS = 10;
    private static final int WAITING = 2000;

    public static void main(String[] args) throws InterruptedException {

        final Dealer dealer = new Dealer();

        new Thread(null, dealer::receiveCar, "Ford").start();

        for(int i = 1; i < CUSTOMERS; i++){
            Thread.sleep(WAITING);
            new Thread(null, dealer::sellCar, "Покупатель" + i).start();
        }
    }
}
