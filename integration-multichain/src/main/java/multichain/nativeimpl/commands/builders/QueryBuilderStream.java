/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.commands.builders;

import multichain.nativeimpl.commands.MultichainException;
import multichain.nativeimpl.enums.CommandEnum;

/**
 * @author Dhananjay Kadam
 * @version 1.0
 */
public class QueryBuilderStream extends QueryBuilderCommon {

	protected  String executeGetStreamItems(String chain, String streamName) throws MultichainException {
		return execute(chain, CommandEnum.LISTSTREAMITEMS, streamName);
	}

	protected  String executeGetStreamKeyItems(String chain, String streamName, String key)
			throws MultichainException {
		return execute(chain, CommandEnum.LISTSTREAMKEYITEMS, streamName, key);
	}

	protected  String executeGetStreamPublisherItems(String chain, String streamName, String publisher)
			throws MultichainException {
		return execute(chain, CommandEnum.LISTSTREAMPUBLISHERITEMS, streamName, publisher);
	}

	protected  String executePublishFrom(String chain, String publisher, String streamName, String key,
			String data) throws MultichainException {
		return execute(chain, CommandEnum.PUBLISHFROM, publisher, streamName, key, data);
	}
}
