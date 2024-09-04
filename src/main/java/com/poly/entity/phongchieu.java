package com.poly.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="phongchieu")
public class phongchieu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="maphongchieu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maphongchieu;
	
	@Column(name="tenphongchieu")
	private String tenphongchieu;
	
	@Column(name="soghetoida")
	private Integer soghetoida;
	
	@OneToMany(mappedBy = "phongchieu")
	private Set<ghe> ghe= new HashSet<>();
	
	@OneToMany(mappedBy = "phongchieu")
	private Set<lichchieu> lichchieu = new HashSet<>();
}
