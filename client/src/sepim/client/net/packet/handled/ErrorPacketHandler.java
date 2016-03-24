package sepim.client.net.packet.handled;

import sepim.client.Client;
import sepim.client.net.packet.Packet;

public class ErrorPacketHandler {

	public void handle(Packet packet) {
		String s = packet.getString();
		Client.getInstance().writeMessage(s);
	}

}
