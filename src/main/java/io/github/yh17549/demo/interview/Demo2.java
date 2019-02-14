package io.github.yh17549.demo.interview;

/**
 * @author xyh
 * @date 2019-02-14
 */
public class Demo2 {

    public static void main(String[] args) {
        PrintThread printThread = new PrintThread(5);
        Thread thread1 = new Thread(printThread);
        Thread thread2 = new Thread(printThread);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

}

class PrintThread implements Runnable {
    private Object lock = new Object();
    private int number ;
    private int i;

    public PrintThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        while (i<=number) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                i++;
                // 唤醒其他线程
                lock.notify();
                if (i <= number){
                    // i > number 时，线程不用再等待
                    try {
                        // 等待
                        lock.wait();
                        // 唤醒后，会从 wait 处 继续往下执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}


