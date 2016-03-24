package sepim.client.net;

import static org.jboss.netty.channel.Channels.*;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;

import sepim.client.net.handlers.ClientDecoder;
import sepim.client.net.handlers.ClientEncoder;

public class ClientPipelineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = pipeline();
		pipeline.addLast("decoder", new ClientDecoder());
		pipeline.addLast("encoder", new ClientEncoder());
		pipeline.addLast("handler", new ClientHandler());
		return pipeline;
	}

}
