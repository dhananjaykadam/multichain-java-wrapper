/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.commands;

import java.util.List;

import multichain.executors.Executor;
import multichain.nativeimpl.commands.builders.QueryBuilderStream;
import multichain.nativeimpl.object.Stream;
import multichain.nativeimpl.object.formatters.StreamFormatter;

/**
 * @author Dhananjay Kadam
 * @version 1.0
 */
public class StreamCommand extends QueryBuilderStream {
	private StreamFormatter streamFormatter = new StreamFormatter();

	public StreamCommand(Executor executor) {
		this.executor = executor;
	}

	public final List<Stream> listStreamItems(String chain, String streamName) throws MultichainException {
		String streamsAsString = executeGetStreamItems(chain, streamName);
		List<Stream> streams = streamFormatter.formatStreamList(streamsAsString);
		return streams;
	}

	public final List<Stream> listPublisherStreamItems(String chain, String streamName, String publisher)
			throws MultichainException {
		String streamsAsString = executeGetStreamPublisherItems(chain, streamName, publisher);
		List<Stream> streams = streamFormatter.formatStreamList(streamsAsString);
		return streams;
	}

	public final List<Stream> listStreamKeyItems(String chain, String streamName, String key)
			throws MultichainException {
		String streamsAsString = executeGetStreamKeyItems(chain, streamName, key);
		List<Stream> streams = streamFormatter.formatStreamList(streamsAsString);
		return streams;
	}

	public final String addPublisherStreamItem(String chain, String publisher, String streamName, String key,
			String data) throws MultichainException {
		return executePublishFrom(chain, publisher, streamName, key, data);
	}
}
