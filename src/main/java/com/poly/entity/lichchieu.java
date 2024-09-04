package com.poly.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="lichchieu")
public class lichchieu implements Serializable {
	@Id
	@Column(name="malichchieu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer malichchieu;
	
	  @Column(name = "ngaychieu")
    private LocalDate ngaychieu;

    @Column(name = "giochieu")
    private String giochieu;
	
	@ManyToOne
	@JoinColumn(name="maphim")
	private phim phim;
	
	@ManyToOne
	@JoinColumn(name="maphongchieu")
	private phongchieu phongchieu;
	
	@OneToMany(mappedBy = "lichchieu")
	private List<ve> ls_ve;
}
