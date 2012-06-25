package HelloWorld;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class HeloWorldServerHandler extends SimpleChannelHandler{

	
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		e.getChannel().write("Hello, world");
		super.channelConnected(ctx, e);
	}

	@Override
	public void connectRequested(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		e.getChannel().write("Hello, world");
		super.connectRequested(ctx, e);
	}
}
