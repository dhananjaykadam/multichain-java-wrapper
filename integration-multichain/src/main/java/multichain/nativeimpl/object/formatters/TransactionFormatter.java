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

import multichain.nativeimpl.object.Transaction;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TransactionFormatter {


	public final  Transaction formatTransaction(String stringTransaction) {
		final Gson gson = new GsonBuilder().create();

		final Transaction transaction = gson.fromJson(stringTransaction, Transaction.class);

		return transaction;
	}

}
