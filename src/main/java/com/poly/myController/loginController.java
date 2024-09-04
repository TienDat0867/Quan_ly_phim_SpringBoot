package com.poly.myController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.DAO.nhanvienDAO;
import com.poly.DAO.taikhoanDAO;
import com.poly.entity.nhanvien;
import com.poly.entity.taikhoan;
//import com.poly.helper.MailInfo;
//import com.poly.helper.MailerHelper;
//import com.poly.repository.nhanvienRepo;
//import com.poly.repository.taikhoanRepo;
//import com.poly.service.MailerService;
import com.poly.helper.MailerHelper;
import com.poly.model.MailInfo;
import com.poly.service.MailerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {
	@Autowired taikhoanDAO tkdao;
	@Autowired nhanvienDAO nvdao;
	@Autowired HttpSession session;
	@Autowired MailerService mailer;
	@RequestMapping("/login1")
	public String login(@RequestParam("email")String email,@RequestParam("password") String password,Model model) {
	    List<taikhoan> item = tkdao.findByTendnAndMatkhau(email, password);
	    
	    System.out.println(item);
	  
	    if (!item.isEmpty()) {
	    	taikhoan taiKhoan = item.get(0); 
	    	// Lấy phần tử đầu tiên từ danh sách
	        Integer matk = taiKhoan.getMatk();
	        session.setAttribute("matk", matk);
	        Integer role=taiKhoan.getLoaitk();
	        //lưu role vào session
	        
	        session.setAttribute("role", role);
	        System.out.println("matk" + matk);
	        session.setAttribute("email", email);
	        nhanvien nv=nvdao.findNhanvienByMatk(matk);
	        nhanvien nv1=nvdao.findNhanvienByMatk(1);
	        Integer manvOnl=nv1.getManv();
	        System.out.println("maNVLogin"+nv1.getManv());
	        session.setAttribute("manvOnl", manvOnl);
	        
	        if(nv!=null)
	        {
	        	 String tenNv=nv.getHoten();
	 	        String anh=nv.getAnh();
	 	        
	 	        if(role==0)
	 	        {
	 	        	String chucvu1="Admin";
	 	        	session.setAttribute("chucVu", chucvu1);
	 	        }
	 	        else if(role==1) {
	 	        	String chucvu1="Nhân viên";
	 	        	session.setAttribute("chucVu", chucvu1);
	 	        }
	 	        else {
	 	        	String chucvu1="Khách hàng";
	 	        	session.setAttribute("chucVu", chucvu1);
	 	        	session.setAttribute("makh", nv.getManv());
	 	        	
	 	        }
	 	        //luư vào sesion
	 	        session.setAttribute("tenNv", tenNv);
	 	        session.setAttribute("anh", anh);
	 	       System.out.println("MaKHLogin"+nv.getManv());
	 	        
//	 	        System.out.println("Tên nhân viên: " + tenNv);
//	 	        System.out.println("Ảnh: " + anh);
	        }
	       
//	       
	        MailerHelper helper=new MailerHelper();
			List<File> files=new ArrayList<>();
			
			MailInfo mail = new MailInfo();
			mail.setTo(email);
			String txtSubject="Thông tin đăng nhập";
			mail.setSubject(txtSubject);
			String txtContent="Gmail bạn đã được đăng nhập thành công tại web xem phim";
			mail.setBody(txtContent);
			mailer.queue(mail);
	        
	        return "redirect:/";
	        
	    }
	    else {
	    	model.addAttribute("message","Sai thông tin đăng nhập");
	    	return "login/login";
	    }
	   
	}
	@RequestMapping("/login")
	public String login() {
	   
	    return "login/login";
	}
	@RequestMapping("/register")
	public String register()
	{
		return "login/register";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		session.invalidate();
		return "redirect:/";
	}
	
}
