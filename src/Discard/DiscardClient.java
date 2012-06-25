package Discard;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;

public class DiscardClient {

	public static void main(String[] args)
	{
		ChannelFactory factory = new NioClientSocketChannelFactory(
				Executors.newCachedThreadPool(), 
				Executors.newCachedThreadPool());
		
		ClientBootstrap bootstrap = new ClientBootstrap(factory);
		
		bootstrap.setPipelineFactory(new ChannelPipelineFactory(){
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				 return Channels.pipeline(new DiscardClientHandler());
			}});
		
		bootstrap.setOption("tcpNoDelay", true);
		bootstrap.setOption("keepAlive", true);
		
		bootstrap.connect(new InetSocketAddress("localhost", 8080));
	}
}
