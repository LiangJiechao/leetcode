package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替输出ABC10次
 *
 * @author xiaoliang
 * @date 2022/07/31 22:03
 **/
public class ABCABC {

    static Lock lock = new ReentrantLock();
    static Condition conditionA = null;
    static Condition conditionB = null;
    static Condition conditionC = null;

    static CountDownLatch countDownLatchB = null;
    static CountDownLatch countDownLatchC = null;

    public static void main(String[] args) {
        conditionA = lock.newCondition();
        conditionB = lock.newCondition();
        conditionC = lock.newCondition();

        countDownLatchB = new CountDownLatch(1);
        countDownLatchC = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            lock.lock();

            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A");
                    if (i==0){
                        countDownLatchB.countDown();
                    }
                    conditionB.signal();
                    conditionA.await();
                }
                // 最后还要唤醒B
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程A");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                countDownLatchB.await();
                for (int i = 0; i < 10; i++) {
                    System.out.println("B");
                    if (i==0){
                        countDownLatchC.countDown();
                    }
                    conditionC.signal();
                    conditionB.await();
                }
                // 最后还要唤醒C
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程B");

        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                countDownLatchC.await();
                for (int i = 0; i < 10; i++) {
                    System.out.println("C");
                    conditionA.signal();
                    conditionC.await();
                }
                // 最后还要唤醒A
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程C");

        t1.start();
        t2.start();
        t3.start();
    }
}
