package com.example.jlgxspringbootwebapp.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.example.jlgxspringbootwebapp.model.BankAccountModel;
import com.example.jlgxspringbootwebapp.model.TransactionHistoryModel;
import com.example.jlgxspringbootwebapp.service.BankService;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BankTransactionBean {

	private String searchByName;

	private List<TransactionHistoryModel> transactionHistoryModels;

	private List<BankAccountModel> bankAccountModels;

	@Autowired
	private BankService bankServiceImpl;

	@PostConstruct
	public void init() {
		transactionHistoryModels = bankServiceImpl.getTransactionHistoryModels();
		bankAccountModels = bankServiceImpl.getAllBankAccountModel();
	}

	public List<TransactionHistoryModel> getTransactionHistoryModels() {
		return transactionHistoryModels;
	}

	public void setTransactionHistoryModels(List<TransactionHistoryModel> transactionHistoryModels) {
		this.transactionHistoryModels = transactionHistoryModels;
	}

	@PreDestroy
	public void destroy() {
		transactionHistoryModels = null;
	}

	public void transfer(long fromAccountNum, long toAccountNum, double balance, String transactionType) {
		bankServiceImpl.transfer(fromAccountNum, toAccountNum, balance, transactionType);
		init();
	}

	public List<BankAccountModel> getBankAccountModels() {
		return bankAccountModels;
	}

	public void setBankAccountModels(List<BankAccountModel> bankAccountModels) {
		this.bankAccountModels = bankAccountModels;
	}

	public String getSearchByName() {
		return searchByName;
	}

	public void setSearchByName(String searchByName) {
		this.searchByName = searchByName;
	}

	public BankService getBankServiceImpl() {
		return bankServiceImpl;
	}

	public void setBankServiceImpl(BankService bankServiceImpl) {
		this.bankServiceImpl = bankServiceImpl;
	}

	public void getTransactionHistoryModelsByName(String searchByName2) {
		transactionHistoryModels = bankServiceImpl.getTransactionHistoryModelsByName(searchByName2);		
	}

}
