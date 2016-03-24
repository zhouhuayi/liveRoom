package sepim.client.net.packet.handled;

import sepim.client.Client;
import sepim.client.net.packet.Packet;
import sepim.client.panels.util.Utils;

public class UpdateUsersPacketHandler {

	public void handle(Packet packet) {
		if(packet.getBuffer().readableBytes() > 0) {
			int users = packet.get();
			String[] s = new String[users];
			for(int i = 0; i < users; i++) {
				s[i] = packet.getString();
			}
			Client.getInstance().updateUserList(s);
		} else {
			Client.getInstance().updateUserList(Utils.EMPTY_LIST);
		}
	}

}
