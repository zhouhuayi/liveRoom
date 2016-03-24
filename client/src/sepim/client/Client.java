package sepim.client;

import javax.swing.JPanel;

import org.jboss.netty.channel.Channel;

import sepim.client.panels.ClientPanel;
import sepim.client.panels.MainPanel;
import sepim.client.panels.listener.UserListener;
import sepim.client.panels.util.Utils;

public class Client {
	
	private static final Client instance = new Client();
	
	private Channel channel;
	
	private MainPanel mainPanel;
	
	private ClientPanel clientPanel;
	
	private UserListener userListener;
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public static Client getInstance() {
		return instance;
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public ClientPanel getClientPanel() {
		return clientPanel;
	}
	
	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	public void setClientPanel(ClientPanel clientPanel) {
		this.clientPanel = clientPanel;
	}
	
	public void setUserListener(UserListener userListener) {
		this.userListener = userListener;
	}
	
	public UserListener getListener() {
		return userListener;
	}
	
	public void writeMessage(String string) {
		getClientPanel().getChatArea().append("[BOT]     " + string + Utils.LINE_BREAK);
	}
	
	public void writeChatMessage(String string) {
		getClientPanel().getChatArea().append(string + Utils.LINE_BREAK);
	}
	
	@SuppressWarnings("unchecked")
	public void updateUserList(String[] string) {
		this.getClientPanel().getUserList().setListData(string);
		this.getClientPanel().getUserList().repaint();
	}
	
	public void replacePanel(JPanel panel, JPanel panel1) {
		getMainPanel().remove(panel);
		getMainPanel().add(panel1);
		getMainPanel().repaint();
	}

}
