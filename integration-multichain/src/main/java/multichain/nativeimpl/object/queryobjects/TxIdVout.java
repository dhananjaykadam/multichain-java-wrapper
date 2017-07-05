/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.object.queryobjects;

import multichain.nativeimpl.commands.MultichainException;
import multichain.nativeimpl.commands.tools.MultichainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TxIdVout {
	String txId;
	int vOut;

	public void isFilled() throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("txId", txId);
		MultichainTestParameter.valueIsNotNegative("vOut", vOut);
	}

	/**
	 * @return the txId
	 */
	public String getTxId() {
		return txId;
	}
	/**
	 * @param txId the txId to set
	 */
	public void setTxId(String txId) {
		this.txId = txId;
	}
	/**
	 * @return the vOut
	 */
	public int getvOut() {
		return vOut;
	}
	/**
	 * @param vOut the vOut to set
	 */
	public void setvOut(int vOut) {
		this.vOut = vOut;
	}


}
