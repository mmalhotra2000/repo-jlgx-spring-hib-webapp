package com.example.jlgxspringbootwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jlgxspringbootwebapp.model.BankAccountModel;

@Repository
public interface BankAccountModelRepository extends JpaRepository<BankAccountModel, Long> {

	BankAccountModel findByAccountHolderName(String name);

	BankAccountModel findByAccountHolderNameAndAccNo(String name, Long acc);

}
