package sepim.server.net.packet;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class Packet {
	
	private int opcode;
	
	private ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
	
	public Packet(int opcode) {
		this.opcode = opcode;
	}
	
	public Packet(int opcode, ChannelBuffer buffer) {
		this.opcode = opcode;
		this.buffer = buffer;
	}
	
	public Packet put(int b) {
		buffer.writeByte(b);
		return this;
	}
	
	public Packet put(byte[] b) {
		buffer.writeBytes(b);
		return this;
	}
	
	public Packet putString(String s) {
		put(s.getBytes().length);
		return put(s.getBytes());
	}
	
	public String getString() {
		int length = get();
		byte[] b = new byte[length];
		for(int i = 0; i < b.length; i++) {
			b[i] = get();
		}
		return new String(b);
	}
	
	public byte get() {
		return buffer.readByte();
	}
	
	public int getOpcode() {
		return opcode;
	}
	
	public ChannelBuffer getBuffer() {
		return buffer;
	}

}
