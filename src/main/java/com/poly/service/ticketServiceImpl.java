package com.poly.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.ticketDAO;
import com.poly.entityDTO.ticketDTO;

@Service
public class ticketServiceImpl implements ticketService {
	@Autowired
	ticketDAO ticketDao;

	@Override
	public HashMap<Integer, ticketDTO> addTicket(Integer maghe, HashMap<Integer, ticketDTO> ticket) {
		// TODO Auto-generated method stub
		return this.ticketDao.addTicket(maghe, ticket);
	}

	@Override
	public HashMap<Integer, ticketDTO> editTicket(Integer maghe, String qty, HashMap<Integer, ticketDTO> ticket) {
		// TODO Auto-generated method stub
		return this.ticketDao.editTicket(maghe, qty, ticket);
	}

	@Override
	public HashMap<Integer, ticketDTO> removeTicket(Integer maghe, HashMap<Integer, ticketDTO> ticket) {
		// TODO Auto-generated method stub
		return this.ticketDao.removeTicket(maghe, ticket);
	}

	@Override
	public int totalQuantity(HashMap<Integer, ticketDTO> ticket) {
		// TODO Auto-generated method stub
		return this.ticketDao.totalQuantity(ticket);
	}

	@Override
	public int totalPrice(HashMap<Integer, ticketDTO> ticket) {
		// TODO Auto-generated method stub
		return this.ticketDao.totalPrice(ticket);
	}
}
