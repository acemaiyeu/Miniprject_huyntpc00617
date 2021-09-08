package com.poy.J6_Huyntpc00617.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poy.J6_Huyntpc00617.Bean.Orders;
import com.poy.J6_Huyntpc00617.Service.OrderService;
import com.poy.J6_Huyntpc00617.Service.OrderTempService;

@Controller
public class OrderController {
	@Autowired
	OrderTempService orservice;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orservice.findByUsername(username));
		return "order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", orservice.findById(id));
		return "order/detail";
	}
}
