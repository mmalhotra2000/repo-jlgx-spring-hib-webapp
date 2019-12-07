package com.example.jlgxspringbootwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jlgxspringbootwebapp.model.TransactionHistoryModel;

@Repository
public interface TransactionHistoryModelRepository extends JpaRepository<TransactionHistoryModel, Long> {

}
