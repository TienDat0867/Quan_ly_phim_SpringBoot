package com.poly.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.poly.entity.lichchieu;
import com.poly.entityReport.FindLichChieuByIdPhim;
import com.poly.entityReport.FindLichChieuByIdPhimanDay;
import com.poly.entityReport.LichChieuResult;

@Service
public interface lichchieuService {
	public lichchieu findById(Integer malichchieu);
	List<FindLichChieuByIdPhim> findLichChieuByIdPhim(Integer maphim);
	List<FindLichChieuByIdPhimanDay> findLichChieuByIdPhimanDay(Integer maphim, LocalDate ngaychieu);
	List<LichChieuResult> findLichChieuResults(@Param("maphim") Integer maphim, 
            @Param("ngayChieu") LocalDate ngayChieu, 
            @Param("gioChieu") String gioChieu);
}
