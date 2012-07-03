package chat;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

import com.google.protobuf.MessageLite;

public class MyProtobufDecoder extends OneToOneDecoder implements
		ChannelHandler {

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			Object msg) throws Exception {
		if (msg instanceof ChannelBuffer)
		{
			ChannelBuffer buf = (ChannelBuffer)msg;
			int id = (int)buf.readChar();
			String name = Mapping.Int2NameMapping.get(id);
			Class<?> cls = null;
	        try
	        {
	        	cls = Class.forName(name);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        try {
				MessageLite prototype = (MessageLite)cls.newInstance();
				if (buf.hasArray()) {
		            final int offset = buf.readerIndex();
		          
		                return prototype.newBuilderForType().mergeFrom(
		                        buf.array(), buf.arrayOffset() + offset, buf.readableBytes()).build();
		        } else {
		                return prototype.newBuilderForType().mergeFrom(
		                		new ChannelBufferInputStream((ChannelBuffer) msg)).build();
		        }
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
