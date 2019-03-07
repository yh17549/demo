package io.github.yh17549.demo.disruptor;

import com.lmax.disruptor.EventHandler;

public class MessageEventHandler implements EventHandler<MessageEvent> {

	@Override
	public void onEvent(MessageEvent messageEvent, long l, boolean b) throws Exception {
		System.out.println(messageEvent.getMessage());
	}

}