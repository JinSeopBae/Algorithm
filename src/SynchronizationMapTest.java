import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class SynchronizationMapTest {
    public static void main(String[] args) {
        int loopSize = 30;
        CountDownLatch countDownLatch = new CountDownLatch(loopSize);
        ExecutorService tp = Executors.newFixedThreadPool(10);

        Map<String, LongAdder> testMap = Collections.synchronizedMap(new HashMap<>());

        for(int i = 0; i < loopSize; i++) {
            int selector = (i % 3);
            String type = (selector == 0) ? "justhis" : (selector == 1) ? "beenzino" : "verbaljint";
            tp.submit(new Runner(type , countDownLatch, testMap));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(testMap);
        tp.shutdown();
    }

    static class Runner implements Runnable {
        private final String runnerNo;
        private final CountDownLatch countDownLatch;
        private Map<String, LongAdder> testMap;

        Runner(String runnerNo, CountDownLatch countDownLatch, Map<String, LongAdder> testMap) {
            this.runnerNo = runnerNo;
            this.countDownLatch = countDownLatch;
            this.testMap = testMap;
        }

        @Override
        public void run() {
            try {
                testMap.computeIfAbsent(runnerNo, (value) -> new LongAdder()).increment();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
