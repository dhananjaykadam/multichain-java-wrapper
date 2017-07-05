/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.object.formatters;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import multichain.nativeimpl.object.Stream;

/**
 * @author Dhananjay Kadam
 * @version 1.0
 */
public class StreamFormatter {
	public final  Stream formatStream(String stringStream) {
		final Gson gson = new GsonBuilder().create();
		final Stream stream = gson.fromJson(stringStream, Stream.class);
		return stream;
	}

	public final  List<String> formatStreamStringList(String stringStreams) {
		final Gson gson = new GsonBuilder().create();
		Type listType = new TypeToken<List<String>>() {
		}.getType();
		final List<String> streams = gson.fromJson(stringStreams, listType);
		return streams;
	}

	public final  List<Stream> formatStreamList(String stringStream) {
		final Gson gson = new GsonBuilder().create();
		Type listType = new TypeToken<List<Stream>>() {
		}.getType();
		final List<Stream> streams = gson.fromJson(stringStream, listType);
		return streams;
	}
}