package designpattern.singleton.hungrysingleton;

/**
 * 单例模式：饿汉模式
 *
 * @author xiaoliang
 * @date 2021/12/08 15:24
 **/
public class HungrySingletonTest {

    public static void main(String[] args) {
        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

class HungrySingleton {
    private static HungrySingleton instant = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instant;
    }
}
