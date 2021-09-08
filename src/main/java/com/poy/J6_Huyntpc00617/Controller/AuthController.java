package com.poy.J6_Huyntpc00617.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poy.J6_Huyntpc00617.Service.UserService;


@Controller
public class AuthController {
	@Autowired
	HttpSession session;
	@RequestMapping("/auth/login/form")
	public String loginform(Model model) {
		return "auth/login";
	}

	@RequestMapping("/auth/login/success")
	public String loginsuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "auth/login";
	}
	
	@Autowired
	UserService userService;
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
			userService.loginFromOAuth2(oauth2);
		return "forward:/auth/login/success";
	}

	@RequestMapping("/auth/login/error")
	public String loginerror(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logoff/success")
	public String logoutsuccess(Model model) {
//		model.addAttribute("message", "Đăng xuất thành công");
		return "auth/login";
	}
	@RequestMapping("/auth/access/denied")
	public String denied(Model model) {
		model.addAttribute("message", "Bạn không có quyền truy xuất");
		return "auth/login";
	}
	
}
