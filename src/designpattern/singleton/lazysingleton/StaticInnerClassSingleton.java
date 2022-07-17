package designpattern.singleton.lazysingleton;

/**
 * 
 * @author xiaoliang
 * @date 2022/03/19 17:40
 **/
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){
        System.out.println("实例化了");
    }
    private static  class InnerClass{
        private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.instance;
    }

    public static void main(String[] args) {
//        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
//        StaticInnerClassSingleton instance1 = StaticInnerClassSingleton.getInstance();
//        System.out.println(instance==instance1);
    }

}
