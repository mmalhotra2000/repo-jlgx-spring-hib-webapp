package com.example.jlgxspringbootwebapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bank_acct")
public class BankAccountModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "acc_no")
	private long accNo;
	@Column(name = "acct_holder_name")
	private String accountHolderName;
	@Column(name = "balance")
	private double balance;

	@OneToMany(mappedBy = "bankAccountModel")
	private List<TransactionHistoryModel> transactionHistoryModels;

	
	
	public BankAccountModel() {
		// TODO Auto-generated constructor stub
	}

	public BankAccountModel(String accountHolderName, double balance) {
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
