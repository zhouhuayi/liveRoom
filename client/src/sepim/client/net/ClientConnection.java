package sepim.client.net;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import sepim.client.Client;

public class ClientConnection {
	
	public ClientConnection() throws Exception {
		NioClientSocketChannelFactory factory = new NioClientSocketChannelFactory(
				Executors.newCachedThreadPool(), Executors.newCachedThreadPool());
		ClientBootstrap bootstrap = new ClientBootstrap(factory);
		bootstrap.setPipelineFactory(new ClientPipelineFactory());
		ChannelFuture future = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8089));
		Channel channel = future.awaitUninterruptibly().getChannel();
		Client.getInstance().setChannel(channel);
	}

}
