package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreadWaitNotify {

    private int pingPongCount = 10;

    enum Status {
        ON_PING,
        ON_PONG,
        FINISHED,
        NOT_DEFINED
    }

    class PingPong {
        Status status = Status.NOT_DEFINED;

        List<String> messages = new ArrayList<>();
        String currentMessage;


        synchronized public void ping() throws InterruptedException {
            if (status == Status.FINISHED) {
                notify();
                return;
            }

            status = Status.ON_PING;

            currentMessage = "PING";

            notify();

            while (status == Status.ON_PING)
                wait();
        }

        synchronized public void pong() throws InterruptedException {
            if (status == Status.FINISHED) {
                notify();
                return;
            }

            status = Status.ON_PONG;

            currentMessage += " PONG";
            messages.add(currentMessage);

            notify();

            while (status == Status.ON_PONG)
                wait();
        }


    }

    private PingPong doThreadWaitNotify() {
        PingPong pp = new PingPong();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < pingPongCount+1; i++) {
                    if (i == pingPongCount) pp.status = Status.FINISHED;
                    pp.ping();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < pingPongCount+1; i++) {
                    if (i == pingPongCount) pp.status = Status.FINISHED;
                    pp.pong();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        sleep(300);
        t2.start();

        joinThread(t1);
        joinThread(t2);

        return pp;
    }


    @Test
    public void testThreadWaitNotify() {
        PingPong pp = doThreadWaitNotify();

        Assertions.assertEquals(pp.messages.size(), pingPongCount);

        for (String message : pp.messages) {
            Assertions.assertEquals("PING PONG",message);
        }

    }

    private void joinThread(Thread t) {
        try {
            t.join(60*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
