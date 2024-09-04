package com.poly.entityReport.doanhthuReport;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllOrders implements Serializable {
	private Serializable mave;
//	private String tenkhachhang;
	private String tennhanvien;
	private Integer maphim;
	private String hinhanh;
	private Integer tongsove;
	private Integer tongtien;
	private Integer trangthai;
}
