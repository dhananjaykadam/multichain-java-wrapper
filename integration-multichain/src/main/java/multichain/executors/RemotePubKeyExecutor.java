package multichain.executors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import multichain.executors.connection.RemoteJSchConnection;
import multichain.executors.remoteaddress.RemoteAddressPubkey;
import multichain.executors.response.ExecutorResponse;
/**
 * This is an executor class to execute shell commands in the remote machine.
 * This class uses public key file to login

 * @author <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>
 *
 */
public class RemotePubKeyExecutor implements Executor {
	private RemoteJSchConnection remoteConnection = new RemoteJSchConnection();
	private RemoteAddressPubkey remoteAddressPubkey;

	@Override
	public ExecutorResponse executeShellCommand(String command) {
		ExecutorResponse response = new ExecutorResponse();
		if (remoteAddressPubkey != null) {
			JSch jsch = new JSch();
			response.setError(false);
			String responseStr = null;
			try {
				jsch.addIdentity(remoteAddressPubkey.getPubKey());
				Session session = jsch.getSession(remoteAddressPubkey.getUser(), remoteAddressPubkey.getHost(),
						remoteAddressPubkey.getPort());
				session.setUserInfo(remoteConnection.getUserInfo());
				session.connect();
				ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
				InputStream in = channelExec.getInputStream();
				InputStream error = channelExec.getErrStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				BufferedReader errorReader = new BufferedReader(new InputStreamReader(error));
				channelExec.setCommand(command);
				channelExec.connect();

				String line = "";
				while ((line = reader.readLine()) != null) {
					responseStr = responseStr + line;
				}
				response.setResponse(responseStr);
				int exitStatus = channelExec.getExitStatus();
				channelExec.disconnect();
				session.disconnect();
				if (exitStatus != 0) {
					while ((line = errorReader.readLine()) != null) {
						responseStr = responseStr + line;
					}
					response.setErrorMsg(responseStr);
					response.setError(true);
				}
				return response;
			} catch (JSchException | IOException e) {
				e.printStackTrace();
				response.setError(true);
			}
			return response;
		}
		response.setError(true);
		response.setErrorMsg("Remote address not specified");
		return response;
	}

	public RemoteJSchConnection getRemoteConnection() {
		return remoteConnection;
	}

	public void setRemoteConnection(RemoteJSchConnection remoteConnection) {
		this.remoteConnection = remoteConnection;
	}

	public RemoteAddressPubkey getRemoteAddressPubkey() {
		return remoteAddressPubkey;
	}

	public void setRemoteAddressPubkey(RemoteAddressPubkey remoteAddressPubkey) {
		this.remoteAddressPubkey = remoteAddressPubkey;
	}

}
