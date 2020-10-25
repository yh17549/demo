package io.github.yh17549.demo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject("Subject1");
        Observer a = new Observer("A");
        Observer b = new Observer("B");
        Observer c = new Observer("C");
        subject.registerObserver(a);
        subject.registerObserver(b);

        subject.publish("hello");
        subject.removeObserver(b);
        subject.registerObserver(c);
        subject.publish("world ");
    }
}

class Subject {

    private final List<Observer> observerList = new ArrayList<>();

    private final String name;

    public Subject(String name) {
        this.name = name;
    }

    void registerObserver(Observer observer) {
        System.out.println("[" + this.name + "] register observer : " + observer.getName());
        observerList.add(observer);
    }

    void removeObserver(Observer observer) {
        System.out.println("[" + this.name + "] remove observer : " + observer.getName());
        observerList.remove(observer);
    }

    void publish(String message) {
        System.out.println("[" + this.name + "] publish message: " + message);
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}

class Observer {
    private final String name;

    public Observer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void update(String s) {
        System.out.println(name + " receive message: " + s);
    }
}
