package jr.io.projeto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jr.io.projeto1.repository.UserRepository;
import jr.io.projeto1.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping("/user")
	public String getUsers(Model model) {
		model.addAttribute("userList", this.userService.findAll());
		
		return "user";
	}
}
