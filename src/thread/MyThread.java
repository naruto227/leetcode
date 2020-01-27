package thread;

/**
 * Created by Michael Allan on 2019/11/22.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(EnumThread.getOurInstance().hashCode());
        }
    }
}
