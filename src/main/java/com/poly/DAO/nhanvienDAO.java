package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.nhanvien;

public interface nhanvienDAO extends JpaRepository<nhanvien, Integer> {

	List<nhanvien> findByhotenEndingWith(String name);
	
	  @Query("SELECT nv FROM nhanvien nv WHERE nv.matk.matk = :matk")
	    nhanvien findNhanvienByMatk( Integer matk);
	  
	  @Query("SELECT nv FROM nhanvien nv WHERE nv.matk.matk = :matk")
	   List<nhanvien>  findNhanvienByMatkList( Integer matk);
	  
	
}
