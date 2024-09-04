package com.poly.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.lichchieuDAO;
import com.poly.entity.lichchieu;
import com.poly.entityReport.FindLichChieuByIdPhim;
import com.poly.entityReport.FindLichChieuByIdPhimanDay;
import com.poly.entityReport.LichChieuResult;

@Service
public class lichchieuServiceImpl implements lichchieuService {
	
	@Autowired
	lichchieuDAO lichchieuDAO;
	
	@Override
	public List<FindLichChieuByIdPhim> findLichChieuByIdPhim(Integer maphim) {
		// TODO Auto-generated method stub
		return lichchieuDAO.findLichChieuByIdPhim(maphim);
	}

	@Override
	public List<FindLichChieuByIdPhimanDay> findLichChieuByIdPhimanDay(Integer maphim, LocalDate ngaychieu) {
		// TODO Auto-generated method stub
		return lichchieuDAO.findLichChieuByIdPhimanDay(maphim, ngaychieu);
	}

	
	
	
	@Override 
	public lichchieu findById(Integer malichchieu) {
		return this.lichchieuDAO.getById(malichchieu);
	}

	@Override
	public List<LichChieuResult> findLichChieuResults(Integer maphim, LocalDate ngayChieu, String gioChieu) {
		// TODO Auto-generated method stub
		return this.lichchieuDAO.findLichChieuResults(maphim, ngayChieu, gioChieu);
	}


	





}
