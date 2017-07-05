/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.nativeimpl.object;

import java.util.Date;
import java.util.List;

/**
 * @author Dhananjay Kadam
 * @version 1.0
 */
public class Stream extends AddressInfo {
	private List<String> publishers;
	private String key;
	private String data;
	private Long confirmation;
	private String blockhash;
	private Long blockindex;
	private Long blocktime;
	private String txid;
	private Long vout;
	private Boolean valid;
	private Date time;
	private Date timereceived;

	public List<String> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<String> publishers) {
		this.publishers = publishers;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Long confirmation) {
		this.confirmation = confirmation;
	}

	public String getBlockhash() {
		return blockhash;
	}

	public void setBlockhash(String blockhash) {
		this.blockhash = blockhash;
	}

	public Long getBlockindex() {
		return blockindex;
	}

	public void setBlockindex(Long blockindex) {
		this.blockindex = blockindex;
	}

	public Long getBlocktime() {
		return blocktime;
	}

	public void setBlocktime(Long blocktime) {
		this.blocktime = blocktime;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public Long getVout() {
		return vout;
	}

	public void setVout(Long vout) {
		this.vout = vout;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTimereceived() {
		return timereceived;
	}

	public void setTimereceived(Date timereceived) {
		this.timereceived = timereceived;
	}

}
