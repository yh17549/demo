package io.github.yh17549.demo.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

	public static void main(String[] args) {
		Runner01 runner01 = new Runner01();
		Thread thread1 = new Thread(runner01, "thread-01");
		Thread thread2 = new Thread(runner01, "thread-02");
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

/*
result:
Thread [thread-02] try to get lock
Thread [thread-01] try to get lock
Thread [thread-02] get lock!
Thread [thread-02] working...
Thread [thread-01] try to get lock again!
Thread [thread-01] try to get lock again!
Thread [thread-01] try to get lock again!
Thread [thread-01] try to get lock again!
Thread [thread-01] try to get lock again!
Thread [thread-01] try to get lock again!
Thread [thread-01] try to get lock again!
Thread [thread-02] run finish
Thread [thread-02] start to unlock!
Thread [thread-02] unlock finish!
Thread [thread-01] try to get lock again!
Thread [thread-01] get lock!
Thread [thread-01] working...
Thread [thread-01] run finish
Thread [thread-01] start to unlock!
Thread [thread-01] unlock finish!
*/

class SpinLock {
	private AtomicReference<Thread> lock = new AtomicReference<>();

	public void lock() {
		System.out.println("Thread [" + Thread.currentThread().getName() + "] try to get lock");
		Thread current = Thread.currentThread();
		while (!lock.compareAndSet(null, current)) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread [" + current.getName() + "] try to get lock again!");
		}
		System.out.println("Thread [" + current.getName() + "] get lock!");
	}

	public void unlock() {
		Thread current = Thread.currentThread();
		System.out.println("Thread [" + current.getName() + "] start to unlock!");
		lock.compareAndSet(current, null);
		System.out.println("Thread [" + current.getName() + "] unlock finish!");

	}
}

class Runner01 implements Runnable {
	private SpinLock spinLock = new SpinLock();

	@Override
	public void run() {
		spinLock.lock();
		try {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] working...");
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread [" + Thread.currentThread().getName() + "] run finish");
		spinLock.unlock();
	}
}
