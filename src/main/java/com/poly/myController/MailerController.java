package com.poly.myController;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DAO.nhanvienDAO;
import com.poly.entity.nhanvien;

import com.poly.helper.MailerHelper;
import com.poly.model.MailInfo;
import com.poly.service.MailerService;
import com.poly.utils.AccountExcelExporte;

import jakarta.servlet.http.HttpServletResponse;




@Controller
@RequestMapping("mailer")
public class MailerController {
	@Autowired
	MailerService mailer;
	@Autowired nhanvienDAO nvrpo;
	@GetMapping("")
	public String mailViewer() {
		return "mail/index";
	}

	@ResponseBody
	@PostMapping("/send")
	public String send(Model model, 
			@RequestParam String txtTo, 
			@RequestParam String txtCC,
			@RequestParam String txtBCC,
			@RequestParam String txtSubject,
			@RequestParam String txtContent,
			@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("file1") MultipartFile multipartFile1) throws IOException {
		MailerHelper helper=new MailerHelper();
		List<File> files=new ArrayList<>();
		String[] emailCC=helper.parseStringEmailToArray(txtCC);
		String[] emailBCC=helper.parseStringEmailToArray(txtBCC);
		MailInfo mail = new MailInfo();
		mail.setTo(txtTo);
		mail.setCc(emailCC);
		mail.setBcc(emailBCC);
		mail.setSubject(txtSubject);
		mail.setBody(txtContent);
		//covert MultipartFile to File
		if(!multipartFile.isEmpty()) {
			File file=helper.convertMultipartFileToFile(multipartFile);
			files.add(file);
			//Set cho MailInfo
			mail.setFiles(files);			
		}
		if(!multipartFile1.isEmpty()) {
			File file=helper.convertMultipartFileToFile(multipartFile1);
			files.add(file);
			//Set cho MailInfo
			mail.setFiles(files);			
		}
		//Gửi mail vào queue
		mailer.queue(mail);
		//gửi mail trực tiếp
	
//		try {
//			mailer.send(mail);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		return "<h1>Mail của bạn đã được gửi đi</h1>";
	}
	
 
}
