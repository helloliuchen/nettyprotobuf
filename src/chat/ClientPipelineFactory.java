package chat;

import static org.jboss.netty.channel.Channels.pipeline;
import localtime.LocalTimeClientHandler;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class ClientPipelineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		 ChannelPipeline p = pipeline();
	        p.addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
	        p.addLast("protobufDecoder", new MyProtobufDecoder());

	        p.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
	        p.addLast("protobufEncoder", new MyProtobufEncoder());

	        p.addLast("handler", new LocalTimeClientHandler());
	        return p;
	}

}
