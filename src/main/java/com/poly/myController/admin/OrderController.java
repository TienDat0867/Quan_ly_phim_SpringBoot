package com.poly.myController.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

	@RequestMapping("/admin/orders")
	public String manageOrders()
	{
		return "admin/report/manageOrder";
	}
	
}
