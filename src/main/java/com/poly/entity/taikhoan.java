package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="taikhoan")
public class taikhoan  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer matk;
	
	
	private String tendn;
	
	
	private String matkhau;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "ngaytao")
	private Date ngaytao = new Date();
	
	
	private Integer loaitk;

	@OneToMany(mappedBy = "matk")
	@JsonIgnore
	List<nhanvien> nhanviens;
	
	  @Override
	  
	    public String toString() {
	        return "taikhoan{" +
	               "matk=" + matk +
	               ", tendn='" + tendn + '\'' +
	               // other attributes
	               '}';
	    }

}
