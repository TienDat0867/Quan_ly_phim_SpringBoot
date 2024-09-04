package com.poly.entity;



import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phim")
public class phim implements Serializable{
	/**
	 * 
	 */
	

	@Id
	@Column(name="maphim")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maphim;
	
	@Column(name="tenphim")
	private String tenphim;
	
	@Column(name="ngaysanxuat")
	private LocalDate ngaysanxuat;
	
	@Column(name="hinhanh")
	private String hinhanh;
	
	@Column(name="quocgia")
	private String quocgia;
	
	@Column(name="thoiluong")
	private Integer thoiluong;
	
	@Column(name="mota")
	private String mota;
	
	@Column(name="href")
	private String href;
	
	
	@ManyToMany
	@JoinTable(
			name="phim_daodien",
			joinColumns = @JoinColumn(name="maphim"),
			inverseJoinColumns = @JoinColumn(name="madaodien")
			)
	private Set<daodien> daodien= new HashSet<>(); 
	
	
	@ManyToMany
	@JoinTable(
			name="phim_loaiphim",
			joinColumns = @JoinColumn(name="maphim"),
			inverseJoinColumns = @JoinColumn(name="maloaiphim")
			)
	private Set<loaiphim> loaiphim =new HashSet<>();
	
	
	@OneToMany(mappedBy = "phim")
	private Set<lichchieu> lichchieu = new HashSet<>();

}
