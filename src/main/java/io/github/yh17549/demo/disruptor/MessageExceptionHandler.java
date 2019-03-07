package io.github.yh17549.demo.disruptor;

import com.lmax.disruptor.ExceptionHandler;

public class MessageExceptionHandler implements ExceptionHandler<MessageEvent> {

	@Override
	public void handleEventException(Throwable throwable, long l, MessageEvent messageEvent) {
		throwable.printStackTrace();
	}

	@Override
	public void handleOnStartException(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void handleOnShutdownException(Throwable throwable) {
		throwable.printStackTrace();
	}

}
