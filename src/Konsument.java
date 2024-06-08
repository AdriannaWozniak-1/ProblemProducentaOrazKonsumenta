import java.util.Random;
class Konsument implements Runnable {
    private final Bufor bufor;
    Random losowa = new Random();
    int liczbaWylosowana = losowa.nextInt(1001) + 2000;

    public Konsument(Bufor bufor) {
        this.bufor = bufor;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                int wartosc = bufor.pobierz();
                Thread.sleep(liczbaWylosowana);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}