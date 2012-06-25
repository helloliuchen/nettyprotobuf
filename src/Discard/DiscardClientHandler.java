package Discard;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class DiscardClientHandler extends SimpleChannelHandler{

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		System.out.println("channelConnected");
		for(int i = 0; i< 1000; ++i)
		{
			ChannelBuffer buffer = ChannelBuffers.buffer(4);
			buffer.writeChar('a');
			e.getChannel().write(buffer);
		}
	}
	
}
