package com.example.jlgxspringbootwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jlgxspringbootwebapp.model.TransactionHistoryModel;

@Repository
public interface TransactionHistoryModelRepository extends JpaRepository<TransactionHistoryModel, Long> {

	@Query(name = "TransactionHistoryModel.getTransactionHistoryModelRepositoryByName", value = "select  transactionHistoryModel from  TransactionHistoryModel transactionHistoryModel"
			+ " where transactionHistoryModel.bankAccountModel.accountHolderName = :name ")
	List<TransactionHistoryModel> findByName(@Param("name") String name1);

}
