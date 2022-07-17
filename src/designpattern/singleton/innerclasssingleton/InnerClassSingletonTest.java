package designpattern.singleton.innerclasssingleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式：静态内部类实现
 * 可以实现懒加载的方式
 *
 * @author xiaoliang
 * @date 2021/12/08 15:31
 **/
public class InnerClassSingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {

        // 假如用反射来创建实例
//        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();
//
//        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//        // false
//        System.out.println(innerClassSingleton == instance);

        InnerClassSingleton instance = InnerClassSingleton.getInstance();

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testSerializable"));
//        oos.writeObject(instance);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testSerializable"));
        InnerClassSingleton o = (InnerClassSingleton) ois.readObject();
        ois.close();
        System.out.println(o == instance);
    }
}

class InnerClassSingleton implements Serializable {

    // 序列化版本号
    static final long serialVersionUID = 42L;

    /**
     * InnerClassHolder什么时候加载？
     * 是在调用 getInstance时，才会被初始化
     */
    private static class InnerClassHolder {
        private static InnerClassSingleton instant = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        if (InnerClassHolder.instant != null) {
            // 防止用反射来创建实例，同理饿汉模式也可以这么做
            throw new RuntimeException("单例不允许多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instant;
    }

    /**
     * 解决反序列化时的单例实现，指定一个方法当一个实例从流中获取
     * @return
     * @throws ObjectStreamException
     */
    Object readResolve() throws ObjectStreamException{
        return getInstance();
    }
}
