package io.github.yh17549.demo.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class DisruptorTest {

	public static void main(String[] args) {
		String message = "Hello World!";
		int ringBufferSize = 64;//必须是2的N次方

		Disruptor<MessageEvent> disruptor = new Disruptor<>(new MessageEventFactory(), ringBufferSize,
				new MessageThreadFactory());
		disruptor.handleEventsWith(new MessageEventHandler());
		disruptor.setDefaultExceptionHandler(new MessageExceptionHandler());
		RingBuffer<MessageEvent> ringBuffer = disruptor.start();
		MessageEventProducer producer = new MessageEventProducer(ringBuffer);

		for (int i = 0; i <= 10; i++) {
			producer.produceData("i:" + i + "," + message);
		}
		disruptor.shutdown();
	}


}



