package com.baitapjava.trangtintuc.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baitapjava.trangtintuc.Entity.Baibao;
@Repository
public interface BaibaoRepository extends JpaRepository<Baibao, Integer> {
	
		@Query(value = "select * from trangtintuc.baibao \r\n"
				+ "where ten_bai_bao like %:search% ",nativeQuery = true)
		List<Baibao> searchBaibao(@Param("search") String search);
		
		@Query(value = "SELECT * FROM trangtintuc.baibao \r\n"
				+ "where ten_bai_bao like %:search% \r\n"
				+ "or tac_gia like %:search% \r\n"
				+ "or the_loai like %:search% \r\n"
				+ "order by id desc" ,nativeQuery = true)
		Page<Baibao> listBaoPaging(@Param("search") String search,Pageable pageaeble);
		
		@Query(value = "select * from trangtintuc.baibao\r\n"
				+ "where the_loai like %:theloai% \r\n"
				+ "and id != :id \r\n"
				+ "order by id desc",nativeQuery = true)
		List<Baibao> listLienQuan(@Param("theloai") String theloai,@Param("id") int id);
		
		@Query(value = "select * from trangtintuc.baibao\r\n"
				+ "order by luot_xem desc",nativeQuery = true)
		List<Baibao> listNoiBat();
		
		@Query(value = "select * from trangtintuc.baibao\r\n"
				+ "where the_loai like %:theloai%\r\n"
				+ "order by id desc",nativeQuery = true)
		List<Baibao> listTheLoai(@Param("theloai") String theloai);
		
		@Query(value = "select * from trangtintuc.baibao \r\n"
				+ "where user_id = :id \r\n"
				+ "and (ten_bai_bao like %:search% or the_loai like %:search%)\r\n"
				+ "order by id desc",nativeQuery = true)
		Page<Baibao> listBaibaoAuthor(@Param("search") String search,@Param("id") int id,Pageable pageaeble);
}
