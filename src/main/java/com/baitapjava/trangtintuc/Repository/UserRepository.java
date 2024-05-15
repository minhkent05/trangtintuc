package com.baitapjava.trangtintuc.Repository;
import com.baitapjava.trangtintuc.Entity.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM trangtintuc.user "
            + "where tai_khoan =:taikhoan and mat_khau =:matkhau", nativeQuery = true)
    User userLogin(@Param("taikhoan") String taikhoan, @Param("matkhau") String matkhau);

    @Query(value = "select count(tai_khoan)from trangtintuc.user  where tai_khoan = :ten"
            , nativeQuery = true)
    int checkUser(@Param("ten") String ten);

    @Query(value = "select id from trangtintuc.user where ten_nguoi_dung = :ten", nativeQuery = true)
    int getID(@Param("ten") String ten);

    @Modifying
    @Transactional
    @Query(value = "insert into trangtintuc.user_role (user_id,role_id) values (:idUser,2)", nativeQuery = true)
    int insertRole(@Param("idUser") int idUser);

    @Modifying
    @Transactional
    @Query(value = "delete from user_role where user_id = :id", nativeQuery = true)
    void deleteUserInUser_Role(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from user where id = :id", nativeQuery = true)
    void deleteUser(@Param("id") Integer id);

			User findBytaikhoan(String username);
			
			@Query(value = "SELECT * FROM trangtintuc.user \r\n"
					+ "where tai_khoan like %:search% or email like %:search% \r\n"
					+ "order by id desc" ,nativeQuery = true)
			Page<User> listUserPaging(@Param("search") String search,Pageable pageaeble);
			
			@Query(value = "SELECT id,namerole\r\n"
					+ "FROM  role\r\n"
					+ "WHERE NOT EXISTS(\r\n"
					+ "SELECT NULL\r\n"
					+ "FROM user_role\r\n"
					+ "WHERE user_id = :idUser\r\n"
					+ "AND role_id = role.id)",nativeQuery = true)
			List<Object> listRole(@Param("idUser") int idUser);
			
			@Modifying
			@Transactional
			@Query(value = "insert into trangtintuc.user_role (user_id,role_id) values (:idUser,:idRole)",nativeQuery = true)
			int insertRoleinUser (@Param("idUser") int idUser,@Param("idRole") int idRole);

}
