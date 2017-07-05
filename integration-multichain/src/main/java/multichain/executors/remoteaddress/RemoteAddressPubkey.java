package multichain.executors.remoteaddress;

/**
 * 
 * @author <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>
 *
 */
public class RemoteAddressPubkey {
	private String host;
	private String user;
	private int port;
	private String pubKey;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPubKey() {
		return pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

}
