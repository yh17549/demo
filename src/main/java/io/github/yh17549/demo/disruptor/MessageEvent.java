package io.github.yh17549.demo.disruptor;

public class MessageEvent {

	private String message;

	public MessageEvent() {}

	public MessageEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
