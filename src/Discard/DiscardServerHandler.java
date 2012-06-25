package Discard;

import java.net.SocketAddress;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class DiscardServerHandler extends SimpleChannelHandler {

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		// e has message for ChannelBuffer
		ChannelBuffer buf = (ChannelBuffer) e.getMessage();
		while (buf.readable())
		{
			System.out.println((char) buf.readByte());
			System.out.flush();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		System.out.println(e.getCause().getMessage());
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		System.out.println("channelOpen");
		super.channelOpen(ctx, e);
	}

	@Override
	public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		System.out.println("channelBound");
		super.channelBound(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		SocketAddress address = (SocketAddress)e.getValue();
		System.out.println("channelConnected" + address.toString());
		super.channelConnected(ctx, e);
	}

	@Override
	public void bindRequested(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		System.out.println("bindRequest");
		super.bindRequested(ctx, e);
	}	
	
	
}
