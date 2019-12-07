package com.example.jlgxspringbootwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jlgxspringbootwebapp.bean.BankFormBean;
import com.example.jlgxspringbootwebapp.model.Student;
import com.example.jlgxspringbootwebapp.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentServiceImpl;

	@Autowired
	private BankFormBean bankFormBean;

	@RequestMapping("/")
	public String showHomePage() {
		return "main-menu";
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("std", new Student("a", "b"));
		return "helloworld";
	}

	@RequestMapping("/showTransactionForm")
	public String showTransactionForm(Model model) {
		model.addAttribute("bankFormBean", bankFormBean);
		return "bank-form";
	}

	@RequestMapping("/addStudent")
	public String addStudent(@ModelAttribute("std") Student student, Model model) {
		System.out.println(student);
		studentServiceImpl.save(student);
		Student student2 = studentServiceImpl.findById(new Long(1));
		System.out.println("from db " + student2);

		model.addAttribute("stdd", student2);
		return "student-confirmation";
	}

	@RequestMapping("/transfer")
	public String transfer(@ModelAttribute("bankFormBean") BankFormBean bankFormBean) {
		System.out.println(bankFormBean.getBalance());
		return "main-menu";
	}

}
