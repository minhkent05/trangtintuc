package com.baitapjava.trangtintuc.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baitapjava.trangtintuc.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
			@Query(value = "SELECT * FROM trangtintuc.user "
					+ "where tai_khoan =:taikhoan and mat_khau =:matkhau",nativeQuery = true)
			User userLogin (@Param("taikhoan") String taikhoan,@Param("matkhau") String matkhau);
			
			@Query(value = "select count(tai_khoan)from trangtintuc.user  where tai_khoan = :ten"
					,nativeQuery = true)
			int checkUser (@Param("ten") String ten);
			
			@Query(value = "select id from trangtintuc.user where ten_nguoi_dung = :ten",nativeQuery = true)
			int getID(@Param("ten") String ten);
			
			@Modifying
			@Transactional
			@Query(value = "insert into trangtintuc.user_role (user_id,role_id) values (:idUser,2)",nativeQuery = true)
			int insertRole (@Param("idUser") int idUser);
			
			@Modifying
			@Transactional
			@Query(value = "delete from user_role where user_id = :id",nativeQuery = true)
			void deleteUserInUser_Role(@Param("id") Integer id);
			
			@Modifying
			@Transactional
			@Query(value = "delete from user where id = :id",nativeQuery = true)
			void deleteUser(@Param("id") Integer id);
}
