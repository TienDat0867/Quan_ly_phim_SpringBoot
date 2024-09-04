package com.poly.utils;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class uploadFileUtil {
	public File upFile( MultipartFile uploadedFile)
	{
		String folderPath="D:\\HK_6\\Java5\\Java5_Space\\DemoMoview\\src\\main\\webapp\\images";
		File myUploadFodel= new File(folderPath);
		
		// Kiểm tra thư mục có tồn tại hay không ? Nếu không có tạo ra folder mới
		if(!myUploadFodel.exists()) {
			myUploadFodel.mkdirs();
		}
		File savedFile=null;
		try {
			// tạo ra 1 chuỗi riêng biệt gắn thêm vào tên file gốc 
			String fileName=uploadedFile.getOriginalFilename();
			// Lưu file vào thư mục đã chọn 
			 savedFile=new File(myUploadFodel,fileName);
			uploadedFile.transferTo(savedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedFile;
	}
	
}
