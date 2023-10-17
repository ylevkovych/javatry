package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreadTry {

    static public int i;

    class LockObjects {
        Object obj1;
        Object obj2;

        public LockObjects(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        public void doLock() throws InterruptedException {

            synchronized (obj1) {
                System.out.println(obj1);
                Thread.sleep(3000);

                synchronized (obj2) {
                    System.out.println(obj2);
                    Thread.sleep(3000);

                }

            }

        }

    }

    @Test
    public void testLock() {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new Thread(() -> {
            try {
                new LockObjects(obj1,obj2).doLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                new LockObjects(obj2,obj1).doLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(15000);
            t2.join(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(t1.isAlive());
        Assertions.assertTrue(t2.isAlive());

        t1.interrupt();
        t2.interrupt();

    }

}
