package com.baitapjava.trangtintuc.Controller;

import com.baitapjava.trangtintuc.Service.LikeServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class LikeController {

    @Autowired
    LikeServiceImplement service;

    @PostMapping("/addLike")
    public void addLike(@RequestParam int baiBaoId, @RequestParam int userId) {
         service.addLike(baiBaoId,userId);
    }

    @PostMapping("/removeLike")
    public void removeLike(@RequestParam int baiBaoId, @RequestParam int userId) {
         service.removeLike(baiBaoId,userId);
    }

    @GetMapping("/getLikeByBaiBaoid")
    public int getLikeByBaiBaoid(@RequestParam int baiBaoId) {
        return service.getLikesByBaiBaoId(baiBaoId);
    }
}
