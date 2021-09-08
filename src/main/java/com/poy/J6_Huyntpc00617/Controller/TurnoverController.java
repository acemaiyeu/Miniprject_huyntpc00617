package com.poy.J6_Huyntpc00617.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TurnoverController {
	@GetMapping("/statistical/index")
	public String index() {
		return "redirect:/assets/statistical/index.html";
	}
}
