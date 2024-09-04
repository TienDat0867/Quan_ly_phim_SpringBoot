package com.poly.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.poly.DAO.ticketDAO;
import com.poly.entityDTO.ticketDTO;

public interface ticketService {
	public HashMap<Integer , ticketDTO> addTicket(Integer maghe, HashMap<Integer, ticketDTO> ticket);
	public HashMap<Integer, ticketDTO> editTicket(Integer maghe,String qty, HashMap<Integer,ticketDTO> ticket);
	public HashMap<Integer, ticketDTO> removeTicket(Integer maghe, HashMap<Integer, ticketDTO> ticket);
	public int totalQuantity(HashMap<Integer, ticketDTO> ticket);
	public int totalPrice(HashMap<Integer, ticketDTO> ticket);
}
