import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements  Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String packets [] = generate();
        for (String pack: packets) {
            data.send(pack);
        }
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        } catch (InterruptedException e)  {
           e.printStackTrace();
        }
    }

    private String[] generate(){
        String[] arr = new String[11];
        Random ran = new Random();

        for (int i = 0; i < arr.length-1; i++) {
            arr[i]= String.valueOf(ran.nextInt(11));
        }

        arr[10] = "End";
        return arr;
    }
}
