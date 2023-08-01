package test;

/**
 * @author xiaoliang
 * @date 2022/09/22 16:58
 **/
public class PrintABC {

    private int num = 0;
    private static final Object LOCK = new Object();

    private void printABC(String name, int targetNum) {

        for (int i = 0; i < 10; i++)  {
            synchronized (LOCK) {
                while (num % 3 != targetNum) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + " ==> curNum = " + num + " ==> curThread = " + Thread.currentThread().getName());
                num++;
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC obj = new PrintABC();
        new Thread(() -> {
            obj.printABC("A", 0);
        }, "A").start();
        new Thread(() -> {
            obj.printABC("B", 1);
        }, "B").start();
        new Thread(() -> {
            obj.printABC("C", 2);
        }, "C").start();
    }
}
