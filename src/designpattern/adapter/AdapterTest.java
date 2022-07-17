package designpattern.adapter;

/**
 * @author xiaoliang
 * @date 2021/12/11 16:44
 **/
public class AdapterTest {

    public static void main(String[] args) {
        Target adapter = new Adapter(new Adaptee());
        System.out.println(adapter.output5v());
    }
}

class Adaptee {
    public int output220v() {
        return 220;
    }
}

interface Target {
    int output5v();
}

class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public int output5v() {
        int i = adaptee.output220v();
        // 做转换...做适配
        i = 5;
        return 5;
    }
}
