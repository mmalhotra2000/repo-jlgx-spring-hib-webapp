package com.example.jlgxspringbootwebapp.service;

import java.util.List;

import com.example.jlgxspringbootwebapp.model.BankAccountModel;
import com.example.jlgxspringbootwebapp.model.TransactionHistoryModel;

public interface BankService {

	List<BankAccountModel> getAllBankAccountModel();

	List<TransactionHistoryModel> getTransactionHistoryModels();

	void transfer(long fromAccountNum, long toAccountNum, double balance, String transactionType);

	void doDebit(double balance, String transactionType, BankAccountModel fromAccountModel,
			BankAccountModel toAccountModel);

	void doCredit(double balance, String transactionType, BankAccountModel fromAccountModel,
			BankAccountModel toAccountModel);

	void createTransactionHistory(double balance, String transactionType, BankAccountModel fromAccountModel);

}
