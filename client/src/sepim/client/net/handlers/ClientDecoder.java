package sepim.client.net.handlers;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import sepim.client.net.packet.Packet;

public class ClientDecoder extends FrameDecoder {

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel chl, ChannelBuffer buf) throws Exception {
		if(buf.readableBytes() > 0) {
			Packet packet = new Packet(buf.readByte(), buf);
			return packet;
		}
		return null;
	}

}
