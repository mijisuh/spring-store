package ssd0206.controller;

import java.io.Serializable;

import ssd0206.domain.Account;

@SuppressWarnings("serial")
public class AccountForm implements Serializable {

	private Account account;

	private boolean newAccount;

	private String repeatedPassword;

	public AccountForm(Account account) {
		this.account = account;
		this.newAccount = false;
	}

	public AccountForm() {
		this.account = new Account();
		this.newAccount = true;
	}

	public Account getAccount() {
		return account;
	}

	public boolean isNewAccount() {
		return newAccount;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

}
