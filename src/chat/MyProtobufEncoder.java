package chat;

import static org.jboss.netty.buffer.ChannelBuffers.*;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.protobuf.ProtobufEncoder;

public class MyProtobufEncoder extends ProtobufEncoder {
    @Override
    protected Object encode(
            ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
    	String name = Utils.getName(msg);
		Integer id = Mapping.Name2IntMapping.get(name);
		ChannelBuffer buffer = ChannelBuffers.buffer(2);
		buffer.writeChar(id);
		return wrappedBuffer(buffer, (ChannelBuffer)super.encode(ctx, channel, msg));
    }
}
