package com.example.jlgxspringbootwebapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.example.jlgxspringbootwebapp.model.BankAccountModel;
import com.example.jlgxspringbootwebapp.service.BankService;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BankFormBean {

	private long fromAccountNum;
	private long toAccountNum;
	private double balance;
	private String transactionType;

	private List<BankAccountModel> bankAccountModelsDD;
	private List<String> transactionTypes;

	@Autowired
	private BankService bankServiceImpl;

	@PostConstruct
	public void init() {
		bankAccountModelsDD = bankServiceImpl.getAllBankAccountModel();
		transactionTypes = new ArrayList<String>(2);
		transactionTypes.add("CREDIT");
		transactionTypes.add("DEBIT");
	}

	public long getFromAccountNum() {
		return fromAccountNum;
	}

	public void setFromAccountNum(long fromAccountNum) {
		this.fromAccountNum = fromAccountNum;
	}

	public long getToAccountNum() {
		return toAccountNum;
	}

	public void setToAccountNum(long toAccountNum) {
		this.toAccountNum = toAccountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<BankAccountModel> getBankAccountModelsDD() {
		return bankAccountModelsDD;
	}

	public void setBankAccountModelsDD(List<BankAccountModel> bankAccountModelsDD) {
		this.bankAccountModelsDD = bankAccountModelsDD;
	}

	@PreDestroy
	public void destroy() {
		bankAccountModelsDD = null;
	}

	public List<String> getTransactionTypes() {
		return transactionTypes;
	}

	public void setTransactionTypes(List<String> transactionTypes) {
		this.transactionTypes = transactionTypes;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
