/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.object.formatters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import multichain.nativeimpl.object.TxOut;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TxOutFormatter {
	public final  TxOut formatTxOut(String stringTxOut) {
		final Gson gson = new GsonBuilder().create();

		final TxOut txOut = gson.fromJson(stringTxOut, TxOut.class);

		return txOut;
	}

}
