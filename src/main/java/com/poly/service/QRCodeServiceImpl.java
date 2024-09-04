package com.poly.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.WriterException;
import com.poly.utils.QRCodeGenerator;

@Service
public class QRCodeServiceImpl implements QRCodeService {

	@Autowired
    private QRCodeGenerator qrCodeGenerator;
	
	public File sendQR(@RequestParam String text) throws WriterException, IOException {
		
		 File qrFile = qrCodeGenerator.generateQRCodeFile(text, 350, 350);
        
         return qrFile;
	}
	public int deleateQR(File qrFile) {
		 // Xóa tệp tạm sau khi gửi email
        qrFile.delete(); 
		return 1;
	}
}
