package com.poly.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.entity.ghe;
import com.poly.entity.phim;
import com.poly.entity.ve;
import com.poly.entity.vechitiet;
import com.poly.entityDTO.ticketDTO;

import jakarta.servlet.http.HttpSession;

@Repository
public class veDAO {
	@Autowired
	veRepo veRepo;
	
	@Autowired 
	khachhangDAO khachhangDao;
	
	@Autowired 
	nhanvienDAO nhanvienDao;
	
	@Autowired 
	lichchieuDAO lichchieuDao;
	
	@Autowired
	vechitietRepo vechitietDao;
	
	@Autowired 
	HttpSession session;
	
	public int addVe(Integer totalPrice)
	{
		ve ve= new ve();
		ve.setNgaydatve(LocalDate.now());
		ve.setTongtien(totalPrice);
		ve.setTrangthai(1);
		List<String> ls_seat= (List<String>) session.getAttribute("ls_seat");
		System.out.println(ls_seat);
		ve.setTongsoghe(ls_seat.size());
		System.out.println("--------");
		Integer makh= (Integer) session.getAttribute("makh");
		System.out.println("makh : " + makh);
		ve.setMakh(makh);
		Integer manv= (Integer) session.getAttribute("manvOnl");
		ve.setNhanvien(this.nhanvienDao.getById(manv));
		System.out.println("manvOnl : " +manv);
		Integer malichchieu=(Integer) session.getAttribute("malichchieu");
		System.out.println("malichchieu : " + malichchieu);
		System.out.println("mave : " + ve.getMave());
		ve.setLichchieu(this.lichchieuDao.getById(malichchieu));
		this.veRepo.save(ve);
		
		// Thêm Vé Chi Tiết
		vechitiet vechitietThuong= new vechitiet();
		vechitiet vechitietVip= new vechitiet();
		phim phimChoose= (phim) session.getAttribute("phimChoose");
		
		
		List<ghe> ls_ghe= new ArrayList<>();
		List<ghe> ls_gheThuong= new ArrayList<ghe>();
		List<ghe> ls_gheVip= new ArrayList<ghe>();
		Integer soluongThuong=0;
		Integer soluongVip=0;
		HashMap<Integer, ticketDTO> ticket= (HashMap<Integer, ticketDTO>) session.getAttribute("ticket");
		for(Map.Entry<Integer, ticketDTO> tk : ticket.entrySet())
		{
			ls_ghe.add(tk.getValue().getGhe());
		}
		for(ghe g:ls_ghe)
		{
			
			
			if(g.getLoaighe()==1)
			{
				soluongThuong +=1;
				vechitietThuong.setVe(ve);
				vechitietThuong.setPhim(phimChoose);
				ls_gheThuong.add(g);
				vechitietThuong.setGhe(g);
				vechitietThuong.setDongia(g.getDongia());
				vechitietThuong.setSoluong(soluongThuong);
				vechitietThuong.setTongtien(soluongThuong * g.getDongia());
				this.vechitietDao.save(vechitietThuong);
			}
			if(g.getLoaighe()==2)
			{
				soluongVip +=1;
				vechitietVip.setVe(ve);
				vechitietVip.setPhim(phimChoose);
				ls_gheVip.add(g);
				vechitietVip.setGhe(g);
				vechitietVip.setDongia(g.getDongia());
				vechitietVip.setSoluong(soluongVip);
				vechitietVip.setTongtien(soluongVip * g.getDongia());this.vechitietDao.save(vechitietVip);
			}
			
		}
		return ve.getMave();
	}

}
