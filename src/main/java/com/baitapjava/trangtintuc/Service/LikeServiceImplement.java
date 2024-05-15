package com.baitapjava.trangtintuc.Service;

import com.baitapjava.trangtintuc.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImplement implements LikeService{

    @Autowired
    LikeRepository res;
    @Override
    public void addLike(int baiBaoid, int userId) {
         res.addLike(baiBaoid,userId);
    }

    @Override
    public void removeLike(int baiBaoid, int userId) {
         res.removeLike(baiBaoid,userId);
    }

    @Override
    public int getLikesByBaiBaoId(int baiBaoid) {
        return res.getLikesByBaiBaoId(baiBaoid);
    }
}
