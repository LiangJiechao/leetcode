package designpattern.singleton.lazysingleton;

/**
 * 单例模式：延迟加载模式
 *
 * @author xiaoliang
 * @date 2021/12/08 15:05
 **/
public class LazySingletonTest {

    public static void main(String[] args) {

//        new Thread(()->{
//            LazySingleton instance = LazySingleton.getInstance();
//            System.out.println(instance);
//        }).start();
//
//        new Thread(()->{
//            LazySingleton instance = LazySingleton.getInstance();
//            System.out.println(instance);
//        }).start();



    }

}
class LazySingleton{
    // volatile禁止指令重排
    private  static volatile LazySingleton instant;
    private LazySingleton(){};

    /**
     * 单例模式：延迟加载模式
     * 多线程情况下，如果第一次创建，先判断是否实例化了，如果没有，先上锁才实例化
     *
     * @return
     */
    public static LazySingleton getInstance(){
        if (instant ==null){

            synchronized (LazySingleton.class){
                if (instant == null){
                    instant = new LazySingleton();
                    // 字节码层
                    //
                    // 1.分配空间
                    // 2.初始化
                    // 3.引用赋值
                    // 这里第2，3步可能会被jit优化，进行指令重排，
                    // 如先赋值，再初始化，会导致在多线程环境下，可能出现NPE
                }
            }
        }
        return instant;
    }
}
