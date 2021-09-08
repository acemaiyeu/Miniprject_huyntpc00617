package com.poy.J6_Huyntpc00617.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
	@RequestMapping("/cart/view")
	public String cartview() {
		return "cart/view";
	}
}
