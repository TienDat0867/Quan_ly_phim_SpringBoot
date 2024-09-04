package com.poly.myController.admin;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DAO.phimDAO;
import com.poly.entity.khachhang;
import com.poly.entity.phim;
import com.poly.utils.uploadFileUtil;

import jakarta.validation.Valid;

@Controller
public class phimController {
	
	@Autowired
	phimDAO phimRepo;
	@Autowired
	uploadFileUtil upFile;
	
//	@RequestMapping("/admin/phim")
//	public String index()
//	{
//		return "/admin/phim/managePhim";
//	}
	@RequestMapping("/admin/phim")
	public String manageUsers(Model model)
	{
		List<phim> ls_phim= this.phimRepo.findAll();
		model.addAttribute("ls_phim",ls_phim);
		System.out.println("=>>");
		return "/admin/phim/managePhim";
	}
	@RequestMapping("/admin/phim/create")
	public String create(Model model,
			@ModelAttribute("phim") phim phim
			)
	{
		return "admin/phim/createPhim";
	}
	@PostMapping("/admin/phim/store")
	public String store(
			Model model,
			@Valid @ModelAttribute("phim") phim phim,
			BindingResult result,
			@RequestParam("photo") MultipartFile photo
			
			)
	{
		if(result.hasErrors())
		{
			System.out.println("=>>");
			System.out.println(phim.getTenphim().toString());
			System.out.println(result.getAllErrors().toString());
			System.out.println("Co Loi ");
			model.addAttribute("message","Bạn nhập sai thông tin , kiểm tra lại");
			return "admin/phim/createPhim";
		}
		else
		{
			System.out.println("=>>");
			System.out.println("them thanh cong ");
			File file= this.upFile.upFile(photo);
			phim.setHinhanh(file.getName());
			System.out.println(phim.getTenphim());
			this.phimRepo.save(phim);
			return "redirect:/admin/phim";
		}
		
	}
	@GetMapping("/admin/phim/delete/{maphim}")
	public String delete(
			@PathVariable("maphim") phim phim
			)
	{
//		if(khachhang.getTrangthai()==0)
//		{
//			khachhang.setTrangthai(1);
//		}
//		else
//		{
//			khachhang.setTrangthai(0);
//		}
//		System.out.println("=>>");
//		System.out.println(khachhang.getTrangthai());
//		this.khRepo.save(khachhang);
		this.phimRepo.delete(phim);
		return "redirect:/admin/phim";
	}
	@GetMapping("/admin/phim/edit/{maphim}")
	public String edit(
			Model model,
			@PathVariable("maphim") phim phim ,
			phim phim2
			)
	{
		model.addAttribute("phim", phim);
		return"/admin/phim/editPhim";
	}
	@PostMapping("/admin/phim/update/{maphim}")
	public String update(
			Model model,
			phim phim,
			@PathVariable("maphim") phim phimold,
			BindingResult result,
			@RequestParam("photo") MultipartFile photo
			
				)	
	{
		if(result.hasErrors())
		{
			model.addAttribute("message","Thông tin nhập vào sai, kiểm tra lại ");
			return"/admin/phim/editPhim";
		}else {
			if(photo.isEmpty())
			{
				phim.setHinhanh(phimold.getHinhanh());
			}else
			{
				System.out.println("=>> Photo=" +photo.getName().toString());
				File file= this.upFile.upFile(photo);
				System.out.println(file.getName());
				System.out.println("=>>");
				phim.setHinhanh(file.getName());
				System.out.println(phim.getHinhanh());
			}
			
			this.phimRepo.save(phim);
			System.out.println(phim.getHinhanh());
			return "redirect:/admin/phim";
		}
		
	}

}
