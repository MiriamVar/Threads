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
//        Random ran = new Random();

        //od 1 po 10
        for (int i = 0; i < arr.length-1; i++) {
            arr[i]= String.valueOf(i+1);
            System.out.println("Number "+i+" "+arr[i]);
        }

        arr[10] = "End";
        return arr;
    }
}
