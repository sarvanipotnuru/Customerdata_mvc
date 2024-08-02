package com.example.demo.controllers;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestMapping;

	import com.example.demo.models.User;
	import com.example.demo.repositary.Userrepositary;
	import jakarta.servlet.http.HttpSession;

	@Controller
	public class Usercontroller {
	@Autowired
	Userrepositary repo;

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	@GetMapping( "/")
	public String hello(Model m) {
		List<User> us = (List<User>) repo.findAll();
		m.addAttribute("add-products",us);
		return "hello";
	}@GetMapping("/getbyid/{id}")
		public String getby(@PathVariable(value = "id")int id, Model m) {
			Optional<User> Ur = repo.findById(id);
			User u = Ur.get();
			m.addAttribute("products",u);
			return "edit";
		
		
	}@PutMapping("/insertion")
		public String insert(@ModelAttribute User Us ,HttpSession hts) {
			repo.save(Us);
			hts.setAttribute("message", "Successfull");
			return "redirect:/loading";
		}
		@PutMapping("/update")
		public String edit(@ModelAttribute User u ,HttpSession hts) {
			repo.save(u);
			hts.setAttribute("message", "successfull");
			return "redirect:/";
		}
		@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable(value = "id") int id,HttpSession hts) {
			repo.deleteById(id);
			hts.setAttribute("message", "successfull");
			return"redirect:/";
		}
		
		@GetMapping("/loading")
		public String loading() {
			return "add";
		}
	}




