/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.commands.builders;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import multichain.executors.Executor;
import multichain.executors.response.ExecutorResponse;
import multichain.nativeimpl.commands.MultichainException;
import multichain.nativeimpl.enums.CommandEnum;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
abstract class QueryBuilderCommon {
	protected Executor executor;

	/**
	 *
	 * @param command
	 * @param parameter
	 *
	 * @return
	 *
	 * 		example :
	 *         MultichainQueryBuidlder.executeProcess(MultichainCommand.SENDTOADDRESS,"1EyXuq2JVrj4E3CpM9iNGNSqBpZ2iTPdwGKgvf
	 *         {\"rdcoin\":0.01}"
	 * @throws MultichainException
	 */
	protected String execute(String chainName, CommandEnum command, String... parameters) throws MultichainException {
		if (executor == null) {
			return "ERROR, EXECUTOR NOT INITIALIZED!";
		}
		if (chainName != null && !chainName.isEmpty()) {
			ExecutorResponse response = null;
			if (parameters.length > 0) {
				String params = "";
				for (String parameter : parameters) {
					params = params.concat(parameter + " ");
				}
				response = executor.executeShellCommand(
						"multichain-cli " + chainName + " " + command.toString().toLowerCase() + " " + params);
			} else {
				response = executor
						.executeShellCommand("multichain-cli " + chainName + " " + command.toString().toLowerCase());
			}

			if (!response.isError()) {
				return response.getResponse();
			} else {
				throw new MultichainException(null, response.getErrorMsg());
			}
		} else {
			return "ERROR, CHAIN NAME ARE EMPTY !";
		}
	}

	protected String formatJson(String value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected String formatJson(boolean value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected String formatJson(int value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected String formatJson(long value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected String formatJson(float value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected String formatJson(double value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected String formatJson(Object value) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(value);
	}

	protected String formatJson(String[] values) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(values);
	}

	protected String formatJson(List<Object> values) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(values);
	}

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}

}
