package com.poly.entityReport;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LichChieuResult {
	@Id
	private String tenphim;
    private String tenphongchieu;
    private LocalDate ngaychieu;
    private String giochieu;
    private Long countghe;
    private Integer maphongchieu;
    private Integer malichchieu;
}
