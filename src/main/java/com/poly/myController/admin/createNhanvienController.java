package com.poly.myController.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DAO.nhanvienDAO;
import com.poly.entity.nhanvien;
import com.poly.utils.AccountExcelExporte;

//import com.poly.repository.nhanvienRepo;
//import com.poly.utils.AccountExcelExporte;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class createNhanvienController {
	@Autowired
	nhanvienDAO nvrpo;
	@Autowired
	ServletContext app;

	@RequestMapping("/Admin/index111")
	public String show(Model model) {
		nhanvien item = new nhanvien();
		model.addAttribute("item", item);
		List<nhanvien> items = nvrpo.findAll();
		model.addAttribute("items", items);
		System.out.println(items);
		return "/admin/index";
	}

	@RequestMapping("/Admin/create")
	public String create( Model model,nhanvien nv, @RequestParam("luuAnh") MultipartFile file)
			throws IllegalStateException, IOException {
		nhanvien item = new nhanvien();
		model.addAttribute("item", item);
		
		 String uploadRootpath=app.getRealPath("imageNhanVien");
		 File uploadRootDir=new File(uploadRootpath);
		 if(!uploadRootDir.exists())
		 {
			 uploadRootDir.mkdir();
		 }
		 try {
			String filename=file.getOriginalFilename();
			File serverFile=new File(uploadRootDir.getAbsoluteFile()+File.separator+filename);
			BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(file.getBytes());
			stream.close();
			
			nv.setAnh(filename);
			
			System.out.println(filename);
			} catch (Exception e) {
			// TODO: handle exception
		}
			
			nvrpo.save(nv);
			model.addAttribute("message", "Thêm nhân viên thành công");
			return "redirect:/Admin/index111";
		
		
	}

	@RequestMapping("/Admin/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		nhanvien item = nvrpo.findById(id).get();
		model.addAttribute("item", item);
		List<nhanvien> items = nvrpo.findAll();
		model.addAttribute("items", items);
		return "/admin/index";
	}

	@RequestMapping("/Admin/update/{manv}")
	public String update(nhanvien nv ,@PathVariable("manv") Integer manv,@RequestParam("luuAnh") MultipartFile file) {
		 String uploadRootpath=app.getRealPath("imageNhanVien");
		 File uploadRootDir=new File(uploadRootpath);
	
		 try {
				String filename=file.getOriginalFilename();
				File serverFile=new File(uploadRootDir.getAbsoluteFile()+File.separator+filename);
				BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(file.getBytes());
				stream.close();
				
				nv.setAnh(filename);
				
				System.out.println(filename);
				} catch (Exception e) {
				// TODO: handle exception
				}
		nvrpo.save(nv);
		return "redirect:/Admin/edit/" + manv ;
	}

	@RequestMapping("/Admin/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		nvrpo.deleteById(id);
		return "redirect:/Admin/index111";

	}

//	@ModelAttribute("chucviselect")
//	public List<Integer> getchucvu(){
//	return Arrays.asList(1, 2, 3);
//	}
	@ModelAttribute("trangthais")
	public Map<Boolean, String> getGenders() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Đang làm");
		map.put(false, "Nghỉ làm");
		return map;
	}

	@ModelAttribute("chucvus")
	public Map<Integer, String> getchucvu() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "nhân viên bán vé");
		map.put(2, "Nhân viên bán nước");
		map.put(3, "Nhân viên lễ tân");
		return map;
	}
	
@RequestMapping("/findbyname")
public String findbyname( Model model,@RequestParam("find") String find)
{
	nhanvien item = new nhanvien();
	model.addAttribute("item", item);
	List<nhanvien> nv=nvrpo.findByhotenEndingWith(find);
	model.addAttribute("items",nv);
	System.out.println(nv);
	return "/admin/index";
}
@RequestMapping("/export/excel")
public void exportToExcel(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
    response.setHeader(headerKey, headerValue);
     
    List<nhanvien> listUsers = nvrpo.findAll();
    System.out.println(listUsers);
     
    AccountExcelExporte excelExporter = new AccountExcelExporte(listUsers);
     
    excelExporter.export(response);    
}  

@RequestMapping("/Admin/thongKe")
public String thongke ()
{
	return "admin/thongKe";
}
//@RequestMapping("/Admin/index111")
//public String showSort(nhanvien nv, Model model, @RequestParam("field") Optional<String> field,
//		@RequestParam("p") Optional<Integer> p) {
//	Sort sort = Sort.by(Direction.ASC, field.orElse("name"));
//	
//	nhanvien item = new nhanvien();
//	model.addAttribute("item", item);
//	Pageable pageable = PageRequest.of(p.orElse(0), 5, sort);
//	Page<nhanvien> page = nvrpo.findAll(pageable);
//	System.out.println(page);
//	model.addAttribute("page", page);
//
//	return "/admin/index";
//}
	/////
}
