package io.github.yh17549.demo.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class MessageEventProducer {

	private RingBuffer<MessageEvent> ringBuffer;

	public MessageEventProducer(RingBuffer<MessageEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void produceData(String message){
		EventTranslatorOneArg<MessageEvent,String> translator = new MessageEventTranslator();
		ringBuffer.publishEvent(translator,message);
	}

}
