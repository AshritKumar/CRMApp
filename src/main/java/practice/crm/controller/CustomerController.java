package practice.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practice.crm.entity.Customer;
import practice.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired // default name will be first letter small
	private CustomerService customerService;
	
	@RequestMapping("/test")
	public String testController() {
		return "test";
	}
	
	//@RequestMapping(value="/list", method=RequestMethod.GET)
	@GetMapping("/list") // only get shortcut
	public String getCustomers(Model model) {
		model.addAttribute("customerList", customerService.getCustomers());
		System.out.println(model.getClass().getName());
		return "customer-list";
	}
	
	// for add customer form
	
	@GetMapping("/addCustForm")
	public String showAddCustomerForm(Model model) {
		// create a customer obj and put in model (request obj) to access it in the spring form
		model.addAttribute("customer", new Customer());
		model.addAttribute("action","saveCustomer");
		return "customerForm";
	}
	
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer){ // get customer from model
		customerService.saveCustomer(customer); // save 
		return "redirect:/customer/list"; // redircet to list page
	}
	
	@RequestMapping("/custUpdtaeForm")
	public String showUpdateCustomerForm( @RequestParam("custId") Integer id, Model model){
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		model.addAttribute("action","saveCustomer");
		return "customerForm";
	}
	
	@RequestMapping("/delete")
	public String deleteCutsomer(@RequestParam("custId") Integer custId) {
		Customer cust = customerService.getCustomer(custId);
		customerService.deleteCustomer(cust);
		return "redirect:/customer/list";
	}
	

}
