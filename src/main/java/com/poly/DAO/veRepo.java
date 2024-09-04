package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.ve;
import com.poly.entityReport.doanhthuReport.AllOrders;

public interface veRepo extends JpaRepository<ve, Integer> {
	@Query("SELECT new AllOrders(v.mave , nv.manv, p.maphim, p.hinhanh , v.tongsoghe, v.tongtien , v.trangthai)"
			+ " FROM ve v JOIN v.nhanvien nv JOIN v.lichchieu lc JOIN lc.phim p "
			+ " GROUP BY v.mave, nv.manv, p.maphim, p.hinhanh, v.tongsoghe, v.tongtien, v.trangthai")
			List<AllOrders> getAllOrders();

}
