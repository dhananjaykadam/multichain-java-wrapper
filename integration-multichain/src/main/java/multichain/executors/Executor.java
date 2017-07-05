package multichain.executors;

import multichain.executors.response.ExecutorResponse;
/**
 * 
 * @author <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>
 *
 */
public interface Executor {
	public ExecutorResponse executeShellCommand(String command);
}
