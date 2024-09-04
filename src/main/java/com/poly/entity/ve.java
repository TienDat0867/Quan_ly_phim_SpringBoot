package com.poly.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ve")
public class ve {
	@Id
	@Column(name="mave")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mave;
	
	@Column(name="ngaydatve")
	private LocalDate ngaydatve;
	
	@Column(name="tongtien")
	private Integer tongtien;
	
	@Column(name="trangthai")
	private Integer trangthai;
	
	@Column(name="tongsoghe")
	private Integer tongsoghe;
	
	@Column(name="makh")
	private Integer makh;
	
	@ManyToOne
	@JoinColumn(name="manv")
	private nhanvien nhanvien;
	
	@ManyToOne
	@JoinColumn(name="malichchieu")
	private lichchieu lichchieu;
}
