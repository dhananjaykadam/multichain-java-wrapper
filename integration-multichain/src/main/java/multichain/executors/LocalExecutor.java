package multichain.executors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import multichain.executors.response.ExecutorResponse;
/**
 * 
 * @author <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>
 *
 */
public class LocalExecutor implements Executor {
	@Override
	public ExecutorResponse executeShellCommand(String command) {
		Runtime rt = Runtime.getRuntime();
		Process pr;
		ExecutorResponse response = new ExecutorResponse();
		response.setError(true);
		try {
			pr = rt.exec(command);

			InputStream in = pr.getInputStream();
			// InputStream error = pr.getErrorStream();

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(in));
			// BufferedReader stdError = new BufferedReader(new
			// InputStreamReader(error));
			String s = "";
			String result = "";
			while ((s = stdInput.readLine()) != null) {
				response.setError(false);
				result = result.concat(s + "\n");
			}
			response.setResponse(result);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			response.setError(true);
		}
		return response;
	}

}
