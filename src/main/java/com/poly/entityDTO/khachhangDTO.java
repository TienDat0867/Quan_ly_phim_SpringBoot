package com.poly.entityDTO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class khachhangDTO {
	
	private Integer makh;
	
	@NotBlank
	private String hoten;
	
	@NotBlank
	private String diachi;
	
	@Email
	@NotBlank
	private String email;
	
	@Pattern(regexp = "^\\d{10}$", message = "Vui lòng nhập đúng 10 ký tự là số")
	private String sodienthoai;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	
	
	private String anh;
	
	private Integer trangthai=1;
}
