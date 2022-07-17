package offer.meituan2022;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoliang
 * @date 2022/03/29 19:23
 **/
public class 锁控制输出ABC10次 {
    public static volatile char flag = 'A';

    public static void main(String[] args) {

        Lock lockA = new ReentrantLock();
        Condition conA = lockA.newCondition();
        Condition conB = lockA.newCondition();
        Condition conC = lockA.newCondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockA.lock();
                try {
                    while (flag != 'A') {
                        conA.await();
                    }
                    System.out.println("A");
                    flag = 'B';
                    conB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockA.unlock();
                }

            }
        }, "Thread1").start();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {

                lockA.lock();
                try {
                    while (flag != 'B') {
                        conB.await();
                    }
                    System.out.println("B");
                    flag = 'C';
                    conC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockA.unlock();
                }
            }
        }, "Thread2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockA.lock();
                try {
                    while (flag != 'C') {
                        conC.await();
                    }
                    System.out.println("C");
                    flag = 'A';
                    conA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockA.unlock();
                }
            }
        }, "Thread3").start();

    }
}





