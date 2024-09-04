package com.poly.entityReport.ghe;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class gheByMaPC {
	@Id
	private Serializable maghe;
	private Long countghe;
	private Integer maphongchieu;
	private Integer loaighe;
	private Integer trangthai;
}
