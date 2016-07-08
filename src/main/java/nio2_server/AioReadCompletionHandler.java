package nio2_server;

import java.nio.channels.CompletionHandler;

public class AioReadCompletionHandler implements CompletionHandler<Integer, AttachMent>{

	@Override
	public void completed(Integer result,final AttachMent attachment) {
		
		if( result>0 ){
			attachment.getReadBuffer().flip();
			attachment.getAsynchronousSocketChannel().write(attachment.getReadBuffer(),attachment,new AioWriteCompletionHandler());
		}
	}

	@Override
	public void failed(Throwable exc, AttachMent attachment) {
		exc.printStackTrace();
	}

}
