package com.form.controllers;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.form.models.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//used to trim white spaces from form submissions
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("employeeReg", "employee", new Employee());
    }
 

	
	   @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	    public String submit(@Valid @ModelAttribute("employee")Employee employee, 
	      BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "employeeReg";
	        }
	        model.addAttribute("name", employee.getName());
	        model.addAttribute("contactNumber", employee.getContactNumber());
	        model.addAttribute("id", employee.getId());
	        return "employeeView";
	    }
}
