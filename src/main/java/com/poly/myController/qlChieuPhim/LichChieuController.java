package com.poly.myController.qlChieuPhim;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.DAO.gheDAO;
import com.poly.DAO.nhanvienDAO;
import com.poly.DAO.phimDAO;
import com.poly.entity.ghe;
import com.poly.entity.lichchieu;
import com.poly.entity.nhanvien;
import com.poly.entity.phim;
import com.poly.entityDTO.ticketDTO;
import com.poly.entityReport.FindLichChieuByIdPhim;
import com.poly.entityReport.FindLichChieuByIdPhimanDay;
import com.poly.entityReport.LichChieuResult;
import com.poly.service.lichchieuService;
import com.poly.service.lichchieuServiceImpl;
import com.poly.service.ticketServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LichChieuController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	gheDAO gheDao;
		
	@Autowired 
	HttpSession session;
	
	 @Autowired
	 lichchieuServiceImpl lcSer;
	 
	 @Autowired 
	 phimDAO phimDao;
	 
	 @Autowired 
	 nhanvienDAO nhanvienDao;
	 
	 @Autowired 
	 ticketServiceImpl ticketSer;
	 
	 @RequestMapping("/home/ticket")
	 public String bookPhim(
			 Model model
			 )
	 {
		 List<phim> ls_phim= this.phimDao.findAll();
		 model.addAttribute("ls_phim",ls_phim);
		 return "/home/ticket";
	 }
	 @GetMapping("home/ticket")
	 public String chooseFilm(
			 Model model,
			 @RequestParam("maphim") Integer maphim
			 )
	 {
		 List<phim> ls_phim= this.phimDao.findAll();
		 model.addAttribute("ls_phim", ls_phim);
		 phim phimChoose= this.phimDao.getById(maphim);
		 session.setAttribute("phimChoose", phimChoose);
		 model.addAttribute("phimChoose",phimChoose);
		 
		 List<FindLichChieuByIdPhim> ls_lichchieuByIdPhim= this.lcSer.findLichChieuByIdPhim(maphim);
		 model.addAttribute("ls_lichchieuByIdPhim",ls_lichchieuByIdPhim);
		 Integer makh= (Integer) session.getAttribute("makh");
		 nhanvien kh=nhanvienDao.getById(makh);
		
		 return "home/ticket";
	 }
	 
	 @GetMapping("home/ticket/day")
	 public String chooseFilmDay(
			 Model model,
			 @RequestParam("ngaychieu")  LocalDate ngaychieu
			 )
	 {
		 List<phim> ls_phim= this.phimDao.findAll();
		 model.addAttribute("ls_phim", ls_phim);
		 phim phimChoose= (phim) session.getAttribute("phimChoose");
		 model.addAttribute("phimChoose",phimChoose);
		 
		 List<FindLichChieuByIdPhim> ls_lichchieuByIdPhim= this.lcSer.findLichChieuByIdPhim(phimChoose.getMaphim());
		 model.addAttribute("ls_lichchieuByIdPhim",ls_lichchieuByIdPhim);
		 model.addAttribute("ngaychieuChoose",ngaychieu);
		 session.setAttribute("ngaychieu", ngaychieu);
		 List<FindLichChieuByIdPhimanDay> ls_lichchieuByIdPhimAndDay= this.lcSer.findLichChieuByIdPhimanDay(phimChoose.getMaphim(), ngaychieu);
		 model.addAttribute("ls_lichchieuByIdPhimAndDay",ls_lichchieuByIdPhimAndDay);
		 return "home/ticket";
	 }

	 @GetMapping("/home/ticket/time")
	 public String bookSeat(
			 Model model,
			 @RequestParam("giochieu")  String giochieu
			 )
	 {
		 List<phim> ls_phim= this.phimDao.findAll();
		 model.addAttribute("ls_phim", ls_phim);
		 phim phimChoose= (phim) session.getAttribute("phimChoose");
		 Integer maphim= phimChoose.getMaphim();
		 List<FindLichChieuByIdPhim> ls_lichchieuByIdPhim= this.lcSer.findLichChieuByIdPhim(phimChoose.getMaphim());
		 model.addAttribute("ls_lichchieuByIdPhim",ls_lichchieuByIdPhim);
		 model.addAttribute("phimChoose",phimChoose);
		 
		 LocalDate ngaychieu= (LocalDate) session.getAttribute("ngaychieu");
		 List<FindLichChieuByIdPhimanDay> ls_lichchieuByIdPhimAndDay= this.lcSer.findLichChieuByIdPhimanDay(phimChoose.getMaphim(), ngaychieu);
		 model.addAttribute("ls_lichchieuByIdPhimAndDay",ls_lichchieuByIdPhimAndDay);
		 model.addAttribute("ngaychieuChoose",ngaychieu);
		 
		
		 session.setAttribute("giochieu", giochieu);
		 model.addAttribute("giochieuChoose",giochieu);
		 List<LichChieuResult> ls_xuatChieu= this.lcSer.findLichChieuResults(maphim, ngaychieu, giochieu);
		 model.addAttribute("ls_xuatChieu",ls_xuatChieu);
		 session.setAttribute("malichchieu", ls_xuatChieu.get(0).getMalichchieu());
		 System.out.println("malichchieu "+session.getAttribute("malichchieu"));
		 List<ghe> ls_ghe= this.gheDao.findAll();
		 List<ghe> gheByPC = new ArrayList<>();
		 List<ghe> gheThuong= new ArrayList<>();
		 List<ghe> gheVip= new ArrayList<>();
		 for(ghe g: ls_ghe)
		 {
			 if(g.getPhongchieu().getMaphongchieu() == ls_xuatChieu.get(0).getMaphongchieu())
			 {
				 gheByPC.add(g);
					// System.out.println(g.getLoaighe());
			 }
		 }
		 for(ghe g: gheByPC)
		 {
			 if(g.getLoaighe()==1)
			 {
				 gheThuong.add(g);
			 }
			 if(g.getLoaighe()==2) 
			 {
				 gheVip.add(g);
			 }
		 }
//		 System.out.println(gheByPC.size());
//		 System.out.println(gheThuong.size());
//		 System.out.println(gheVip.size());
		 model.addAttribute("gheByPC" ,gheByPC);
		 model.addAttribute("gheThuong" ,gheThuong);
		 model.addAttribute("gheVip" ,gheVip);
//		 for(LichChieuResult p:ls_xuatChieu)
//		 {
//			 System.out.println(p.getTenphim());
//			 System.out.println(p.getCountghe());
//			 System.out.println(p.getMaphongchieu());
//		 }
//		 return "";
		 return "home/ticket";
	 }
	 
	 @RequestMapping("/home/chooseSeat/{maghe}")
	 public String bookSeat(
			 Model model,
			 @PathVariable("maghe") Integer maghe
			 )
	 {
		 HashMap<Integer , ticketDTO> ticket= (HashMap<Integer, ticketDTO>) session.getAttribute("ticket");
		 if(ticket == null)
		 {
			 ticket= new HashMap<Integer, ticketDTO>();
		 }
		 if(ticket.containsKey(maghe))
		 {
			 System.out.println(maghe);
			 this.ticketSer.removeTicket(maghe, ticket);
		 }else {
			 this.ticketSer.addTicket(maghe, ticket);
		 }
		 session.setAttribute("ticket",ticket );
		 session.setAttribute("totalQuantity",  this.ticketSer.totalQuantity(ticket));
		 session.setAttribute("totalPrice", this.ticketSer.totalPrice(ticket));
		 model.addAttribute("totalQuantity",session.getAttribute("totalQuantity"));
		 model.addAttribute("totalPrice",session.getAttribute("totalPrice"));
		 List<String > ls_seat= new ArrayList<String>();
		  for (Map.Entry<Integer,ticketDTO > tk1 : ticket.entrySet()) {
	            Integer key = tk1.getKey();
	            ticketDTO value = tk1.getValue();
	            ls_seat.add(value.getSoghe());
		  		}
		  session.setAttribute("ls_seat", ls_seat);
//	            System.out.println("Key: " + key + ","
//	            		+ " Soghe: " + value.getSoghe()+ " giatien : " + value.getGia() + " soluong :" + value.getSoluong());
//		 System.out.println("totalQuantity"+session.getAttribute("totalQuantity"));
//		 System.out.println("totalPrice"+session.getAttribute("totalPrice"));
//		 System.out.println("So ghe :" +tk.getSoghe());
//		 System.out.println("Don Gia :" +tk.getGia());
//		 System.out.println("So Luong ghe : " +tk.getSoluong());
//		 System.out.println("Gia ve :" +tk.getGhe().getDongia());
//		 HashMap<Integer , ticketDTO> map= (HashMap<Integer, ticketDTO>) session.getAttribute("ticket");
//		 System.out.println("Session");
//		  for (Map.Entry<Integer,ticketDTO > map1 : ticket.entrySet()) {
//	            Integer key = map1.getKey();
//	            ticketDTO value = map1.getValue();
//	            System.out.println("Key: " + key + ","
//	            		+ " Soghe: " + value.getSoghe()+ " giatien : " + value.getGia() + " soluong :" + value.getSoluong());
//	        }
		 return "redirect:" +request.getHeader("Referer");
	 }
	 
	 @RequestMapping("/checkout")
	 public String checkout()
	 {
		 return "home/checkout";
	 }
}
