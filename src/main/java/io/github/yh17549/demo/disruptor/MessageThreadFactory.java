package io.github.yh17549.demo.disruptor;

import java.util.concurrent.ThreadFactory;

public class MessageThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r,"Test_Thread");
	}
}
