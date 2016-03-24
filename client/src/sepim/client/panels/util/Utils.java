package sepim.client.panels.util;

import sepim.client.Client;

public class Utils {
	
	public static final String EMPTY = "";
	
	public static final String ACTION_LOGIN = "login";
	
	public static final String ACTION_SEND = "send";
	
	public static final String ACTION_REGISTER = "register";
	
	public static final String[] EMPTY_LIST = new String[] { " " };
	
	public static final String LINE_BREAK = (String) java.security.AccessController.doPrivileged(
			new sun.security.action.GetPropertyAction("line.separator"));
	
	public static void connectMessage() {
		Client.getInstance().writeMessage("Please enter a nick name using the command \"/nick name\"\n" +
				"There are also several commands to create join leave and delete a chat. \n" +
				"These commands are \"/create chat\", \"/join chat\", \"/leave\", \"/delete chat\".");
	}

}
