package designpattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoliang
 * @date 2021/12/11 17:54
 **/
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        subject.addObserver(task1);
        subject.addObserver(task2);
        subject.notifyObserver("发送事件...");
    }
}

class Subject {
    // 容器
    private List<Observer> container = new LinkedList<>();

    // add
    public void addObserver(Observer observer) {
        container.add(observer);
    }

    // remove
    public void removeObserver(Observer observer) {
        container.remove(observer);
    }

    // 通知
    public void notifyObserver(Object object) {
        for (Observer item : container) {
            item.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer {
    // 每个任务想怎么做自己去实现
    @Override
    public void update(Object object) {
        System.out.println("Task1 reveived: " + object);
    }
}

class Task2 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("Task2 reveived: " + object);


    }

}

