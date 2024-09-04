package com.poly.entity;

import java.io.Serializable;
import java.util.List;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ghe")
public class ghe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="maghe")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maghe;
	
	@Column(name="soghe")
	private String soghe;
	
	@Column(name="dongia")
	private Integer dongia;
	
	@Column(name="loaighe")
	private Integer loaighe;
	
	@Column(name="trangthai")
	private Integer trangthai;
	
	@ManyToOne
	@JoinColumn(name="maphongchieu")
	private phongchieu phongchieu;
	
	@OneToMany(mappedBy = "ghe")
	private List<vechitiet> ls_vechitiet;

}
