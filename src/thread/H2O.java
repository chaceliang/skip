package thread;

/**
 * Created by chace on 7/5/14.
 */
public class H2O {
    int o;
    int h;

    public H2O() {
        this.o = 0;
        this.h = 0;
    }

    public synchronized void callH() throws InterruptedException {
        if (h < 1 || o < 1) {
            h++;
            wait();
        }
        if (o > 0) {
            o--;
            notify();
        }
        System.out.println("H");
    }

    public synchronized void callO() throws InterruptedException {
        if (h < 2) {
            o++;
            wait();
        }
        h -= 2;
        notify();
        notify();
        System.out.println("O");
    }
}
