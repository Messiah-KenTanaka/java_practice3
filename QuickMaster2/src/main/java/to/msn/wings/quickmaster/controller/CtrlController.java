package to.msn.wings.quickmaster.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CtrlController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("main", "ctrl/form::main");
		return "common/layout";
	}

	@PostMapping("/ctrl/form")
	public String form(@RequestParam String name, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birth,
			@RequestParam String email, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("birth", birth);
		model.addAttribute("email", email);
		model.addAttribute("main", "ctrl/form_result::main");
		return "common/layout";
	}
}
