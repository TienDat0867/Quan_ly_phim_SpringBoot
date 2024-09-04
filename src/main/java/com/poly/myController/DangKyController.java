package com.poly.myController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.DAO.nhanvienDAO;
import com.poly.DAO.taikhoanDAO;
import com.poly.entity.nhanvien;
import com.poly.entity.taikhoan;
//import com.poly.repository.nhanvienRepo;
//import com.poly.repository.taikhoanRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class DangKyController {
	@Autowired taikhoanDAO tkrpo;
	@Autowired nhanvienDAO nvtpo;
	@Autowired HttpSession session;
@RequestMapping("/DangKy")
public String dangKy(Model model,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("forgotPass") String forgot)
{
	taikhoan tk=new taikhoan();
	tk.setTendn(email);
	tk.setMatkhau(password);
	tk.setLoaitk(2);
	if(tk.getMatkhau().equals(forgot))
	{
		
		tkrpo.save(tk);
		model.addAttribute("message","Đăng ký thành công");
	}
	else {
		model.addAttribute("message","Mật khẩu và nhập lại mật khẩu không trùng khớp");
	}

	return "login/register";
}
@RequestMapping("/themThongTinTaiKhoan/{matk}")
public String matk(@PathVariable("matk")Integer matk,Model model )
{
	nhanvien item=new nhanvien();
	model.addAttribute("item",item);
	taikhoan tk=new taikhoan();
	String tennv=(String) session.getAttribute("tenNv");
	String email=(String) session.getAttribute("email");
	item.setHoten(tennv);
	tk.setMatk(matk);
	item.setMatk(tk);
	item.setEmail(email);
	
	item=nvtpo.findNhanvienByMatk(matk);
	
	if(item!=null)
	{
		model.addAttribute("item",item);
		List<nhanvien> items=nvtpo.findNhanvienByMatkList(matk);
		model.addAttribute("items",items);			
		System.out.println(items);
	}
		
	

	
	
	 
	
	System.out.println(matk);
	return "/admin/index";
}
@ModelAttribute("chucvus")
public Map<Integer, String> getchucvu() {
	Map<Integer, String> map = new HashMap<>();
	map.put(1, "nhân viên bán vé");
	map.put(2, "Nhân viên bán nước");
	map.put(3, "Nhân viên lễ tân");
	return map;
}
@ModelAttribute("trangthais")
public Map<Boolean, String> getGenders() {
	Map<Boolean, String> map = new HashMap<>();
	map.put(true, "Đang làm");
	map.put(false, "Nghỉ làm");
	return map;
}

}
