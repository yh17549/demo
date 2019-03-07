package io.github.yh17549.demo.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;

public class MessageEventTranslator implements EventTranslatorOneArg<MessageEvent,String> {

	@Override
	public void translateTo(MessageEvent messageEvent, long l, String s) {
		messageEvent.setMessage(s);
	}
}
