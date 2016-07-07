package nio2_server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

public class AttachMent {

	private AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	private AsynchronousSocketChannel asynchronousSocketChannel;
	private ByteBuffer readBuffer;
	private ByteBuffer writeBuffer;
	
	public AsynchronousServerSocketChannel getAsynchronousServerSocketChannel() {
		return asynchronousServerSocketChannel;
	}
	public void setAsynchronousServerSocketChannel(AsynchronousServerSocketChannel asynchronousServerSocketChannel) {
		this.asynchronousServerSocketChannel = asynchronousServerSocketChannel;
	}
	public AsynchronousSocketChannel getAsynchronousSocketChannel() {
		return asynchronousSocketChannel;
	}
	public void setAsynchronousSocketChannel(AsynchronousSocketChannel asynchronousSocketChannel) {
		this.asynchronousSocketChannel = asynchronousSocketChannel;
	}
	public ByteBuffer getReadBuffer() {
		return readBuffer;
	}
	public void setReadBuffer(ByteBuffer readBuffer) {
		this.readBuffer = readBuffer;
	}
	public ByteBuffer getWriteBuffer() {
		return writeBuffer;
	}
	public void setWriteBuffer(ByteBuffer writeBuffer) {
		this.writeBuffer = writeBuffer;
	}
	
	
}
