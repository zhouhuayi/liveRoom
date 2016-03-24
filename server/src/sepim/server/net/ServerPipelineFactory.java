package sepim.server.net;

import static org.jboss.netty.channel.Channels.*;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;

import sepim.server.net.handlers.ServerDecoder;
import sepim.server.net.handlers.ServerEncoder;

public class ServerPipelineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = pipeline();
		pipeline.addLast("decoder", new ServerDecoder());
		pipeline.addLast("encoder", new ServerEncoder());
		pipeline.addLast("handler", new ServerHandler());
		return pipeline;
	}

}
