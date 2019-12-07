package com.example.jlgxspringbootwebapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_history")
public class TransactionHistoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "tran_type")
	private String transactionType;
	private double amount;
	@Column(name = "tran_date")
	private Date transactionDate;

	@ManyToOne
	private BankAccountModel bankAccountModel;

	
	
	public TransactionHistoryModel() {
		// TODO Auto-generated constructor stub
	}

	public TransactionHistoryModel(String transactionType, double amount, Date transactionDate,
			BankAccountModel bankAccountModel) {
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.bankAccountModel = bankAccountModel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BankAccountModel getBankAccountModel() {
		return bankAccountModel;
	}

	public void setBankAccountModel(BankAccountModel bankAccountModel) {
		this.bankAccountModel = bankAccountModel;
	}

}
