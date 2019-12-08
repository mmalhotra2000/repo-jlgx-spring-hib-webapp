package com.example.jlgxspringbootwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jlgxspringbootwebapp.bean.BankFormBean;
import com.example.jlgxspringbootwebapp.bean.BankTransactionBean;

@Controller
@RequestMapping("/bank")
public class BankFormController {

	@Autowired
	private BankFormBean bankFormBean;

	@Autowired
	private BankTransactionBean bankTransactionBean;

	@RequestMapping("/showTransactions")
	public String showTransactions(Model model) {
		model.addAttribute("bankTransactionBean", bankTransactionBean);
		return "bank-transactions";
	}

	@RequestMapping("/showTransactionForm")
	public String showTransactionForm(Model model) {
		model.addAttribute("bankFormBean", bankFormBean);
		return "bank-form";
	}
	
	//searchByName
	
	@RequestMapping("/searchByName")
	public String searchByName( @ModelAttribute("bankTransactionBean")  BankTransactionBean bankTransactionBeanParam, Model model) {
		
		System.out.println(bankTransactionBean.getSearchByName());
		bankTransactionBean.getTransactionHistoryModelsByName(bankTransactionBeanParam.getSearchByName());
		model.addAttribute("bankTransactionBean", bankTransactionBean);
		
		return "bank-transactions";
	}

	@RequestMapping("/transfer")
	public String transfer(@ModelAttribute("bankFormBean") BankFormBean bankFormBean, Model model) {

		System.out.println(bankFormBean.getBalance());

		bankTransactionBean.transfer(bankFormBean.getFromAccountNum(), bankFormBean.getToAccountNum(),
				bankFormBean.getBalance(), bankFormBean.getTransactionType());

		model.addAttribute("bankTransactionBean", bankTransactionBean);

		return "redirect:/bank/showTransactions";
	}

}
