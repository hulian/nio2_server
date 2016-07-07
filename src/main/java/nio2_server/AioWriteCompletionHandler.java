package nio2_server;

import java.nio.channels.CompletionHandler;

public class AioWriteCompletionHandler implements CompletionHandler<Integer, AttachMent>{

	@Override
	public void completed(Integer result, AttachMent attachment) {

		if( result>0 ){
			attachment.getReadBuffer().clear();
			attachment.getAsynchronousSocketChannel().read(attachment.getReadBuffer(),attachment,new AioReadCompletionHandler());
		}else{
			attachment.getAsynchronousSocketChannel().write(attachment.getReadBuffer(),attachment,this);
		}
	}

	@Override
	public void failed(Throwable exc, AttachMent attachment) {
		exc.printStackTrace();
	}

}
