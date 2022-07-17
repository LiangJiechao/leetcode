package offer.meituan2022;

/**
 * @author xiaoliang
 * @date 2022/03/29 19:23
 **/
public class 锁控制输出ABC10次3 {
    public static Object lock = new Object();
    static int num = 0;



    public static void main(String[] args) {


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (num % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    num++;
                    lock.notifyAll();
                }
            }
        }, "Thread1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (num % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    num++;
                    lock.notifyAll();
                }
            }
        }, "Thread2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (num % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    num++;
                    lock.notifyAll();
                }
            }
        }, "Thread3").start();

    }

}


