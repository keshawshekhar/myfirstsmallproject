package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.project.entity.Cons;
import com.project.service.ConsService;
import com.project.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ConsController {

	@Autowired
	private ConsService consService;

	@Autowired
	private EnquiryService enquiryService;

	@GetMapping("/")
	public String loginCons(Model model) {
		// Form binding obj
		model.addAttribute("controller", new Cons());
		return "index";
	}

	@PostMapping("/login")
	public String login(Cons cons, Model model, HttpServletRequest req) {

		Cons con = consService.getCons(cons.getEmailid(), cons.getPassword());

		if ((con == null) || (con.getCons_id()>0)) {
			model.addAttribute("msg", "Invelid username and password !");
			return "index";
		} else {
			// add cons id in session.
			HttpSession session = req.getSession(true);// every user new session id will be created.
			session.setAttribute("cons_id", con.getCons_id());

			model.addAttribute("dashboardInfo", enquiryService.getDashboardData(con.getCons_id()));
			return "dashboard";
		}
	}
	@GetMapping("/dashboard")
	public String buildDashBoard(HttpServletRequest req,Model model)
	{
		HttpSession session = req.getSession(false);// every user new session id will be created.
		Integer consID=(Integer)session.getAttribute("cons_id");

		model.addAttribute("dashboardInfo", enquiryService.getDashboardData(consID));
		return "dashboard";
	}

	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("counsellerformBinding", new Cons());
		return "registerview";
	}

	@PostMapping("/register")
	public String addRegisteration(Cons cons, Model model) {

		boolean b = consService.consRegistretion(cons);
		if (b) {
			model.addAttribute("msg", "Sussecfully inserted");
		} else
			model.addAttribute("fmsg", "Fail to save");

		return "registerview";
	}

	@GetMapping("/logout")
	public String getLogout(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		session.invalidate();
		return "redirect:/";

	}

}
