package designpattern.decorator;

/**
 * 
 * @author xiaoliang
 * @date 2021/12/11 16:58
 **/
public class DecoratorTest {
    public static void main(String[] args) {

        Decorator decorator = new ConcreteComponent2(new ConcreteComponent1(new ConcreteComponent()));
        decorator.operation();
    }
}
interface Component{
    void operation();
}
class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("拍照..");
    }
}
abstract class Decorator implements Component{
    Component component;
    public Decorator(Component component) {
        this.component = component;
    }
}
class ConcreteComponent1 extends Decorator{

    public ConcreteComponent1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜..");
        component.operation();
    }
}
class ConcreteComponent2 extends Decorator{

    public ConcreteComponent2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜..");
        component.operation();
    }
}
