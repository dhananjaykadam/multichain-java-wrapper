package multichain.executors.response;
/**
 * 
 * @author <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>
 *
 */
public class ExecutorResponse {
	private String response;
	private boolean error;

	private String errorMsg;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
