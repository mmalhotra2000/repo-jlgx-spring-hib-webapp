package com.example.jlgxspringbootwebapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jlgxspringbootwebapp.model.BankAccountModel;
import com.example.jlgxspringbootwebapp.model.TransactionHistoryModel;
import com.example.jlgxspringbootwebapp.repository.BankAccountModelRepository;
import com.example.jlgxspringbootwebapp.repository.TransactionHistoryModelRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankAccountModelRepository bankAccountModelRepository;

	@Autowired
	private TransactionHistoryModelRepository transactionHistoryModelRepository;

	@Override
	public List<BankAccountModel> getAllBankAccountModel() {
		return bankAccountModelRepository.findAll();
	}

	@Override
	public List<TransactionHistoryModel> getTransactionHistoryModels() {
		return transactionHistoryModelRepository.findAll();
	}

	@Override
	public void transfer(long fromAccountNum, long toAccountNum, double balance, String transactionType) {

		BankAccountModel fromAccountModel = bankAccountModelRepository.findById(fromAccountNum).get();
		BankAccountModel toAccountModel = bankAccountModelRepository.findById(toAccountNum).get();

		doCredit(balance, transactionType, fromAccountModel, toAccountModel);

		doDebit(balance, transactionType, fromAccountModel, toAccountModel);

		createTransactionHistory(balance, transactionType, fromAccountModel);

	}

	@Override
	public void doDebit(double balance, String transactionType, BankAccountModel fromAccountModel,
			BankAccountModel toAccountModel) {
		if ("DEBIT".equalsIgnoreCase(transactionType)) {
			fromAccountModel.setBalance(fromAccountModel.getBalance() + balance);
			toAccountModel.setBalance(toAccountModel.getBalance() - balance);
			bankAccountModelRepository.save(toAccountModel);
		}
	}

	@Override
	public void doCredit(double balance, String transactionType, BankAccountModel fromAccountModel,
			BankAccountModel toAccountModel) {
		if ("CREDIT".equalsIgnoreCase(transactionType)) {
			fromAccountModel.setBalance(fromAccountModel.getBalance() - balance);
			toAccountModel.setBalance(toAccountModel.getBalance() + balance);
			bankAccountModelRepository.save(fromAccountModel);
		}
	}

	@Override
	public void createTransactionHistory(double balance, String transactionType, BankAccountModel fromAccountModel) {

//		String name = null;
//		name.toUpperCase();

		TransactionHistoryModel transactionHistoryModel = new TransactionHistoryModel(transactionType, balance,
				new Date(), fromAccountModel);

		transactionHistoryModelRepository.save(transactionHistoryModel);
	}

	@Override
	public List<TransactionHistoryModel> getTransactionHistoryModelsByName(String searchByName2) {
		return transactionHistoryModelRepository.findByName(searchByName2);
	}

	@Override
	public BankAccountModel getBankAccountModelByName(String name) {
		// TODO Auto-generated method stub
		return bankAccountModelRepository.findByAccountHolderName(name);
	}

	@Override
	public BankAccountModel getBankAccountModelByNameAndAcc(String name, Long acc) {
		// TODO Auto-generated method stub
		return bankAccountModelRepository.findByAccountHolderNameAndAccNo(name,acc);
	}
}
