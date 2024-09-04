package com.poly.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name="daodien")
public class daodien {
	@Id
	@Column(name="madaodien")
	private String madaodien;
	
	@Column(name="tendaodien")
	private String tendaodien;
	
	@ManyToMany(mappedBy = "daodien") 
	private Set<phim> phim= new HashSet<>();
}
