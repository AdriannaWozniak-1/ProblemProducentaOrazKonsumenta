import java.util.Random;
class Producent implements Runnable {
    private final Bufor bufor;
    Random losowa = new Random();
    int liczbaWylosowana = losowa.nextInt(1001) + 1000; //losowy czas od 1000 do 2000

    public Producent(Bufor bufor) {
        this.bufor = bufor;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                bufor.dodaj(i);
                Thread.sleep(liczbaWylosowana); //symulowanie przetwarzania danych
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}