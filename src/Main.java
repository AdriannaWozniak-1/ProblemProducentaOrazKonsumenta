public class Main {
    public static void main(String[] args) {
        Bufor bufor = new Bufor();

        Thread watekProducenta = new Thread(new Producent(bufor));
        Thread watekKonsumenta = new Thread(new Konsument(bufor));

        watekProducenta.start();
        watekKonsumenta.start();

        try { //by wiadomość o wątkach została pokazana po ich całkowitym wykonaniu
            watekProducenta.join();
            watekKonsumenta.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("wszystkie wątki zostały zakończone");
    }
}
