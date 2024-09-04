package com.poly.myController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.DAO.phimDAO;
import com.poly.entity.phim;
import com.poly.entityReport.FindLichChieuByIdPhim;
import com.poly.service.lichchieuServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class homeController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	phimDAO phimRepo;
	
	@Autowired
	lichchieuServiceImpl lcSer;
	@RequestMapping("/")
	public String index(
			Model model
			)
	{
		List<phim> ls_phim= this.phimRepo.findAll();
		model.addAttribute("ls_phim",ls_phim);
		session.removeAttribute("phimChoose");
		session.removeAttribute("ngaychieu");
		session.removeAttribute("phimChoose");
		session.removeAttribute("totalQuantity");
		session.removeAttribute("totalPrice");
		session.removeAttribute("ticket");
		session.removeAttribute("ls_seat");
		session.removeAttribute("giochieu");
		return "home/index";
	}
	@RequestMapping("/home/detail/{maphim}")
	public String detail(
			Model model,
			@PathVariable("maphim") Integer maphim
			)
	{	
		 List<FindLichChieuByIdPhim> ls_lichchieuByIdPhim= this.lcSer.findLichChieuByIdPhim(maphim);
		 model.addAttribute("ls_lichchieuByIdPhim",ls_lichchieuByIdPhim);
		phim phim=this.phimRepo.getById(maphim);
		model.addAttribute("phim",phim);
		return "home/detail";
	}
	
//	@ModelAttribute("phims")
//	public List<phim> listPhim(
//			Model model
//			)
//	{
//		List<phim> ls_phim= this.phimRepo.findAll();
//		System.out.println(ls_phim);
//		return ls_phim;
//	}
	
	@ModelAttribute("phims")
	public List<phim> Country()
	{
		List<phim> ls_phim= new ArrayList<>();
		ls_phim.addAll(this.phimRepo.findAll());
		return ls_phim;
	}
}
