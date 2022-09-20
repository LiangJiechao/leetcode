package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者
 *
 * @author xiaoliang
 * @date 2022/07/31 22:33
 **/
public class ProducerAndConsumer {

    int max = 3; // 最多可装多少个
    int count = 0;// 目前多少个
    Lock lock = new ReentrantLock();
    Condition condProd = lock.newCondition();
    Condition condCons = lock.newCondition();

    public static void main(String[] args) {
        ProducerAndConsumer test = new ProducerAndConsumer();

        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();

        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    // 注意：这里需要用while 防止虚假唤醒
                    while (count >= max) {
                        System.out.println("队列满了，生产者停止生产");
                        condProd.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前有 " + count);
                    condCons.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    // 注意：这里需要用while 防止虚假唤醒
                    while (count <= 0) {
                        System.out.println("队列空了，消费者停止消费");
                        condCons.await();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前有 " + count);
                    condProd.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
