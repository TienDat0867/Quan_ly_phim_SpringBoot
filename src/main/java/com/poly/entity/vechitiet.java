package com.poly.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vechitiet")
public class vechitiet {
	@Id
	@Column(name="mavechitiet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mavechitiet;
	
	@Column(name="dongia")
	private Integer dongia;
	
	@Column(name="soluong")
	private Integer soluong;
	
	@Column(name="tongtien")
	private Integer tongtien;
	
	@ManyToOne
	@JoinColumn(name="maphim")
	private phim phim;
	
	@ManyToOne
	@JoinColumn(name="mave")
	private ve ve;
	
	@ManyToOne
	@JoinColumn(name="maghe")
	private ghe ghe;
	
	
	
	
}
