class Bufor {
    private final int[] bufor;
    private final int pojemnosc = 5; //ilość elementów jakie w stanie przechować bufor
    private int rozmiar = 0; //akualny rozmiar bufora
    private int indeksDodawania = 0;
    private int indeksPobierania = 0;

    public Bufor() {
        this.bufor = new int[pojemnosc];
    }

    public void dodaj(int wartosc) throws InterruptedException {
        synchronized (this) {
            while (rozmiar == pojemnosc) {
                wait();
            }
            bufor[indeksDodawania] = wartosc;
            indeksDodawania = (indeksDodawania + 1) % pojemnosc;
            //by aktualizować indeks dodawania elementu do bufora
            rozmiar++;
            System.out.println("Producent dodaje element nr: " + wartosc);
            notify();
        }
    }

    public int pobierz() throws InterruptedException {
        synchronized (this) {
            while (rozmiar == 0) {
                wait();
            }
            int wartosc = bufor[indeksPobierania];
            indeksPobierania = (indeksPobierania + 1) % pojemnosc;
            rozmiar--;
            System.out.println("Konsument pobiera element nr: " + wartosc);
            notify();
            return wartosc;
        }
    }
}
