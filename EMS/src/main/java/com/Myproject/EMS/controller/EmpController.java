package com.Myproject.EMS.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Myproject.EMS.entity.Employee;
import com.Myproject.EMS.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/") 
	public String home(Model m)
	{
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		return  "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_employee";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		Employee e=service.getMapById(id);
		m.addAttribute("emp",e);
		return "edit";
		
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg","Emp Data Update Sucessfully..");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id,HttpSession session) {
		
		service.deleteMap(id);
		session.setAttribute("msg","Emp Data deleted Sucessfully..");
        return "redirect:/";
	}
	

}