package sepim.client.net.packet.handled;

import sepim.client.Client;
import sepim.client.net.packet.Packet;
import sepim.client.panels.util.Utils;

public class ClearPacketHandler {

	public void handle(Packet packet) {
		Client.getInstance().getClientPanel().getChatArea().setText(Utils.EMPTY);
	}

}
