package com.poly.entityReport;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FindLichChieuByIdPhimanDay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Serializable tenphim;
	
	private String tenphongchieu;
	
	private LocalDate ngaychieu;
	
	private String giochieu;
	
}
