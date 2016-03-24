package sepim.client.panels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sepim.client.Client;
import sepim.client.panels.util.Utils;

public class ClientPanel extends JPanel {
	
	private static final long serialVersionUID = -2833058365127886868L;

	private JTextArea chatArea;
	
	private JTextArea inputArea;
	
	private JList userList;
	
	private JScrollPane chatPane;
	
	private JScrollPane inputPane;
	
	private JScrollPane userPane;
	
	private JButton sendButton;
	
	public ClientPanel() {
		super(null);
		setSize(600, 400);
		Font font = new Font("Dialog", Font.PLAIN, 11);
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatPane = new JScrollPane(chatArea);
		chatArea.setBounds(0, 0, 500, 325);
		chatPane.setBounds(0, 0, 500, 325);
		
		inputArea = new JTextArea();
		inputArea.setLineWrap(true);
		inputArea.setBounds(0, 325, 500, 50);
		inputArea.addKeyListener(Client.getInstance().getListener());
		inputPane = new JScrollPane(inputArea);
		inputPane.setBounds(0, 325, 500, 50);
		
		userList = new JList();
		userList.setFont(font);
		userList.setBounds(500, 0, 100, 400);
		userPane = new JScrollPane(userList);
		userPane.setBounds(500, 0, 100, 400);
		
		sendButton = new JButton("Send");
		sendButton.addActionListener(Client.getInstance().getListener());
		sendButton.setActionCommand(Utils.ACTION_SEND);
		sendButton.setBounds(0, 375, 500, 25);
		
		add(chatPane);
		add(inputPane);
		add(userPane);
		add(sendButton);
	}
	
	public JList getUserList() {
		return userList;
	}
	
	public JTextArea getInputArea() {
		return inputArea;
	}
	
	public JTextArea getChatArea() {
		return chatArea;
	}

}
