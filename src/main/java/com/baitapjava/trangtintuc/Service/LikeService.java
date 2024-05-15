package com.baitapjava.trangtintuc.Service;

public interface LikeService {
    void addLike (int userId, int baiBaoid);

    void removeLike (int userId, int baiBaoid);

    int getLikesByBaiBaoId (int baiBaoid);

}
