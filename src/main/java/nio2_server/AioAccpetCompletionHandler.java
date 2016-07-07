package nio2_server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AioAccpetCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>{

	@Override
	public void completed(AsynchronousSocketChannel channel, AsynchronousServerSocketChannel serverChannel) {
	
		
		//continue accept new connection
		serverChannel.accept(serverChannel,this);
		
		
		ByteBuffer readBuffer = ByteBuffer.allocate(500);
		
		AttachMent attachMent = new AttachMent();
		attachMent.setAsynchronousServerSocketChannel(serverChannel);
		attachMent.setAsynchronousSocketChannel(channel);
		attachMent.setReadBuffer(readBuffer);
		
		channel.read(readBuffer, attachMent, new AioReadCompletionHandler());
		
	}

	@Override
	public void failed(Throwable exc, AsynchronousServerSocketChannel serverChannel) {
		exc.printStackTrace();
	}

}
