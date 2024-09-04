package com.poly.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="khachhang")
public class khachhang {
	@Id
	@Column(name="makh")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer makh;
	
	
	@Column(name="hoten")
	private String hoten;
	

	@Column(name="diachi")
	private String diachi;
	
	@Email

	@Column(name="email")
	private String email;
	
	
	@Column(name="sodienthoai")

	private String sodienthoai;
	
	
	@Column(name="ngaysinh")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	

	@Column(name="anh")
	private String anh;
	
	@Column(name="trangthai")
	private Integer trangthai=1;
	
}
