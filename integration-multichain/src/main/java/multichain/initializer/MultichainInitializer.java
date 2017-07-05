package multichain.initializer;

import multichain.executors.Executor;
import multichain.executors.RemotePubKeyExecutor;
import multichain.executors.remoteaddress.RemoteAddressPubkey;
import multichain.nativeimpl.commands.StreamCommand;

/**
 * 
 * @author <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>
 *
 */
public class MultichainInitializer {
	private Executor executor = new RemotePubKeyExecutor();
	private StreamCommand streamCommand;

	MultichainInitializer() {
		this.streamCommand = new StreamCommand(executor);
		RemoteAddressPubkey addressPubkey = new RemoteAddressPubkey();
		addressPubkey.setHost("34.20.12.15");
		addressPubkey.setPort(22);
		addressPubkey.setUser("sample");
		addressPubkey.setPubKey("C:\\Users\\Administrator\\Desktop\\sample.pem");
		((RemotePubKeyExecutor) executor).setRemoteAddressPubkey(addressPubkey);
	}

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}

	public StreamCommand getStreamCommand() {
		return streamCommand;
	}

	public void setStreamCommand(StreamCommand streamCommand) {
		this.streamCommand = streamCommand;
	}

}
