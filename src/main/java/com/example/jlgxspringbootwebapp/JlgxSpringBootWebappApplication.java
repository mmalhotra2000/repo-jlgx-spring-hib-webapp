package com.example.jlgxspringbootwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jlgxspringbootwebapp.model.BankAccountModel;
import com.example.jlgxspringbootwebapp.repository.BankAccountModelRepository;

@SpringBootApplication
public class JlgxSpringBootWebappApplication implements CommandLineRunner {

	@Autowired
	private BankAccountModelRepository bankAccountModelRepository;

	public static void main(String[] args) {
		SpringApplication.run(JlgxSpringBootWebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BankAccountModel bankAccountModel1 = new BankAccountModel("Mohit", 10000);
		BankAccountModel bankAccountModel2 = new BankAccountModel("Rohit", 50000);
		BankAccountModel bankAccountModel3 = new BankAccountModel("Sumit", 60000);
		bankAccountModelRepository.save(bankAccountModel1);
		bankAccountModelRepository.save(bankAccountModel2);
		bankAccountModelRepository.save(bankAccountModel3);

	}

}
