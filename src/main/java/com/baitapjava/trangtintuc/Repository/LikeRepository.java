package com.baitapjava.trangtintuc.Repository;

import com.baitapjava.trangtintuc.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into likes (bai_bao_id, user_id) VALUES (:bai_bao_id, :user_id)",nativeQuery = true )
    void addLike (@Param("bai_bao_id") int bai_bao_id, @Param("user_id") int user_id);

    @Transactional
    @Modifying
    @Query(value = "delete from likes where bai_bao_id = :bai_bao_id and user_id = :user_id",nativeQuery = true )
    void removeLike (@Param("bai_bao_id") int bai_bao_id, @Param("user_id") int user_id);

    @Query(value = "select count(bai_bao_id) from trangtintuc.likes where bai_bao_id = :bai_bao_id",nativeQuery = true )
    int getLikesByBaiBaoId (@Param("bai_bao_id") int bai_bao_id);

}
