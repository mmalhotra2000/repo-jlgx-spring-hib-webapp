package com.example.jlgxspringbootwebapp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jlgxspringbootwebapp.model.BankAccountModel;
import com.example.jlgxspringbootwebapp.service.BankService;

@RestController
@RequestMapping("/rest")
public class MyFirtsRESTService {

	@Autowired
	private BankService bankServiceImpl;

	@GetMapping(path = "/getAllBankAccs")
	// @RequestMapping(method=HttpMethod.GET)
	public List<BankAccountModel> getAllBankAccountDetails() {
		return bankServiceImpl.getAllBankAccountModel();
	}

	@GetMapping(path = "/getAllBankAccs/{name}")
	// @RequestMapping(method=HttpMethod.GET)
	public BankAccountModel getBankAccountDetailByName(@PathVariable("name") String name) {
		return bankServiceImpl.getBankAccountModelByName(name);
	}
	
	@GetMapping(path = "/getAllBankAccs/v1/{name}")
	// @RequestMapping(method=HttpMethod.GET)
	public BankAccountModel getBankAccountDetailByNameAndAcc(@PathVariable("name") String name, @RequestParam("acc") Long acc) {
		return bankServiceImpl.getBankAccountModelByNameAndAcc(name,acc);
	}

}
