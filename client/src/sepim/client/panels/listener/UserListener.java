package sepim.client.panels.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sepim.client.Client;
import sepim.client.net.packet.Packet;
import sepim.client.panels.util.Utils;

public class UserListener implements ActionListener, KeyListener, MouseListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Utils.ACTION_SEND)) {
			sendMessage(Client.getInstance().getClientPanel().getInputArea().getText());
			Client.getInstance().getClientPanel().getInputArea().setText(Utils.EMPTY);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendMessage(Client.getInstance().getClientPanel().getInputArea().getText());
			Client.getInstance().getClientPanel().getInputArea().setText(Utils.EMPTY);
		}
	}
	
	public void sendMessage(String string) {
		if(!string.isEmpty()) {
			if(string.startsWith("/")) {
				String cmd = string.substring(1);
				Client.getInstance().getChannel().write(new Packet(0).putString(cmd));
			} else {
				Client.getInstance().getChannel().write(new Packet(1).putString(string));
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
