package nio2_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) {

		final int DEFAULT_PORT = 8080;
		final String IP = "0.0.0.0";
		// create an asynchronous server socket channel bound to the default
		// group
		
		try (AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(AsynchronousChannelGroup.withThreadPool(Executors.newCachedThreadPool()))) {
			if (asynchronousServerSocketChannel.isOpen()) {
				// set some options
				asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 12*1024*1024);
				asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
				// bind the server socket channel to local address
				asynchronousServerSocketChannel.bind(new InetSocketAddress(IP, DEFAULT_PORT));
				// display a waiting message while ... waiting clients
				System.out.println("Waiting for connections ...on:" + asynchronousServerSocketChannel.getLocalAddress());
				
				asynchronousServerSocketChannel.accept(asynchronousServerSocketChannel, new AioAccpetCompletionHandler());
				
				// Wait
				System.in.read();
			} else {
				System.out.println("The asynchronous server-socket channel cannot be opened!");
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
}
