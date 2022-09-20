package test;

import java.util.concurrent.locks.LockSupport;

/**
 * 测试LockSupport，两个线程循环交替输出东西
 * LockSupport 即使unpark()在park()之前执行也没事，
 * @author xiaoliang
 * @date 2022/07/31 21:30
 **/
public class TestLockSupport {

    static Thread t1 = null;
    static Thread t2 = null;
    static char s = 'a';

    public static void main(String[] args) {

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    System.out.println("t1--"+s);
                    s++;
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    LockSupport.park();
                    System.out.println("t2--"+s);
                    s++;
                    LockSupport.unpark(t1);
                }
            }
        });

        t1.start();
        t2.start();

    }
}
