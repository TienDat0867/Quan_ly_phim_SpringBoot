package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhanvien")
public class nhanvien implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer manv;
//	@NotBlank(message = "{vui lòng nhập họ tên}")
	String hoten;
	String email;
	Integer sdt;
	String diachi;
	String anh;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "ngayvaolam")
	Date ngayvaolam = new Date(); 
	boolean trangthai;
	@ManyToOne
	@JoinColumn(name = "matk")
	taikhoan matk;
	Integer chucvu;
	
	@OneToMany(mappedBy = "nhanvien")
	private List<ve> ls_ve;
}
