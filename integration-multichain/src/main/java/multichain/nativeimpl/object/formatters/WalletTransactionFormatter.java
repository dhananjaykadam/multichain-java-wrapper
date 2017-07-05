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

import multichain.nativeimpl.object.TransactionWallet;
import multichain.nativeimpl.object.TransactionWalletDetailed;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class WalletTransactionFormatter {
	public final  List<TransactionWallet> formatListTransactionWallet(String stringListWalletTransaction) {
		final Gson gson = new GsonBuilder().create();

		Type listType = new TypeToken<List<TransactionWallet>>(){}.getType();
		final List<TransactionWallet> transactionWalletList = gson.fromJson(stringListWalletTransaction, listType);

		return transactionWalletList;
	}

	public final  TransactionWallet formatTransactionWallet(String stringWalletTransaction) {
		final Gson gson = new GsonBuilder().create();

		final TransactionWallet transactionWallet = gson.fromJson(stringWalletTransaction, TransactionWallet.class);

		return transactionWallet;
	}

	public final  TransactionWalletDetailed formatTransactionWalletDetailed(String stringTransactionWalletDetailed) {
		final Gson gson = new GsonBuilder().create();

		final TransactionWalletDetailed transactionWalletDetailed = gson.fromJson(stringTransactionWalletDetailed, TransactionWalletDetailed.class);

		return transactionWalletDetailed;
	}

}
