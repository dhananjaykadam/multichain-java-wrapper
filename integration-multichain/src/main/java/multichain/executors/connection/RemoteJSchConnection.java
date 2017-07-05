package multichain.executors.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
/**
 * 
 * @author <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>
 *
 */
public class RemoteJSchConnection {

	public void getConnectionByPubKey(String pubkey, String host, String user, int port, String command)
			throws JSchException, IOException {
		JSch jsch = new JSch();
		Session session = jsch.getSession(user, host, port);
		session.setUserInfo(getUserInfo());
		session.connect();
		ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
		InputStream in = channelExec.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		channelExec.setCommand(command);
		channelExec.connect();

		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		int exitStatus = channelExec.getExitStatus();
		channelExec.disconnect();
		session.disconnect();
		if (exitStatus < 0) {
			System.out.println("Done, but exit status not set!");
		} else if (exitStatus > 0) {
			System.out.println("Done, but with error!");
		} else {
			System.out.println("Done!");
		}
	}

	public UserInfo getUserInfo() {
		UserInfo ui = new UserInfo() {

			@Override
			public String getPassphrase() {
				// TODO Auto-generated method stub
				System.out.println("getPassphrase");
				return null;
			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				System.out.println("getPassword");
				return null;
			}

			@Override
			public boolean promptPassphrase(String arg0) {
				System.out.println("promptPassphrase" + arg0);
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean promptPassword(String arg0) {
				System.out.println("promptPassword" + arg0);
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean promptYesNo(String arg0) {
				System.out.println("promptYesNo" + arg0);
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void showMessage(String arg0) {
				System.out.println("showMessage" + arg0);
				// TODO Auto-generated method stub

			}
		};
		return ui;
	}
}
