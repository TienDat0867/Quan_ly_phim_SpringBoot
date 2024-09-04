package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.ghe;

public interface gheDAO extends JpaRepository<ghe, Integer> {
	// lay ra cac ghe theo ma phong 
//	@Query("SELECT ghe(g.maghe , g.soghe , g.dongia , g.loaighe, g.)"
//			+ " FROM ghe g JOIN g.phongchieu pc"
//			+ " WHERE g.maphongchieu = ?1")
//			List<ghe> findGheByMaPC(Integer maphongchieu);
			
}
