package offer.meituan2022;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoliang
 * @date 2022/03/29 19:23
 **/
public class 锁控制输出ABC10次2 {
    public static volatile int num = 0;

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                lock.lock();
                try {
                    if (num % 3 == 0) {
                        System.out.print("A");
                        i++;
                        num++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread1").start();

        new Thread(() -> {

            for (int i = 0; i < 10; ) {

                lock.lock();
                try {
                    if (num % 3 == 1) {
                        System.out.print("B");
                        i++;
                        num++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; ) {

                lock.lock();
                try {
                    if (num % 3 == 2) {
                        System.out.print("C");
                        i++;
                        num++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread3").start();

    }

}


