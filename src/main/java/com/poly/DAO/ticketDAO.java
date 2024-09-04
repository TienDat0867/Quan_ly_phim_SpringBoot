package com.poly.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.entity.ghe;
import com.poly.entityDTO.ticketDTO;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.servlet.http.HttpSession;

@Repository
public class ticketDAO {
	@Autowired 
	gheDAO gheDao;
	@Autowired
	HttpSession session;
	public HashMap<Integer , ticketDTO> addTicket(Integer maghe, HashMap<Integer, ticketDTO> ticket)
	{
		ticketDTO item= new ticketDTO();
		ghe ghe= this.gheDao.getById(maghe);
		if(ghe != null && ticket.containsKey(maghe))
		{
			item= ticket.get(maghe);
			item.setSoluong(1);
			item.setGia(ghe.getDongia() * item.getSoluong());
			item.setSoghe(ghe.getSoghe());
		}else
		{
			item.setGhe(ghe);
			item.setSoghe(ghe.getSoghe());
			item.setSoluong(1);
			item.setGia(ghe.getDongia() *item.getSoluong());
		}
		ticket.put(maghe, item);
		return ticket;
	}
	public HashMap<Integer, ticketDTO> editTicket(Integer maghe,String qty, HashMap<Integer,ticketDTO> ticket)
	{
		if(ticket == null)
		{
			return ticket;
		}
		ticketDTO item= new ticketDTO();
		ghe ghe= this.gheDao.getById(maghe);
		if(ticket.containsKey(maghe))
		{
			if(qty.equals("minus") && item.getSoluong() >0)
			{
				item.setSoluong(item.getSoluong()-1);
			}else if(qty.equals("plus") && item.getSoluong()<100)
			{
				item.setSoluong(item.getSoluong()-1);
			}
			item.setGia(item.getSoluong() * ghe.getDongia());
		}
		ticket.put(maghe, item);
		return ticket;
	}
	public HashMap<Integer, ticketDTO> removeTicket(Integer maghe, HashMap<Integer, ticketDTO> ticket)
	{	
		if(ticket == null)
		{
			return ticket;
		}else if(ticket.containsKey(maghe))
		{
			ticket.remove(maghe);
		}
		return ticket;
	}
	
	// Tổng toàn bộ số lượng có trong giỏ hàng được lưu trong Map
	public int totalQuantity(HashMap<Integer, ticketDTO> ticket)
	{
		Integer totalQuantity =0;
		for(Map.Entry<Integer, ticketDTO> tk: ticket.entrySet())
		{
			totalQuantity += tk.getValue().getSoluong();
		}
		return totalQuantity;
	}
	
	// Tổng toàn bộ giá tiền của tất cả vé được lưu trong Map
	public int totalPrice(HashMap<Integer, ticketDTO> ticket)
	{
		int totalPrice=0;
		for(Map.Entry<Integer, ticketDTO> tk: ticket.entrySet())
		{
			totalPrice += tk.getValue().getGia();
		}
		return totalPrice;
	}
}
