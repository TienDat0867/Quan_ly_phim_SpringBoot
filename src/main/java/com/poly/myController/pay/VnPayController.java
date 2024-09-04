package com.poly.myController.pay;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.WriterException;
import com.poly.DAO.gheDAO;
import com.poly.DAO.khachhangDAO;
import com.poly.DAO.lichchieuDAO;
import com.poly.DAO.nhanvienDAO;
import com.poly.DAO.veDAO;
import com.poly.config.VNPayService;
import com.poly.entity.ghe;
import com.poly.entity.khachhang;
import com.poly.entity.lichchieu;
import com.poly.entity.nhanvien;
import com.poly.entity.phim;
import com.poly.entityDTO.ticketDTO;
import com.poly.helper.MailerHelper;
import com.poly.model.MailInfo;
import com.poly.service.MailerService;
import com.poly.service.MailerServiceImp;
import com.poly.service.QRCodeService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class VnPayController {
	
	@Autowired
	private VNPayService vnpaySer;
	@Autowired 
	HttpSession session;
	@Autowired 
	lichchieuDAO lichchieuDao;
	
	@Autowired
	gheDAO gheDao;
	
	@Autowired
	veDAO veDao;
	
	@Autowired
	MailerService mailler;
	
	@Autowired
	nhanvienDAO nhanvienDao;
	@Autowired
	QRCodeService QRCodeSer;
	
	@PostMapping("/payment")
	public String checkout(
			HttpServletRequest request
			)
	{
		int totalPrice = (int) session.getAttribute("totalPrice");
		Integer malichchieu= (Integer) session.getAttribute("malichchieu");
		String orderInfo =	String.valueOf(malichchieu);
		System.out.println(orderInfo);
		 String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		 String vnpayUrl= this.vnpaySer.createOrder(totalPrice, orderInfo, baseUrl);
		 Integer makh= (Integer) session.getAttribute("makh");
       	 System.out.println("makh : " + makh);
       	 
       	 Integer manv= (Integer) session.getAttribute("manvOnl");
       	 System.out.println("manvOnl : " + manv);
       	 
       	 Integer matk= (Integer) session.getAttribute("matk");
       	 System.out.println("matk : " + matk);
		return "redirect:" + vnpayUrl;
	}
	   @RequestMapping("/returnPayment")
	    public String thanks(HttpServletRequest request, Model model) throws WriterException, IOException{
	        int paymentStatus =this.vnpaySer.orderReturn(request);
	        request.setCharacterEncoding("UTF-8");
	        String orderInfo = request.getParameter("vnp_OrderInfo");
	        String paymentTime = request.getParameter("vnp_PayDate");
	        String transactionId = request.getParameter("vnp_TransactionNo");
	        String totalPrice = request.getParameter("vnp_Amount");
	        Integer malichchieu= Integer.valueOf(orderInfo);
	        lichchieu lichchieu= this.lichchieuDao.getById(malichchieu);
	        System.out.println(orderInfo);
	        model.addAttribute("orderId", orderInfo);
	        model.addAttribute("totalPrice", totalPrice);
	        model.addAttribute("paymentTime", paymentTime);
	        model.addAttribute("transactionId", transactionId);
	        
	        HashMap<Integer, ticketDTO> ticket= (HashMap<Integer, ticketDTO>) session.getAttribute("ticket");
	        List<Integer> ls_maghe= new ArrayList<>();
	        List<ghe> ls_ghe= new ArrayList<>();
	        Integer maghe = 0 ;
	        
 	        for(Map.Entry<Integer, ticketDTO> tk: ticket.entrySet())
 	        {
 	        		maghe= tk.getKey();
 	        		ls_ghe.add(tk.getValue().getGhe());
 	        	System.out.println("maghe : " + tk.getKey());
 	        }
 	        ls_maghe.add(maghe);
	        if(paymentStatus ==1 )
	        {
	        	model.addAttribute("status", "Thanh Toán Thành Công ");
	        	model.addAttribute("ls_maghe", ls_maghe);
	        	 for(Integer g: ls_maghe)
	  	        {
	  	        	ghe ghe= this.gheDao.getById(g);
	  	        	ghe.setTrangthai(0);
	  	        	this.gheDao.save(ghe);
	  	        }
	        	 Integer total= (Integer) session.getAttribute("totalPrice");
	    	     Integer makh= (Integer) session.getAttribute("makh");
	    	     // lấy dự liệu khách hàng nhưng từ bảng nhân vienen ( do bảng khách hàng null)
	    	     nhanvien kh= this.nhanvienDao.getById(makh);
	           	 this.veDao.addVe(total);
	           	 // Thiết Lập để gửi Mail
	           	 MailerHelper helper= new MailerHelper();
	           	 List<File> files= new ArrayList<>();
	           	 MailInfo mail= new MailInfo();
	           	 //setMailKhachhang
	           	 mail.setTo(kh.getEmail());
	           	 mail.setSubject("Thông Tin Hóa Đơn Mua Vé");
	           	 
	           	 // tạo lớp stringbuilder để lưu thông tin dưới dạng html để luuw vào setBody
	           	 StringBuilder bodyBuilder = new StringBuilder();
	           	 bodyBuilder.append("<html><body>");
	    		 bodyBuilder.append("<p>Kính chào quý khách,</p>");
	    		 bodyBuilder.append("<p>Cảm ơn quý khách đã mua vé. Dưới đây là thông tin hóa đơn của quý khách:</p>");
	    		 bodyBuilder.append("<p>Tên khách hàng: ").append(kh.getHoten()).append("<br>");
	    		 bodyBuilder.append("Email: ").append(kh.getEmail()).append("<br>");
	    		 bodyBuilder.append("Số điện thoại: ").append(kh.getSdt()).append("<br>");
	    		 bodyBuilder.append("Tổng tiền: ").append(total).append("VND").append("</p>");
	    		 bodyBuilder.append("<p>Thông tin chi tiết:</p><ul>");
	    		 for(ghe g:ls_ghe)
	    		 {
	    			 bodyBuilder.append("<li>").append(" Ghế số \n").append(g.getSoghe()).append("*").append(g.getDongia()).append("</li>");
	    		 }
	    		 bodyBuilder.append("</ul>");
	    		 bodyBuilder.append("<p>Chúc quý khách có một chuyến xem phim vui vẻ!</p>");
	    		 bodyBuilder.append("<p>Trân trọng,<br>Công ty Filmlane</p>");
	    		 bodyBuilder.append("</body></html>");
	           	 mail.setBody(bodyBuilder.toString());
	           	 
	           	 //Gọi lớp service để tạo ra qr , lớp này trả về qr code dưới dạng file
	           	 // Tạo list file để lưu file qr code dưới dạng file và setVao mail.setFile
	           	 List<File> ls_file= new ArrayList<File>();
	           	 ls_file.add(this.QRCodeSer.sendQR(bodyBuilder.toString()));
	           	 mail.setFiles(ls_file);
	           	 try {
					this.mailler.send(mail);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	 
	        }else
	        {
	        	model.addAttribute("status", "Thanh Toán Thất Bại");
	        }
	    
	        return "home/thanks";
	    }


}
