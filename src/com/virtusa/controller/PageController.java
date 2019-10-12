package com.virtusa.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.dao.ProductDao;
import com.virtusa.dao.UserDao;
import com.virtusa.pojo.Address;
import com.virtusa.pojo.User;

@Controller
public class PageController {
	@Autowired
	UserDao us;
@Autowired
ProductDao ps;	
	
	@RequestMapping(value = { "/home", "/" })
	public String getHomePage( ) {
		
		return "home";
	}

	@RequestMapping("/ul")
	public ModelAndView getCrudPage(Model model) {
		ModelAndView mv = new ModelAndView("crud");

		mv.addObject("user", new User());
		model.addAttribute("users", us.getAllUser());
		return mv;
	}

	@RequestMapping("/registration")
	public ModelAndView getRegistrationPage() {
		ModelAndView mv = new ModelAndView("registration");

		mv.addObject("user", new User());

		return mv;
	}

	@RequestMapping("/login")
	public String getLoginPage(Model model,@RequestParam(name = "error", required = false) String error) {
		if (error != null) {
			model.addAttribute("message", "Invalid Username and Password");
		}
		return "login";
	}

	@RequestMapping("/ht")
	public String getHtPage(Model model) {
		
		model.addAttribute("view", ps.getHtProduct());
		//model.addAttribute("product",product);
		return "ht";
	}
	@RequestMapping("/dress")
	public String getDressPage(Model model) {
		
		model.addAttribute("view", ps.getDressProduct());
		//model.addAttribute("product",product);
		return "ht";
	}
	@RequestMapping("/tv")
	public String getTvpage(Model model){
		model.addAttribute("view",ps.getTvProduct() );
		return "tv";
	}

	@RequestMapping(value = "getuser", method = RequestMethod.POST)

	public String getuser( @ModelAttribute("user") User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "registration";
		}

		System.out.println("validated successfully!!!");
		
		user.setRole("USER");
		user.setEnabled(true);
		us.addUser(user);

		System.out.println("your Registration Get Succeed");
		System.out.println("---------------------------------------------------------");
		System.out.println("The User Id : " + user.getId());

		System.out.println("------------------Thank You------------------------------");

		model.addAttribute("user", user);
		model.addAttribute("address", new Address());
		return "address";
	}

	@RequestMapping("/usadd/{id}")
	public String getAddressPage(@Valid @ModelAttribute Address address, BindingResult result, @PathVariable int id,
			Model model, @RequestParam("action") String action) {
		if (result.hasErrors()) {
			return "address";
		}
		System.out.println("the area is:" + address.getArea());
		User user = us.getUserById(id);
		List<Address> addresses = user.getAddresses();
		addresses.add(address);
		user.setAddresses(addresses);
		us.updateUser(user);
		switch (action.toLowerCase()) {
		case "submit":
			return "redirect:/success";
		}
		model.addAttribute("user", user);
		model.addAttribute("address", new Address());
		return "address";
	}

	@RequestMapping("/success")
	public String getSuccessPage() {
		return "success";
	}
	
	@RequestMapping("/_eventId_edit")
	public String getConfirmPage(Model model,Principal principal)
	
	{   User user=us.getUserByName(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("address",us.getAddressById(user.getId()));
		return "address1";
	}
	
	@RequestMapping("/asadd/{id}")
	public String getConPage(@Valid @ModelAttribute Address address,BindingResult result, @PathVariable int id,Model model, @RequestParam("action") String action)
	{   
		if (result.hasErrors()) {
			return "address";
		}
		
		User user = us.getUserById(id);
		
		us.updateUser(user);
		if(action.toLowerCase()=="Add Another Address")
		{
		List<Address> addresses = user.getAddresses();
		addresses.add(address);
		user.setAddresses(addresses);
		us.updateUser(user);
		
		}
		switch (action.toLowerCase()) {
		case "submit":
			return "alert";
		}
		model.addAttribute("user", user);
		model.addAttribute("address", new Address());
		return "address1";
	}
	@RequestMapping("/cartitem")
	public String getCart() {
		return "cart";
	}
}

