package com.poly.myController.admin;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import com.poly.DAO.khachhangDAO;
import com.poly.DAO.taikhoanDAO;
import com.poly.entity.khachhang;
import com.poly.entityDTO.khachhangDTO;
import com.poly.mapper.khachhangMapper;
import com.poly.utils.uploadFileUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class adminController {
	
	@Autowired
	khachhangDAO khRepo;
	@Autowired
	taikhoanDAO tkRepo;
	@Autowired
	uploadFileUtil upFile;	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	khachhangMapper khMapper;
	
	@RequestMapping("/admin/index")
	public String index()
	{
		return "admin/index";
	}
	@RequestMapping("/admin/users")
	public String manageUsers(Model model)
	{
		String sortBy= request.getParameter("sortBy");
		System.out.println(sortBy);
		List<khachhang> ls_khachhang ;
		if(sortBy !=null)
		{
			String sort_deriection= request.getParameter("sortDirection");
			Sort sort;
			if(sort_deriection == null || sort_deriection.equals("asc"))
			{
				 sort =Sort.by(Direction.ASC,sortBy);
			}else {	
				sort=Sort.by(Direction.DESC,sortBy);
			}
			 ls_khachhang= this.khRepo.findAll(sort);
		}else
		{
			 ls_khachhang= this.khRepo.findAll();
		}
		
		model.addAttribute("ls_khachhang",ls_khachhang);
		System.out.println("=>>");
		return "admin/users/manageUsers";
	}
	@RequestMapping("/admin/users/create")
	public String create(Model model,
			 khachhangDTO khachhangDTO
			)
	{
		model.addAttribute("khachhang",khachhangDTO);
		return "admin/users/createUsers";
	}
	@PostMapping("/admin/users/store")
	public String store(
			Model model,
			@Valid @ModelAttribute("khachhang") khachhangDTO khachhangDTO,
			BindingResult result,
			@RequestParam("photo") MultipartFile photo
			)
	{
		if(result.hasErrors())
		{
			System.out.println("=>>");
			System.out.println(khachhangDTO.getHoten().toString());
			System.out.println(result.getAllErrors().toString());
			System.out.println("Co Loi ");
			model.addAttribute("message","Bạn nhập sai thông tin , kiểm tra lại");
			return "admin/users/createUsers";
		}
		else
		{
			System.out.println("=>>");
			System.out.println("them thanh cong ");
			File upfile=this.upFile.upFile(photo);
			khachhangDTO.setAnh(upfile.getName());
			System.out.println(khachhangDTO.getHoten());
			khachhang khachhang= khMapper.convertToEntity(khachhangDTO);
			this.khRepo.save(khachhang);
			return "redirect:/admin/users";
		}
	}
	@GetMapping("/admin/users/delete/{makh}")
	public String delete(
			@PathVariable("makh") khachhang khachhang
			)
	{
		if(khachhang.getTrangthai()==0)
		{
			khachhang.setTrangthai(1);
		}
		else
		{
			khachhang.setTrangthai(0);
		}
		System.out.println("=>>");
		System.out.println(khachhang.getTrangthai());
		khachhangDTO khachhangDTO = khMapper.convertToDTO(khachhang);
		this.khRepo.save(khachhang);
//		this.khRepo.delete(khachhang);
		return "redirect:/admin/users";
	}
	@GetMapping("/admin/users/edit/{makh}")
	public String edit(
			Model model,
			@PathVariable("makh") khachhang khachhang ,
			khachhang khachhang2
			)
	{
		khachhangDTO khachhangDTO=this.khMapper.convertToDTO(khachhang);
		model.addAttribute("khachhang", khachhangDTO);
		return"/admin/users/editUsers";
	}
	@PostMapping("/admin/users/update/{makh}")
	public String update(
			Model model,
			khachhangDTO khachhangDTO,
			@PathVariable("makh") khachhang khachhangold,
			BindingResult result,
			@RequestParam("photo") MultipartFile photo
			
				)	
	{
		if(result.hasErrors())
		{
			model.addAttribute("message","Thông tin nhập vào sai, kiểm tra lại ");
			return "redirect:/admin/users/edit";
		}else {
			if(photo.isEmpty())
			{
				khachhangDTO.setAnh(khachhangold.getAnh());
			}else
			{
				File uploadedFile= this.upFile.upFile(photo);
				khachhangDTO.setAnh(uploadedFile.getName());
			}
			khachhang khachhang= khMapper.convertToEntity(khachhangDTO);
			this.khRepo.save(khachhang);
			return "redirect:/admin/users";
		}
		
	}
}
