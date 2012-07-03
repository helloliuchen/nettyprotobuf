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
			// 这里可以直接使用id->参数即可
			
		}
		return null;
	}

}
