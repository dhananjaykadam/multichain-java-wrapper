/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.commands;

import java.util.ArrayList;
import java.util.List;

import multichain.executors.Executor;
import multichain.nativeimpl.commands.builders.QueryBuilderBalance;
import multichain.nativeimpl.object.BalanceAsset;
import multichain.nativeimpl.object.formatters.BalanceFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class BalanceCommand extends QueryBuilderBalance {
	private BalanceFormatter balanceFormatter = new BalanceFormatter();

	public BalanceCommand(Executor executor) {
		this.executor = executor;
	}

	/**
	 *
	 * gettotalbalances ( minconf includeWatchonly includeLocked)
	 *
	 * If account is not specified, returns the server's total available asset
	 * balances. If account is specified, returns the balances in the account.
	 * Note that the account "" is not the same as leaving the parameter out.
	 * The server total may be different to the balance in the default ""
	 * account.
	 *
	 * Arguments: 1. minconf (numeric, optional, default=1) Only include
	 * transactions confirmed at least this many times. 2. includeWatchonly
	 * (bool, optional, default=false) Also include balance in watchonly
	 * addresses (see 'importaddress') 3. includeLocked (bool, optional,
	 * default=false) Also take locked outputs into account Results are an array
	 * of Objects with totals and details for each asset.
	 *
	 * @return a list of all the asset balances in this node’s wallet
	 * @throws MultichainException
	 */
	protected List<BalanceAsset> getTotalBalances(String chain) throws MultichainException {
		List<BalanceAsset> listBalanceAsset = new ArrayList<BalanceAsset>();

		String stringBalanceAsset = executeGetTotalBalances(chain);
		listBalanceAsset = balanceFormatter.formatBalanceAssets(stringBalanceAsset);

		return listBalanceAsset;
	}

	/**
	 *
	 * getunconfirmedbalance Returns the server's total unconfirmed balance
	 *
	 * @return not formated balance
	 * @throws MultichainException
	 */
	protected String getUnconfirmedBalance(String chain) throws MultichainException {
		return executeGetUnconfirmedBalance(chain);
	}

}
