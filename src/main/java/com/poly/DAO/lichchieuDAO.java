package com.poly.DAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.lichchieu;
import com.poly.entityReport.FindLichChieuByIdPhim;
import com.poly.entityReport.FindLichChieuByIdPhimanDay;
import com.poly.entityReport.LichChieuResult;

public interface lichchieuDAO extends JpaRepository<lichchieu, Integer> {
	
	// Tìm lịch chiếu theo mã phim
		@Query("SELECT new FindLichChieuByIdPhim(p.tenphim, pc.tenphongchieu, lc.ngaychieu,lc.giochieu, count(g.maghe)) "
				+" FROM lichchieu lc JOIN lc.phongchieu pc"
				+ " JOIN lc.phim p JOIN pc.ghe g"
				+ " WHERE p.maphim =?1 "
				+ " GROUP BY p.tenphim , lc.ngaychieu,lc.giochieu, pc.tenphongchieu")
				List<FindLichChieuByIdPhim> findLichChieuByIdPhim(Integer maphim);
		
		
		// Tìm lịch chiếu theo mã phim VÀ ngày chiếu
		@Query("SELECT new FindLichChieuByIdPhimanDay(p.tenphim, pc.tenphongchieu, lc.ngaychieu,lc.giochieu) "
				+" FROM lichchieu lc JOIN lc.phongchieu pc"
				+ " JOIN lc.phim p JOIN pc.ghe g"
				+ " WHERE p.maphim =?1 AND lc.ngaychieu=?2"
				+ " GROUP BY p.tenphim , lc.ngaychieu,lc.giochieu, pc.tenphongchieu")
				List<FindLichChieuByIdPhimanDay> findLichChieuByIdPhimanDay(Integer maphim, LocalDate ngaychieu);
		
	// Lấy Suất Chiếu Cụ thể theo mã phim , mã phòng chiếu , thời gian chiếu
		@Query("SELECT new LichChieuResult(p.tenphim, pc.tenphongchieu, lc.ngaychieu, lc.giochieu , count(g.maghe), pc.maphongchieu, lc.malichchieu)" +
			       " FROM lichchieu lc JOIN lc.phongchieu pc " +
			       " JOIN lc.phim p JOIN pc.ghe g" +
			       " WHERE p.maphim = :maphim AND lc.ngaychieu = :ngayChieu AND lc.giochieu = :gioChieu " +
			       " GROUP BY p.tenphim, lc.ngaychieu, lc.giochieu, pc.tenphongchieu, pc.maphongchieu,lc.malichchieu")
			List<LichChieuResult> findLichChieuResults(@Param("maphim") Integer maphim, 
			                                           @Param("ngayChieu") LocalDate ngayChieu, 
			                                           @Param("gioChieu") String gioChieu);
		

}
