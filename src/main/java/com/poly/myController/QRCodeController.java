//package com.poly.myController;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//
//import com.google.zxing.WriterException;
//import com.poly.utils.QRCodeGenerator;
//
//@RestController
//public class QRCodeController {
//
//    @Autowired
//    private QRCodeGenerator qrCodeGenerator;
//
//    @GetMapping("/sendQR")
//    public ResponseEntity<String> sendQR(@RequestParam String text) {
//        try {
//            File qrFile = qrCodeGenerator.generateQRCodeFile(text, 350, 350);
//            // Xóa tệp tạm sau khi gửi email
//            qrFile.delete(); 
//
//            return ResponseEntity.ok("QR Code sent successfully to " );
//        } catch (WriterException | IOException | MessagingException e) {
//            return ResponseEntity.status(500).body("Error sending QR Code: " + e.getMessage());
//        }
//    }
//}
