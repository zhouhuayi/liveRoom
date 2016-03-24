package sepim.server.net.packet;

import sepim.server.clients.Client;
import sepim.server.net.packet.handled.ChatPacketHandler;
import sepim.server.net.packet.handled.CommandPacketHandler;
import sepim.server.net.packet.handled.DefaultPacketHandler;

public class PacketHandler {
	
	public void handle(Client client, Packet packet) {
		final int opcode = packet.getOpcode();
		System.out.println(opcode);
		switch(opcode) {
		case 0:
			new CommandPacketHandler().handle(client, packet);
			break;
		case 1:
			new ChatPacketHandler().handle(client, packet);
			break;
		default:
			new DefaultPacketHandler().handle(client, packet);
			break;
		}
	}

}
