import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Testing....");

        Flowable.range(1, 100000)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v -> v * v)
                .sequential()
                .blockingSubscribe(System.out::println);

        System.out.println("Waiting....");

        Thread.sleep(11000);
    }
}
